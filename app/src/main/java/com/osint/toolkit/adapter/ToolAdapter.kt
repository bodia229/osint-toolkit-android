package com.osint.toolkit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osint.toolkit.data.FavoritesManager
import com.osint.toolkit.databinding.ItemToolBinding
import com.osint.toolkit.model.Tool

class ToolAdapter(
    private val items: MutableList<Tool>,
    private val context: Context,
    private val onOpen: (Tool) -> Unit,
    private val onFavChanged: (() -> Unit)? = null
) : RecyclerView.Adapter<ToolAdapter.VH>() {

    inner class VH(val b: ItemToolBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemToolBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val tool = items[position]
        holder.b.tvName.text = tool.name
        holder.b.tvDesc.text = tool.description
        holder.b.tvUrl.text = tool.url.removePrefix("https://").removePrefix("http://")

        val isFav = FavoritesManager.isFavorite(context, tool.id)
        holder.b.btnFav.text = if (isFav) "★" else "☆"

        holder.b.btnFav.setOnClickListener {
            val newState = FavoritesManager.toggle(context, tool.id)
            holder.b.btnFav.text = if (newState) "★" else "☆"
            onFavChanged?.invoke()
        }

        holder.b.root.setOnClickListener { onOpen(tool) }
    }

    fun updateList(newItems: List<Tool>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
