package com.osint.toolkit.data

import android.content.Context

object FavoritesManager {
    private const val PREFS = "favorites"

    fun isFavorite(ctx: Context, toolId: Int): Boolean {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean("tool_$toolId", false)
    }

    fun toggle(ctx: Context, toolId: Int): Boolean {
        val prefs = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val current = prefs.getBoolean("tool_$toolId", false)
        prefs.edit().putBoolean("tool_$toolId", !current).apply()
        return !current
    }

    fun getFavoriteIds(ctx: Context): Set<Int> {
        val prefs = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return ToolsData.tools.filter { prefs.getBoolean("tool_${it.id}", false) }.map { it.id }.toSet()
    }
}
