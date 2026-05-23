package com.osint.toolkit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osint.toolkit.data.ToolsData
import com.osint.toolkit.databinding.ItemCategoryBinding
import com.osint.toolkit.model.Category

class CategoryAdapter(
    private val items: List<Category>,
    private val onClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.VH>() {

    inner class VH(val b: ItemCategoryBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val cat = items[position]
        holder.b.tvEmoji.text = cat.emoji
        holder.b.tvName.text = cat.name
        val count = ToolsData.tools.count { it.categoryId == cat.id }
        holder.b.tvCount.text = "$count tools"
        holder.b.card.setCardBackgroundColor(cat.color)
        holder.b.root.setOnClickListener { onClick(cat) }
    }
}
