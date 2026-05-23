package com.osint.toolkit

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.osint.toolkit.adapter.CategoryAdapter
import com.osint.toolkit.adapter.ToolAdapter
import com.osint.toolkit.data.FavoritesManager
import com.osint.toolkit.data.SmartSearch
import com.osint.toolkit.data.ToolsData
import com.osint.toolkit.databinding.ActivityMainBinding
import com.osint.toolkit.model.Category
import com.osint.toolkit.model.Tool

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding
    private var currentTab = 0
    private var selectedCategory: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnHome.setOnClickListener { showTab(0) }
        b.btnSearch.setOnClickListener { showTab(1) }
        b.btnFavorites.setOnClickListener { showTab(2) }
        b.btnBack.setOnClickListener { selectedCategory = null; showHome() }

        b.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { runSmartSearch(s.toString()) }
            override fun afterTextChanged(s: Editable?) {}
        })

        b.btnDirectOpen.setOnClickListener {
            val url = b.btnDirectOpen.tag as? String ?: return@setOnClickListener
            openUrl("Smart Search", url)
        }

        showTab(0)
    }

    override fun onResume() {
        super.onResume()
        if (currentTab == 2) showFavorites()
    }

    private fun showTab(tab: Int) {
        currentTab = tab
        b.btnHome.alpha = if (tab == 0) 1f else 0.5f
        b.btnSearch.alpha = if (tab == 1) 1f else 0.5f
        b.btnFavorites.alpha = if (tab == 2) 1f else 0.5f
        when (tab) {
            0 -> showHome()
            1 -> showSearch()
            2 -> showFavorites()
        }
    }

    // ---- HOME ----
    private fun showHome() {
        b.layoutSearch.visibility = View.GONE
        b.cardSmartResult.visibility = View.GONE
        b.btnBack.visibility = View.GONE
        if (selectedCategory == null) {
            b.tvTitle.text = "OSINT Toolkit"
            showCategories()
        } else {
            b.tvTitle.text = selectedCategory!!.name
            b.btnBack.visibility = View.VISIBLE
            showToolsForCategory(selectedCategory!!)
        }
    }

    private fun showCategories() {
        b.tvEmpty.visibility = View.GONE
        b.recycler.layoutManager = GridLayoutManager(this, 2)
        b.recycler.adapter = CategoryAdapter(ToolsData.categories) { cat ->
            selectedCategory = cat
            b.tvTitle.text = cat.name
            b.btnBack.visibility = View.VISIBLE
            showToolsForCategory(cat)
        }
    }

    private fun showToolsForCategory(cat: Category) {
        b.tvEmpty.visibility = View.GONE
        val tools = ToolsData.tools.filter { it.categoryId == cat.id }.toMutableList()
        b.recycler.layoutManager = LinearLayoutManager(this)
        b.recycler.adapter = ToolAdapter(tools, this, ::openTool)
    }

    // ---- SEARCH ----
    private fun showSearch() {
        b.tvTitle.text = "Smart Search"
        b.btnBack.visibility = View.GONE
        b.layoutSearch.visibility = View.VISIBLE
        runSmartSearch(b.etSearch.text.toString())
    }

    private fun runSmartSearch(query: String) {
        if (currentTab != 1) return
        val result = SmartSearch.analyze(query)

        // Show type banner
        if (query.isNotBlank()) {
            b.cardSmartResult.visibility = View.VISIBLE
            b.tvSmartType.text = "${result.type.emoji}  ${result.type.label}"
            b.tvSmartCount.text = "${result.tools.size} relevant tools"
            try {
                val color = android.graphics.Color.parseColor(result.type.color)
                b.cardSmartResult.setCardBackgroundColor(color)
            } catch (_: Exception) {}

            if (result.directUrl != null) {
                b.btnDirectOpen.visibility = View.VISIBLE
                b.btnDirectOpen.text = "Open best tool →"
                b.btnDirectOpen.tag = result.directUrl
            } else {
                b.btnDirectOpen.visibility = View.GONE
            }
        } else {
            b.cardSmartResult.visibility = View.GONE
        }

        // Show tools — if query looks like structured input, use smart results
        // If it looks like a keyword, also text-filter the smart results
        val finalTools = if (query.isBlank()) {
            ToolsData.tools.toMutableList()
        } else if (result.type != SmartSearch.InputType.UNKNOWN) {
            // Structured input: show relevant category tools
            result.tools.toMutableList()
        } else {
            // Plain keyword: text search all tools
            ToolsData.tools.filter {
                it.name.contains(query, true) || it.description.contains(query, true)
            }.toMutableList()
        }

        b.recycler.layoutManager = LinearLayoutManager(this)
        b.recycler.adapter = ToolAdapter(finalTools, this, onOpen = { tool ->
            val smartUrl = SmartSearch.toolUrlWithQuery(tool.name, query)
            if (smartUrl != null && query.isNotBlank() && result.type != SmartSearch.InputType.UNKNOWN) {
                openUrl(tool.name, smartUrl)
            } else {
                openTool(tool)
            }
        })

        b.tvEmpty.visibility = if (finalTools.isEmpty()) View.VISIBLE else View.GONE
        b.tvEmpty.text = "No tools found for \"$query\""
    }

    // ---- FAVORITES ----
    private fun showFavorites() {
        b.tvTitle.text = "Favorites"
        b.layoutSearch.visibility = View.GONE
        b.cardSmartResult.visibility = View.GONE
        b.btnBack.visibility = View.GONE
        val favIds = FavoritesManager.getFavoriteIds(this)
        val favTools = ToolsData.tools.filter { it.id in favIds }.toMutableList()
        b.recycler.layoutManager = LinearLayoutManager(this)
        b.recycler.adapter = ToolAdapter(favTools, this, ::openTool) { showFavorites() }
        b.tvEmpty.visibility = if (favTools.isEmpty()) View.VISIBLE else View.GONE
        b.tvEmpty.text = "No favorites yet\nTap ☆ on any tool to save it"
    }

    // ---- NAVIGATION ----
    private fun openTool(tool: Tool) = openUrl(tool.name, tool.url)

    private fun openUrl(title: String, url: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url", url)
        intent.putExtra("title", title)
        startActivity(intent)
    }
}
