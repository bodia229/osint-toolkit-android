package com.osint.toolkit.data

import android.graphics.Color
import com.osint.toolkit.model.Category
import com.osint.toolkit.model.Tool

object ToolsData {

    val categories = listOf(
        Category(1,  "Search Engines",       "🔍", Color.parseColor("#1565C0")),
        Category(2,  "Advanced Search",      "🧠", Color.parseColor("#283593")),
        Category(3,  "Username Search",      "👤", Color.parseColor("#6A1B9A")),
        Category(4,  "Email",                "📧", Color.parseColor("#1B5E20")),
        Category(5,  "Phone",                "📱", Color.parseColor("#E65100")),
        Category(6,  "Personal Data",        "🪪", Color.parseColor("#880E4F")),
        Category(7,  "VKontakte",            "💙", Color.parseColor("#0D47A1")),
        Category(8,  "Facebook",             "👥", Color.parseColor("#1A237E")),
        Category(9,  "Instagram",            "📸", Color.parseColor("#AD1457")),
        Category(10, "Twitter / X",          "🐦", Color.parseColor("#006064")),
        Category(11, "YouTube",              "▶️", Color.parseColor("#B71C1C")),
        Category(12, "Telegram",             "✈️", Color.parseColor("#006064")),
        Category(13, "Discord",              "🎮", Color.parseColor("#311B92")),
        Category(14, "TikTok / Reddit",      "🎵", Color.parseColor("#4A148C")),
        Category(15, "Reverse Image",        "🖼️", Color.parseColor("#BF360C")),
        Category(16, "Image & Video",        "🎞️", Color.parseColor("#33691E")),
        Category(17, "Maps & Geolocation",   "🗺️", Color.parseColor("#004D40")),
        Category(18, "Satellite",            "🛰️", Color.parseColor("#1B5E20")),
        Category(19, "Transport",            "✈️", Color.parseColor("#0D47A1")),
        Category(20, "Domain & IP",          "🌐", Color.parseColor("#212121")),
        Category(21, "Web Archives",         "📦", Color.parseColor("#37474F")),
        Category(22, "Files & Docs",         "📄", Color.parseColor("#4E342E")),
        Category(23, "Data Breaches",        "🔓", Color.parseColor("#B71C1C")),
        Category(24, "Malware & URL",        "🦠", Color.parseColor("#1B5E20")),
        Category(25, "Business Intel",       "🏢", Color.parseColor("#E65100")),
        Category(26, "Fact Checking",        "✅", Color.parseColor("#1565C0")),
        Category(27, "Utilities",            "🛠️", Color.parseColor("#263238")),
        Category(28, "Conflict Maps",        "⚔️", Color.parseColor("#B71C1C")),
        Category(29, "Audio",                "🔊", Color.parseColor("#4A148C")),
        Category(30, "SMS & Temp",           "💬", Color.parseColor("#33691E"))
    )

    val tools = listOf(
        // 1 - Search Engines
        Tool(1,  "Google",        "https://www.google.com",       "Primary search engine", 1),
        Tool(2,  "Yandex",        "https://yandex.com",           "Russian search engine", 1),
        Tool(3,  "Bing",          "https://www.bing.com",         "Microsoft search engine", 1),
        Tool(4,  "DuckDuckGo",    "https://duckduckgo.com",       "Privacy-focused search", 1),
        Tool(5,  "Brave Search",  "https://search.brave.com",     "Independent search engine", 1),
        Tool(6,  "Searx",         "https://searx.info",           "Meta-search engine", 1),

        // 2 - Advanced Search
        Tool(7,  "OSINT Rocks",   "https://osint.rocks",          "Username, email, phone tools", 2),
        Tool(8,  "SearchAll",     "https://www.searchall.net",    "Multi-source rapid queries", 2),
        Tool(9,  "Synapsint",     "https://synapsint.com",        "Unified research platform", 2),
        Tool(10, "Cylect.io",     "https://cylect.io",            "OSINT search with integrated tools", 2),
        Tool(11, "2lingual",      "https://2lingual.com",         "Dual-language Google search", 2),
        Tool(12, "DorkGPT",       "https://www.dorkgpt.com",      "Google dork generator", 2),

        // 3 - Username Search
        Tool(13, "WhatsMyName",   "https://whatsmyname.app",      "Username across multiple sites", 3),
        Tool(14, "Maigret",       "https://github.com/soxoj/maigret", "Search 3000+ sites for username", 3),
        Tool(15, "Sherlock",      "https://github.com/sherlock-project/sherlock", "Username discovery tool", 3),
        Tool(16, "Snoop",         "https://github.com/snooppr/snoop", "Enhanced Sherlock fork (RU)", 3),
        Tool(17, "NameCheckup",   "https://namecheckup.com",      "Username availability checker", 3),

        // 4 - Email
        Tool(18, "Epieos",        "https://epieos.com",           "Email registration tracker", 4),
        Tool(19, "Hunter.io",     "https://hunter.io/email-verifier", "Email validation", 4),
        Tool(20, "Holehe",        "https://github.com/megadose/holehe", "Social network by email", 4),
        Tool(21, "GHunt",         "https://github.com/mxrch/GHunt", "Google account intelligence", 4),
        Tool(22, "HaveIBeenPwned","https://haveibeenpwned.com",   "Data breach verification", 4),

        // 5 - Phone
        Tool(23, "PhoneInfoga",   "https://github.com/sundowndev/phoneinfoga", "Phone number analysis", 5),
        Tool(24, "OpenCellID",    "https://opencellid.org",       "Mobile base station mapping", 5),
        Tool(25, "IMEI24",        "https://imei24.com",           "Device IMEI verification", 5),
        Tool(26, "SNDeep",        "https://sndeep.info",          "Device serial number lookup", 5),
        Tool(27, "411.com",       "https://www.411.com",          "USA phone/address lookup", 5),
        Tool(28, "WhitePages",    "https://www.whitepages.com",   "US residential directory", 5),
        Tool(29, "192.com",       "https://www.192.com",          "UK phone and property info", 5),

        // 6 - Personal Data
        Tool(30, "OSINTKit",      "https://osintkit.net",         "Russian personal data aggregator", 6),
        Tool(31, "SignalHire",    "https://www.signalhire.com",   "Email/phone data lookup", 6),
        Tool(32, "OSINT Industries","https://www.osint.industries","Global data aggregation", 6),
        Tool(33, "X-Ray Contact", "https://x-ray.contact",       "International personal data", 6),

        // 7 - VKontakte
        Tool(34, "220VK",         "https://220vk.com",            "VK profile analysis", 7),
        Tool(35, "VK.City4me",    "http://vk.city4me.com",        "VK activity monitoring", 7),
        Tool(36, "VKDia",         "https://vkdia.com",            "VK friend network surveillance", 7),
        Tool(37, "Photo-Map.ru",  "http://photo-map.ru",          "Geo-location photo discovery VK", 7),

        // 8 - Facebook
        Tool(38, "WhoPostedWhat", "https://whopostedwhat.com",    "Post search by date/location", 8),
        Tool(39, "Graph.tips",    "https://graph.tips/beta/",     "Advanced FB filtering", 8),
        Tool(40, "Lookup-ID",     "https://lookup-id.com",        "Facebook ID retrieval", 8),

        // 9 - Instagram
        Tool(41, "Osintgram",     "https://github.com/Datalux/Osintgram", "Instagram profile analytics", 9),
        Tool(42, "Instaloader",   "https://github.com/instaloader/instaloader", "Content download", 9),
        Tool(43, "Gramhir",       "https://gramhir.com",          "Profile statistics viewer", 9),
        Tool(44, "Picuki",        "https://www.picuki.com",       "Anonymous profile browsing", 9),

        // 10 - Twitter/X
        Tool(45, "FollowerWonk",  "https://followerwonk.com",     "Account analysis", 10),
        Tool(46, "Foller.me",     "https://foller.me",            "User research and tracking", 10),
        Tool(47, "Wayback Tweets","https://waybacktweets.streamlit.app", "Deleted tweet recovery", 10),
        Tool(48, "Tweet-Mapper",  "https://github.com/keitharm/Tweet-Mapper", "Geo-tagged tweet mapping", 10),

        // 11 - YouTube
        Tool(49, "YouTube OSINT", "https://github.com/cqcore/YouTube-Video-OSINT", "Video analysis tools", 11),
        Tool(50, "Filmot",        "https://filmot.com",           "Video search by caption", 11),
        Tool(51, "Hadzy",         "https://hadzy.com/",           "Comment viewer", 11),
        Tool(52, "CommentPicker", "https://commentpicker.com/youtube-video-id.php", "Video ID extraction", 11),

        // 12 - Telegram
        Tool(53, "TelegramDB",    "https://www.telegramdb.org",   "Account info and group discovery", 12),
        Tool(54, "Telemetr.io",   "https://telemetr.io",          "Channel analytics", 12),
        Tool(55, "Telegago",      "https://cse.google.com/cse?cx=006368593537057042503:efxu7xprihg#gsc.tab=0", "Telegram channel search", 12),

        // 13 - Discord
        Tool(56, "DiscordBee",    "https://discordbee.com",       "Server discovery", 13),
        Tool(57, "Disboard",      "https://disboard.org",         "Server database", 13),
        Tool(58, "Snow Stamp",    "https://pixelatomy.com/snow-stamp", "Account/server age verification", 13),

        // 14 - TikTok / Reddit
        Tool(59, "TikTok ID Finder","https://www.famety.net/find-tiktok-user-id", "TikTok account ID", 14),
        Tool(60, "URLebird",      "https://urlebird.com",         "TikTok stats without registration", 14),
        Tool(61, "Cobalt Tools",  "https://cobalt.tools",         "Video download", 14),
        Tool(62, "Reddit Comment Search","https://redditcommentsearch.com", "User comment lookup", 14),

        // 15 - Reverse Image
        Tool(63, "FaceCheck.id",  "https://facecheck.id",         "Facial recognition across web", 15),
        Tool(64, "Search4Faces",  "https://search4faces.com",     "VK/OK face search", 15),
        Tool(65, "PimEyes",       "https://pimeyes.com",          "Deep image search", 15),
        Tool(66, "TinEye",        "https://tineye.com",           "Reverse image identification", 15),
        Tool(67, "Image-Search",  "https://www.image-search.org", "Multi-engine reverse search", 15),

        // 16 - Image & Video Analysis
        Tool(68, "ImgLarger",     "https://imglarger.com",        "Image upscaling", 16),
        Tool(69, "Remini",        "https://app.remini.ai",        "Image quality enhancement", 16),
        Tool(70, "Remove.bg",     "https://www.remove.bg",        "Background removal", 16),
        Tool(71, "ImageColorizer","https://imagecolorizer.com/enhance", "B&W photo colorization", 16),
        Tool(72, "Deepware",      "https://scanner.deepware.ai",  "Deepfake detection", 16),
        Tool(73, "GeoSpy",        "https://geospy.web.app",       "Image geolocation analysis", 16),
        Tool(74, "GeoEstimation", "https://labs.tib.eu/geoestimation/", "Photo location estimation", 16),

        // 17 - Maps & Geolocation
        Tool(75, "OpenStreetMap", "https://www.openstreetmap.org","Detailed public mapping", 17),
        Tool(76, "Wikimapia",     "http://wikimapia.org",         "Community-edited map", 17),
        Tool(77, "SunCalc",       "https://www.suncalc.org",      "Solar position mapping", 17),
        Tool(78, "Felt",          "https://felt.com",             "Custom map creation", 17),
        Tool(79, "Skylens",       "https://app.skylens.io",       "Geo-tagged social posts", 17),
        Tool(80, "Smappen",       "https://www.smappen.com",      "Distance/time analysis", 17),

        // 18 - Satellite
        Tool(81, "Zoom.Earth",    "https://zoom.earth",           "Real-time satellite imagery", 18),
        Tool(82, "Sentinel Hub",  "https://apps.sentinel-hub.com/eo-browser/", "Satellite imagery viewer", 18),
        Tool(83, "NASA WorldView","https://worldview.earthdata.nasa.gov", "NASA satellite data", 18),

        // 19 - Transport
        Tool(84, "Flightradar24", "https://www.flightradar24.com","Real-time flight monitoring", 19),
        Tool(85, "MarineTraffic", "https://www.marinetraffic.com","Ship AIS tracking", 19),
        Tool(86, "VesselFinder",  "https://www.vesselfinder.com", "Vessel location tracking", 19),
        Tool(87, "OpenRailway",   "https://www.openrailwaymap.org","Railway mapping", 19),

        // 20 - Domain & IP
        Tool(88, "Web-Check",     "https://web-check.as93.net",   "Domain/IP comprehensive report", 20),
        Tool(89, "DomainTools",   "https://whois.domaintools.com","Domain ownership data", 20),
        Tool(90, "Netcraft",      "https://sitereport.netcraft.com/","Technology stack identification", 20),
        Tool(91, "2IP.ru",        "https://2ip.ru",               "IP and domain checking", 20),
        Tool(92, "URLScan.io",    "https://urlscan.io",           "URL scanning and analysis", 20),
        Tool(93, "CloakQuest3r",  "https://github.com/spyboy-productions/CloakQuest3r", "Cloudflare IP disclosure", 20),

        // 21 - Web Archives
        Tool(94, "Wayback Machine","https://archive.org",         "Web archive", 21),
        Tool(95, "Archive.is",    "https://archive.is",           "Alternative web archive", 21),
        Tool(96, "CachedView",    "https://cachedview.nl",        "Google cached pages", 21),

        // 22 - Files & Docs
        Tool(97, "Metagoofil",    "https://github.com/opsdisk/metagoofil", "Metadata from site docs", 22),
        Tool(98, "IntelX Files",  "https://intelx.io/tools?tab=file", "File discovery", 22),
        Tool(99, "DeDiger",       "https://www.dedigger.com",     "Public Google Drive files", 22),
        Tool(100,"GrayHat Buckets","https://buckets.grayhatwarfare.com","Open server folder discovery", 22),

        // 23 - Data Breaches
        Tool(101,"HaveIBeenPwned","https://haveibeenpwned.com",   "Breach database check", 23),
        Tool(102,"Dehashed",      "https://www.dehashed.com",     "Breach database search", 23),
        Tool(103,"Exposed.lol",   "https://exposed.lol",          "Leaked email/password lookup", 23),

        // 24 - Malware & URL
        Tool(104,"VirusTotal",    "https://www.virustotal.com",   "File and URL scanning", 24),
        Tool(105,"URLhaus",       "https://urlhaus.abuse.ch",     "Malicious URL database", 24),
        Tool(106,"URLScan",       "https://urlscan.io",           "URL analysis", 24),

        // 25 - Business Intel
        Tool(107,"OpenCorporates","https://opencorporates.com",   "Global company registry", 25),
        Tool(108,"OpenOwnership", "https://register.openownership.org","Beneficial ownership", 25),
        Tool(109,"OffshoreLeaks", "https://offshoreleaks.icij.org","Offshore entity database", 25),
        Tool(110,"OpenSanctions", "https://www.opensanctions.org","Sanctions list search", 25),

        // 26 - Fact Checking
        Tool(111,"Google FactCheck","https://toolbox.google.com/factcheck","Claim verification", 26),
        Tool(112,"DocumentCloud", "https://www.documentcloud.org","Public document repository", 26),

        // 27 - Utilities
        Tool(113,"CyberChef",     "https://gchq.github.io/CyberChef/","Encoding/decoding converter", 27),
        Tool(114,"Google Alerts", "https://www.google.com/alerts","Topic monitoring service", 27),
        Tool(115,"Google Pinpoint","https://journaliststudio.google.com/pinpoint","Document indexing", 27),
        Tool(116,"DiffChecker",   "https://www.diffchecker.com",  "Text and image comparison", 27),
        Tool(117,"Canarytokens",  "https://canarytokens.org",     "Honeypot link creation", 27),

        // 28 - Conflict Maps
        Tool(118,"DeepState Map", "https://deepstatemap.live",    "Ukraine conflict visualization", 28),
        Tool(119,"LiveUAMap",     "https://liveuamap.com",        "Conflict tracking", 28),
        Tool(120,"Eyes on Russia","https://eyesonrussia.org",     "Social media war docs", 28),

        // 29 - Audio
        Tool(121,"TubeRipper",    "https://tuberipper.com",       "YouTube audio extraction", 29),
        Tool(122,"AudioChum",     "https://audiochum.com",        "Voice isolation", 29),

        // 30 - SMS & Temp Numbers
        Tool(123,"ReceiveSMS",    "https://www.receivesmsonline.net","Temporary phone SMS", 30),
        Tool(124,"SMSReceiveFree","https://smsreceivefree.com",   "Disposable number service", 30)
    )
}
