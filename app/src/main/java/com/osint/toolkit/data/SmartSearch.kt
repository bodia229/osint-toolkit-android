package com.osint.toolkit.data

import com.osint.toolkit.model.Tool

object SmartSearch {

    enum class InputType(val label: String, val emoji: String, val color: String) {
        EMAIL    ("Email address",       "📧", "#1B5E20"),
        PHONE    ("Phone number",        "📱", "#E65100"),
        IP       ("IP address",          "🌐", "#212121"),
        DOMAIN   ("Domain / URL",        "🔗", "#006064"),
        USERNAME ("Username / nickname", "👤", "#6A1B9A"),
        NAME     ("Full name / FIO",     "🪪", "#880E4F"),
        HASH     ("Hash / MD5 / SHA",    "🔓", "#B71C1C"),
        VK_ID    ("VK profile ID",       "💙", "#0D47A1"),
        COORDS   ("Coordinates",         "📍", "#004D40"),
        UNKNOWN  ("All tools",           "🔍", "#263238")
    }

    data class SmartResult(
        val type: InputType,
        val tools: List<Tool>,
        val directUrl: String? = null
    )

    fun analyze(raw: String): SmartResult {
        val input = raw.trim()
        if (input.isBlank()) return SmartResult(InputType.UNKNOWN, ToolsData.tools)

        val type = detect(input)
        val tools = getTools(type)
        val url = buildDirectUrl(type, input)
        return SmartResult(type, tools, url)
    }

    private fun detect(input: String): InputType {
        // Email
        if (Regex("^[\\w.+\\-]+@[\\w\\-]+\\.[a-zA-Z]{2,}$").containsMatchIn(input))
            return InputType.EMAIL

        // IP address
        if (Regex("^(\\d{1,3}\\.){3}\\d{1,3}$").matches(input))
            return InputType.IP

        // Coordinates  lat,lon  or  lat lon
        if (Regex("^-?\\d{1,3}[.,]\\d+[,\\s]+-?\\d{1,3}[.,]\\d+$").matches(input))
            return InputType.COORDS

        // Phone (international or local)
        if (Regex("^[+]?[\\d\\s\\-().]{7,18}$").matches(input) &&
            input.count { it.isDigit() } >= 7)
            return InputType.PHONE

        // Hash MD5/SHA1/SHA256
        if (Regex("^[0-9a-fA-F]{32}$").matches(input) ||
            Regex("^[0-9a-fA-F]{40}$").matches(input) ||
            Regex("^[0-9a-fA-F]{64}$").matches(input))
            return InputType.HASH

        // VK numeric ID or vk.com/id...
        if (Regex("^(https?://)?(vk\\.com/)?(id)?\\d{5,12}$").matches(input))
            return InputType.VK_ID

        // Domain or URL
        if (Regex("^(https?://)?[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z]{2,})+(/.*)?$").matches(input) &&
            !input.contains(" "))
            return InputType.DOMAIN

        // Full name (2-3 words, letters only, 3+ chars each)
        val words = input.trim().split(Regex("\\s+"))
        if (words.size in 2..4 && words.all { it.length >= 2 && it.all { c -> c.isLetter() } })
            return InputType.NAME

        // Username (single word, no spaces, alphanumeric + _ .)
        if (!input.contains(" ") && input.length in 3..50 &&
            Regex("^[a-zA-Z0-9_.\\-]+$").matches(input))
            return InputType.USERNAME

        return InputType.UNKNOWN
    }

    private fun getTools(type: InputType): List<Tool> = when (type) {
        InputType.EMAIL    -> ToolsData.tools.filter { it.categoryId in listOf(4, 23) }
        InputType.PHONE    -> ToolsData.tools.filter { it.categoryId in listOf(5, 6, 30) }
        InputType.IP       -> ToolsData.tools.filter { it.categoryId in listOf(20, 24) }
        InputType.DOMAIN   -> ToolsData.tools.filter { it.categoryId in listOf(20, 21, 24) }
        InputType.USERNAME -> ToolsData.tools.filter { it.categoryId in listOf(3, 7, 8, 9, 10, 11, 12, 13, 14) }
        InputType.NAME     -> ToolsData.tools.filter { it.categoryId in listOf(6, 7, 8, 25) }
        InputType.HASH     -> ToolsData.tools.filter { it.categoryId in listOf(24, 27) }
        InputType.VK_ID    -> ToolsData.tools.filter { it.categoryId == 7 }
        InputType.COORDS   -> ToolsData.tools.filter { it.categoryId in listOf(17, 18) }
        InputType.UNKNOWN  -> ToolsData.tools
    }

    // Build a direct URL with query pre-filled for supported tools
    fun buildDirectUrl(type: InputType, query: String): String? {
        val q = query.trim()
        return when (type) {
            InputType.EMAIL    -> "https://haveibeenpwned.com/account/$q"
            InputType.USERNAME -> "https://whatsmyname.app/?q=$q"
            InputType.DOMAIN,
            InputType.IP       -> "https://web-check.as93.net/$q"
            InputType.HASH     -> "https://www.virustotal.com/gui/search/$q"
            InputType.PHONE    -> "https://osint.rocks/?query=$q"
            else               -> null
        }
    }

    // Get tool URL with query injected (for tools that support it)
    fun toolUrlWithQuery(toolName: String, query: String): String? {
        val q = java.net.URLEncoder.encode(query.trim(), "UTF-8")
        return when (toolName) {
            "WhatsMyName"    -> "https://whatsmyname.app/?q=$q"
            "HaveIBeenPwned" -> "https://haveibeenpwned.com/account/$q"
            "Epieos"         -> "https://epieos.com/?q=$q&t=email"
            "Web-Check"      -> "https://web-check.as93.net/$q"
            "VirusTotal"     -> "https://www.virustotal.com/gui/search/$q"
            "URLScan.io"     -> "https://urlscan.io/search/#$q"
            "DomainTools"    -> "https://whois.domaintools.com/$q"
            "Dehashed"       -> "https://www.dehashed.com/search?query=$q"
            "OpenCorporates" -> "https://opencorporates.com/companies?q=$q"
            "Synapsint"      -> "https://synapsint.com/report.php?q=$q"
            "OSINT Rocks"    -> "https://osint.rocks/?query=$q"
            "Cylect.io"      -> "https://cylect.io/search?query=$q"
            else             -> null
        }
    }
}
