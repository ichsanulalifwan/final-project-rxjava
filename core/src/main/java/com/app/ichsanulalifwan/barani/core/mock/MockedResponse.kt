package com.app.ichsanulalifwan.barani.core.mock

sealed class MockedResponse(val body: String) {

    object NewsListResponse : MockedResponse(
        "{\n" +
                "\"status\": \"ok\",\n" +
                "\"totalResults\": 38,\n" +
                "-\"articles\": [\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"reuters\",\n" +
                "\"name\": \"Reuters\"\n" +
                "},\n" +
                "\"author\": \"Nidal Al-Mughrabi, Emily Rose\",\n" +
                "\"title\": \"US beefs up Mideast military assets as Israel pounds Gaza and beyond - Reuters\",\n" +
                "\"description\": \"Fears that the Israel-Palestinian conflict might spread through the Middle East ratcheted higher on Sunday, with the U.S. sending more military assets to the region as Israel pummelled targets in Gaza and elsewhere.\",\n" +
                "\"url\": \"https://www.reuters.com/world/middle-east/israel-intensify-gaza-strikes-us-pushes-more-aid-2023-10-22/\",\n" +
                "\"urlToImage\": \"https://www.reuters.com/resizer/KuFG6M7GHWJ1HbFsepBh8DtTSbE=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/45NQC7HOSRKALFWB5VE5DPVEWU.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T06:00:30Z\",\n" +
                "\"content\": \"GAZA/JERUSALEM, Oct 22 (Reuters) - Fears that the Israel-Palestinian conflict might spread through the Middle East ratcheted higher on Sunday, with the U.S. sending more military assets to the region… [+5301 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"The Times of Israel\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"IDF carries out airstrike on terror cell at Jenin mosque planning ‘imminent attack’ - The Times of Israel\",\n" +
                "\"description\": \"2 said killed in what may be the 1st fighter jet attack in West Bank in 20 years; military, Shin Bet say Hamas, Islamic Jihad gunmen used al-Ansari mosque as base of operations\",\n" +
                "\"url\": \"https://www.timesofisrael.com/idf-carries-out-airstrike-on-terror-cell-at-jenin-mosque-planning-imminent-attack/\",\n" +
                "\"urlToImage\": \"https://static.timesofisrael.com/www/uploads/2023/07/44rFUmU-e1688463295948-1024x640.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T05:52:16Z\",\n" +
                "\"content\": \"Israeli forces carries out an airstrike, apparently from a fighter jet, on a tunnel used by terror group members at a mosque in the northern West Bank city of Jenin early on Sunday, the Israel Defens… [+4022 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"NDTV News\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"Israel Steps Up Bombing After Gaza Receives Aid, Attacks West Bank Mosque - NDTV\",\n" +
                "\"description\": \"The Israeli military announced it was stepping up its bombardment of Hamas-controlled Gaza Saturday just hours after the first aid trucks arrived from Egypt bringing desperately needed relief to civilians in the war-torn enclave.\",\n" +
                "\"url\": \"https://www.ndtv.com/world-news/israel-steps-up-bombing-after-gaza-receives-aid-attacks-west-bank-mosque-4503893\",\n" +
                "\"urlToImage\": \"https://c.ndtvimg.com/2023-10/nqhs48t4_gaza-bombarded-afp_625x300_22_October_23.jpeg?ver-20231016.06\",\n" +
                "\"publishedAt\": \"2023-10-22T05:48:00Z\",\n" +
                "\"content\": \"Gaza Strip: Israel's military said Saturday it would intensify strikes on Hamas-controlled Gaza ahead of a planned ground invasion, as UN agencies warned of a \\\"catastrophic\\\" humanitarian situation in… [+6329 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"Suntimes.com\"\n" +
                "},\n" +
                "\"author\": \"Georgia Nicols\",\n" +
                "\"title\": \"Horoscope for Sunday, Oct. 22, 2023 - Chicago Sun-Times\",\n" +
                "\"description\": null,\n" +
                "\"url\": \"https://chicago.suntimes.com/2023/10/22/23923134/horoscopes-today-sunday-oct-22-2023\",\n" +
                "\"urlToImage\": \"https://cst.brightspotcdn.com/dims4/default/dbaaf98/2147483647/strip/true/crop/870x497+0+67/resize/1461x834!/quality/90/?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2FTFkiCiySDPyEYQ64TztaotlHez0%3D%2F0x0%3A870x630%2F870x630%2Ffilters%3Afocal%28435x315%3A436x316%29%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_asset%2Ffile%2F25013292%2FGeorgia_mug.jpeg\",\n" +
                "\"publishedAt\": \"2023-10-22T05:03:27Z\",\n" +
                "\"content\": \"Moon Alert\\r\\nAfter 1:30 a.m. Chicago time, there are no restrictions to shopping or important decisions. The moon is in Aquarius.\\r\\nAries (March 21-April 19)\\r\\nDiscussions about shared property, the wea… [+3833 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"associated-press\",\n" +
                "\"name\": \"Associated Press\"\n" +
                "},\n" +
                "\"author\": \"NAJIB JOBAIN, JOSEPH KRAUSS, SAMY MAGDY\",\n" +
                "\"title\": \"Egypt's border crossing opens to let a trickle of desperately needed aid into besieged Gaza - The Associated Press\",\n" +
                "\"description\": \"The border crossing between Egypt and Gaza has opened to let a trickle of desperately needed aid into the besieged Palestinian territory. This was the first aid allowed in since Israel sealed Gaza off in the wake of Hamas’ bloody rampage two weeks ago. Only 2…\",\n" +
                "\"url\": \"https://apnews.com/article/israel-palestinians-gaza-captives-border-aid-f5976ed58ba508f14d45b72b428125ac\",\n" +
                "\"urlToImage\": \"https://dims.apnews.com/dims4/default/5b85b52/2147483647/strip/true/crop/8640x4860+0+450/resize/1440x810!/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F8e%2F30%2F5955ad4a57dbaeedf60f618af50b%2Fdac88efc26154860aa56658880177607\",\n" +
                "\"publishedAt\": \"2023-10-22T04:24:00Z\",\n" +
                "\"content\": \"RAFAH, Gaza Strip (AP) The border crossing between Egypt and Gaza opened Saturday to let a trickle of desperately needed aid into the besieged Palestinian territory for the first time since Israel se… [+9694 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"NCAA.com\"\n" +
                "},\n" +
                "\"author\": \"NCAA.com\",\n" +
                "\"title\": \"Marvin Harrison Jr. masterclass powers Ohio State past Penn State 20-12 - NCAA.com\",\n" +
                "\"description\": \"Ohio State's leverages Marvin Harrison Jr.'s 11 reception, 162 yard performance to beat Penn State 20-12. Read about all the action from Columbus Saturday here.\",\n" +
                "\"url\": \"https://www.ncaa.com/live-updates/football/fbs/marvin-harrison-jr-masterclass-powers-ohio-state-past-penn-state-20-12\",\n" +
                "\"urlToImage\": \"https://www.ncaa.com/_flysystem/public-s3/images/2023-10/marvin-harrison-touchdown-ohio-state-penn-state.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T04:00:50Z\",\n" +
                "\"content\": \"A punt-filled first quarter Saturday served as two heavyweight fighters feeling out their vaunted opponents, and the lessons learned were pretty evident to the viewing public: Penn State and Ohio Sta… [+2892 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"Fox Business\"\n" +
                "},\n" +
                "\"author\": \"Brie Stimson\",\n" +
                "\"title\": \"2 more San Francisco mail carriers assaulted as federal officials triple reward for soaring number of attacks - Fox Business\",\n" +
                "\"description\": \"Two San Francisco U.S. Postal Service mail carriers last week were just the latest to be attacked by thieves hoping to get away with mail and mailbox keys, as federal officials triple the reward for information to \$150,000.\",\n" +
                "\"url\": \"https://www.foxbusiness.com/fox-news-us/two-more-san-francisco-mail-carriers-assaulted-federal-officials-triple-reward-soaring-number-attacks\",\n" +
                "\"urlToImage\": \"https://a57.foxnews.com/static.foxbusiness.com/foxbusiness.com/content/uploads/2023/10/0/0/postal-worker.jpg?ve=1&tl=1\",\n" +
                "\"publishedAt\": \"2023-10-22T02:51:16Z\",\n" +
                "\"content\": \"Two U.S. Postal Service employees in San Francisco were attacked by robbers last week as federal investigators have tripled the reward leading to arrests related to the increasing number of mail carr… [+2085 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"Spaceflight Now\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"SpaceX Falcon 9 launches 23 Starlink satellites from Cape Canaveral – Spaceflight Now - Spaceflight Now\",\n" +
                "\"description\": \"A SpaceX Falcon 9 rocket launched from Space Launch Complex 40 (SLC-40) at Cape Canaveral Space Force Station at 10:17 p.m. EDT (0217 UTC on Oct. 22) carrying 23 Starlink satellites.\",\n" +
                "\"url\": \"https://spaceflightnow.com/2023/10/21/live-coverage-spacex-falcon-9-to-launch-23-starlink-satellites-from-cape-canaveral/\",\n" +
                "\"urlToImage\": \"https://spaceflightnow.com/wp-content/uploads/2023/10/Liftoff_SFN_Starlink_6-24-small.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T02:47:57Z\",\n" +
                "\"content\": \"A Falcon 9 rocket launches from Cape Canaveral Space Force Station on the Starlink 6-24 mission. Onboard were 23 Starlink satellites heading up to low Earth orbit. Image: Adam Bernstein\\r\\nUpdate 10:17… [+1450 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"cbs-news\",\n" +
                "\"name\": \"CBS News\"\n" +
                "},\n" +
                "\"author\": \"Paul LaRosa\",\n" +
                "\"title\": \"Convicted killer known as the Zombie Hunter says life on death row is cold, food is \\\"not great\\\" - CBS News\",\n" +
                "\"description\": \"Bryan Patrick Miller answers email questions from \\\"48 Hours\\\" about Phoenix canal murders\",\n" +
                "\"url\": \"https://www.cbsnews.com/news/zombie-hunter-bryan-patrick-miller-convicted-killer-death-row-48-hours/\",\n" +
                "\"urlToImage\": \"https://assets2.cbsnewsstatic.com/hub/i/r/2023/10/21/12ac6fcc-3103-483f-b5e6-ff7defc3d578/thumbnail/1200x630/d6db2fdd91fb42e0332625608f1b4219/zombie-prison-mug.jpg?v=18a5d3569ab1a3ca759fe14d213f7845\",\n" +
                "\"publishedAt\": \"2023-10-22T02:45:00Z\",\n" +
                "\"content\": \"Bryan Patrick Miller did not testify at his recent murder trial for killing two young women in the early 1990's but, when a \\\"48 Hours\\\" producer contacted him by email, he was ready to talk about the … [+3646 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"reuters\",\n" +
                "\"name\": \"Reuters\"\n" +
                "},\n" +
                "\"author\": \"Reuters\",\n" +
                "\"title\": \"Foxconn faces tax audit, land use probe - Chinese state media - Reuters\",\n" +
                "\"description\": \"Foxconn Technology Group <a href=\\\"https://www.reuters.com/markets/companies/2317.TW\\\" target=\\\"_blank\\\">(2317.TW)</a>, Apple Inc's <a href=\\\"https://www.reuters.com/markets/companies/AAPL.O\\\" target=\\\"_blank\\\">(AAPL.O)</a> largest supplier of iPhones, has been subje…\",\n" +
                "\"url\": \"https://www.reuters.com/technology/foxconn-faces-tax-audit-land-use-probe-chinese-state-media-2023-10-22/\",\n" +
                "\"urlToImage\": \"https://www.reuters.com/resizer/yUC-40sxyG_HjZXwolfaBx4R9bw=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/ZZVAG2XQ7JKSZCV4IC5JSPP57M.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T02:45:00Z\",\n" +
                "\"content\": \"BEIJING, Oct 22 (Reuters) - Foxconn Technology Group (2317.TW), Apple Inc's (AAPL.O) largest supplier of iPhones, has been subjected to tax audits at some of its key subsidiaries, suspected of violat… [+1125 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"Department of Defense\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"Statement From Secretary of Defense Lloyd J. Austin III on Steps to Increase Force Posture - Department of Defense\",\n" +
                "\"description\": \"Secretary of Defense Lloyd J. Austin III released a statement regarding recent escalations by Iran and its proxy forces across the Middle East region.\",\n" +
                "\"url\": \"https://www.defense.gov/News/Releases/Release/Article/3564874/statement-from-secretary-of-defense-lloyd-j-austin-iii-on-steps-to-increase-for/\",\n" +
                "\"urlToImage\": \"https://media.defense.gov/2021/Sep/30/2002865254/1280/1280/0/210930-D-EX074-055.JPG\",\n" +
                "\"publishedAt\": \"2023-10-22T02:12:22Z\",\n" +
                "\"content\": \"Following detailed discussions with President Biden on recent escalations by Iran and its proxy forces across the Middle East Region, today I directed a series of additional steps to further strength… [+1159 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"Eonline.com\"\n" +
                "},\n" +
                "\"author\": \"Jess Cohen\",\n" +
                "\"title\": \"These Sweet Photos of Kendall Jenner and Bad Bunny's Romance Will Have You Saying \\\"I Like It\\\" - E! NEWS\",\n" +
                "\"description\": \"Nearly a year after Kendall Jenner and Bad Bunny first sparked romance rumors, the supermodel and the singer continue to make headlines for their lavish date nights.\",\n" +
                "\"url\": \"https://www.eonline.com/news/1388317/these-sweet-photos-of-kendall-jenner-and-bad-bunnys-romance-will-have-you-saying-i-like-it\",\n" +
                "\"urlToImage\": \"https://akns-images.eonline.com/eol_images/Entire_Site/2023628/rs_1200x1200-230728110235-1200-Bad-Bunny-Kendall-Jenner-LT-072823-GettyImages-1487219310-GettyImages-1458242932.jpg?fit=around%7C1080:1080&output-quality=90&crop=1080:1080;center,top\",\n" +
                "\"publishedAt\": \"2023-10-22T02:00:00Z\",\n" +
                "\"content\": \"Can you keep up with Kendall Jenner and Bad Bunny?\\r\\nThe supermodel and the Grammy winner, who first sparked romance rumors in early 2023, have become seemingly inseparable over the last year. And the… [+812 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"YouTube\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"New details emerge on release of 2 American hostages - CBS Evening News\",\n" +
                "\"description\": \"Qatar helped negotiate the release Friday of a mother and daughter from Illinois who were kidnapped by Hamas militants in the Oct. 7 invasion of southern Isr...\",\n" +
                "\"url\": \"https://www.youtube.com/watch?v=Inn-Xl-bUEs\",\n" +
                "\"urlToImage\": \"https://i.ytimg.com/vi/Inn-Xl-bUEs/maxresdefault.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T01:14:57Z\",\n" +
                "\"content\": null\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"Knoxville News Sentinel\"\n" +
                "},\n" +
                "\"author\": \"Mike Wilson\",\n" +
                "\"title\": \"Josh Heupel responds with silence about Tennessee-Alabama officiating - Knoxville News Sentinel\",\n" +
                "\"description\": \"Tennessee football was called for eight penalties for 55 yards compared to Alabama's one for five yards in a 34-20 loss.\",\n" +
                "\"url\": \"https://www.knoxnews.com/story/sports/college/university-of-tennessee/football/2023/10/21/josh-heupel-officiating-tennessee-alabama-game-college-football-week-8/71275965007/\",\n" +
                "\"urlToImage\": \"https://www.knoxnews.com/gcdn/authoring/authoring-images/2023/10/22/PKNS/71276677007-kns-ut-bama-bp-18.jpg?crop=4573,2572,x0,y0&width=3200&height=1800&format=pjpg&auto=webp\",\n" +
                "\"publishedAt\": \"2023-10-22T00:44:05Z\",\n" +
                "\"content\": \"TUSCALOOSA, Ala. Josh Heupel was silent for approximately 15 seconds when asked about the officiating in Tennessee football's 34-20 loss to Alabama on Saturday.\\r\\nNext question, yeah? Was that a long … [+2012 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"MMA Fighting\"\n" +
                "},\n" +
                "\"author\": \"MMA Fighting Newswire\",\n" +
                "\"title\": \"UFC 294 post-fight show: Reaction to Islam Makhachev’s stunning knockout, Khamzat Chimaev’s return - MMA Fighting\",\n" +
                "\"description\": \"MMA Fighting reacts to Islam Makhachev’s brutal finish of Alexander Volkanovski, Khamzat Chimaev’s win, and more from a wild UFC 294 event.\",\n" +
                "\"url\": \"https://www.mmafighting.com/2023/10/21/23926864/ufc-294-post-fight-show-reaction-to-islam-makhachevs-stunning-knockout-khamzat-chimaevs-return\",\n" +
                "\"urlToImage\": \"https://cdn.vox-cdn.com/thumbor/dgH7r3Mobk2OKq8qLkuxWo095d0=/0x0:4455x2332/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/25021597/1748862149.jpg\",\n" +
                "\"publishedAt\": \"2023-10-22T00:33:39Z\",\n" +
                "\"content\": \"Islam Makhachev got his closure against Alexander Volkanovski, and he did it in incredibly brutal fashion as he knocked the featherweight champion out to cap off UFC 294 and retain his lightweight ti… [+975 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"cbs-news\",\n" +
                "\"name\": \"CBS News\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"Norma makes landfall near Mexico's Los Cabos resorts as Category 1 hurricane - CBS News\",\n" +
                "\"description\": \"Norma is expected to continue weakening over the weekend as it crosses into the Sea of Cortez, also known as the Gulf of California.\",\n" +
                "\"url\": \"https://www.cbsnews.com/news/norma-landfall-mexico-los-cabos-resorts-tropical-storm-hurricane/\",\n" +
                "\"urlToImage\": \"https://assets3.cbsnewsstatic.com/hub/i/r/2023/10/22/649ddd56-7391-4a98-b08a-86e594a7dcff/thumbnail/1200x630/c6dfa8364dd8265771f0f49732bd3a14/gettyimages-1737964270.jpg?v=18a5d3569ab1a3ca759fe14d213f7845\",\n" +
                "\"publishedAt\": \"2023-10-22T00:13:00Z\",\n" +
                "\"content\": \"Hurricane Norma made landfall near the resorts of Los Cabos at the southern tip of Mexico's Baja California Peninsula on Saturday afternoon. It was downgraded to a tropical storm by Saturday evening,… [+6692 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"fox-news\",\n" +
                "\"name\": \"Fox News\"\n" +
                "},\n" +
                "\"author\": \"Melissa Rudy\",\n" +
                "\"title\": \"Your diabetes risk may double if you eat this food twice a week, say Harvard researchers - Fox News\",\n" +
                "\"description\": \"Just two servings of red meat per week can increase the risk of developing type 2 diabetes, a study found. Substituting plant-based proteins was linked to a reduced diabetes risk.\",\n" +
                "\"url\": \"https://www.foxnews.com/health/diabetes-risk-may-double-eat-food-twice-week-harvard-researchers\",\n" +
                "\"urlToImage\": \"https://static.foxnews.com/foxnews.com/content/uploads/2023/10/woman-eating-steak.jpg\",\n" +
                "\"publishedAt\": \"2023-10-21T23:56:00Z\",\n" +
                "\"content\": \"Just two servings of red meat per week can increase the risk of developing type 2 diabetes\\r\\n, a new study published in The American Journal of Clinical Nutrition revealed. \\r\\nSwapping the red meat for… [+3123 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"New York Post\"\n" +
                "},\n" +
                "\"author\": \"Alyssa Guzman\",\n" +
                "\"title\": \"8 billion-year-old radio signal found by astronomers -- with experts 'precisely' knowing where it came from - New York Post \",\n" +
                "\"description\": \"The mysterious fast radio burst – identified as FRB 20220610A – only lasted a millisecond, but emitted more than 30 years of the sun’s energetic emissions.\",\n" +
                "\"url\": \"https://nypost.com/2023/10/21/8-billion-year-old-radio-signal-found-by-astronomers-with-experts-precisely-knowing-where-it-came-from/\",\n" +
                "\"urlToImage\": \"https://nypost.com/wp-content/uploads/sites/2/2023/10/NYPICHPDPICT000062207665.jpg?quality=75&strip=all&w=1024\",\n" +
                "\"publishedAt\": \"2023-10-21T23:17:00Z\",\n" +
                "\"content\": \"Astronomers have discovered an eight billion-year-old radio signal. \\r\\nThe mysterious “fast radio burst” — identified as FRB 20220610A — lasted only a millisecond, but released the amount of energy ou… [+2228 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": null,\n" +
                "\"name\": \"WPEC\"\n" +
                "},\n" +
                "\"author\": \"ALEXANDRA OLSON, ANNE D'INNOCENZIO and HALELUYA HADERO | AP Business Writers\",\n" +
                "\"title\": \"Company bosses and workers grapple with the fallout of speaking up about the Israel-Hamas war - KATU\",\n" +
                "\"description\": \"The fallout from the Israel-Hamas war has spilled into workplaces everywhere, making it nearly impossible to come up with a unifying message.\",\n" +
                "\"url\": \"https://cbs12.com/news/nation-world/company-bosses-and-workers-grapple-with-the-fallout-of-speaking-up-about-the-israel-hamas-war-10-21-2023\",\n" +
                "\"urlToImage\": \"https://cbs12.com/resources/media/107e56e8-ffab-4830-bed5-d4fd7cc8c295-large16x9_AP23293746336492.jpg\",\n" +
                "\"publishedAt\": \"2023-10-21T23:01:19Z\",\n" +
                "\"content\": \"NEW YORK (AP) Starbucks accused a union representing thousands of its baristas of damaging the brand and endangering co-workers with a pro-Palestinian tweet. The CEO of a prominent tech conference re… [+6947 chars]\"\n" +
                "},\n" +
                "-{\n" +
                "-\"source\": {\n" +
                "\"id\": \"politico\",\n" +
                "\"name\": \"Politico\"\n" +
                "},\n" +
                "\"author\": null,\n" +
                "\"title\": \"House Republicans push unity 'pledge' to guarantee a speaker - POLITICO\",\n" +
                "\"description\": \"The GOP is wary of another fiasco on the House floor.\",\n" +
                "\"url\": \"https://www.politico.com/news/2023/10/21/speakership-scramble-continues-with-new-crop-of-candidates-staking-their-claims-00122884\",\n" +
                "\"urlToImage\": \"https://static.politico.com/fa/ac/0500b2fd493d972f36624423faff/mike-flood-75850.jpg\",\n" +
                "\"publishedAt\": \"2023-10-21T22:32:03Z\",\n" +
                "\"content\": \"Support for the strategy built rapidly Saturday, with signatures from speakership candidates Reps. Austin Scott (Ga.), Mike Johnson (La.), Pete Sessions (Texas), Jack Bergman (Mich.) and Kevin Hern (… [+2426 chars]\"\n" +
                "}\n" +
                "]\n" +
                "}"
    )

    object NewsSourceResponse : MockedResponse(
        "{\n" +
                "\"status\": \"ok\",\n" +
                "-\"sources\": [\n" +
                "-{\n" +
                "\"id\": \"abc-news\",\n" +
                "\"name\": \"ABC News\",\n" +
                "\"description\": \"Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.\",\n" +
                "\"url\": \"https://abcnews.go.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"abc-news-au\",\n" +
                "\"name\": \"ABC News (AU)\",\n" +
                "\"description\": \"Australia's most trusted source of local, national and world news. Comprehensive, independent, in-depth analysis, the latest business, sport, weather and more.\",\n" +
                "\"url\": \"http://www.abc.net.au/news\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"au\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"aftenposten\",\n" +
                "\"name\": \"Aftenposten\",\n" +
                "\"description\": \"Norges ledende nettavis med alltid oppdaterte nyheter innenfor innenriks, utenriks, sport og kultur.\",\n" +
                "\"url\": \"https://www.aftenposten.no\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"no\",\n" +
                "\"country\": \"no\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"al-jazeera-english\",\n" +
                "\"name\": \"Al Jazeera English\",\n" +
                "\"description\": \"News, analysis from the Middle East and worldwide, multimedia and interactives, opinions, documentaries, podcasts, long reads and broadcast schedule.\",\n" +
                "\"url\": \"http://www.aljazeera.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"ansa\",\n" +
                "\"name\": \"ANSA.it\",\n" +
                "\"description\": \"Agenzia ANSA: ultime notizie, foto, video e approfondimenti su: cronaca, politica, economia, regioni, mondo, sport, calcio, cultura e tecnologia.\",\n" +
                "\"url\": \"http://www.ansa.it\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"it\",\n" +
                "\"country\": \"it\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"argaam\",\n" +
                "\"name\": \"Argaam\",\n" +
                "\"description\": \"ارقام موقع متخصص في متابعة سوق الأسهم السعودي تداول - تاسي - مع تغطيه معمقة لشركات واسعار ومنتجات البتروكيماويات , تقارير مالية الاكتتابات الجديده \",\n" +
                "\"url\": \"http://www.argaam.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"ar\",\n" +
                "\"country\": \"sa\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"ars-technica\",\n" +
                "\"name\": \"Ars Technica\",\n" +
                "\"description\": \"The PC enthusiast's resource. Power users and the tools they love, without computing religion.\",\n" +
                "\"url\": \"http://arstechnica.com\",\n" +
                "\"category\": \"technology\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"ary-news\",\n" +
                "\"name\": \"Ary News\",\n" +
                "\"description\": \"ARY News is a Pakistani news channel committed to bring you up-to-the minute Pakistan news and featured stories from around Pakistan and all over the world.\",\n" +
                "\"url\": \"https://arynews.tv/ud/\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"ud\",\n" +
                "\"country\": \"pk\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"associated-press\",\n" +
                "\"name\": \"Associated Press\",\n" +
                "\"description\": \"The AP delivers in-depth coverage on the international, politics, lifestyle, business, and entertainment news.\",\n" +
                "\"url\": \"https://apnews.com/\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"australian-financial-review\",\n" +
                "\"name\": \"Australian Financial Review\",\n" +
                "\"description\": \"The Australian Financial Review reports the latest news from business, finance, investment and politics, updated in real time. It has a reputation for independent, award-winning journalism and is essential reading for the business and investor community.\",\n" +
                "\"url\": \"http://www.afr.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"au\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"axios\",\n" +
                "\"name\": \"Axios\",\n" +
                "\"description\": \"Axios are a new media company delivering vital, trustworthy news and analysis in the most efficient, illuminating and shareable ways possible.\",\n" +
                "\"url\": \"https://www.axios.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"bbc-news\",\n" +
                "\"name\": \"BBC News\",\n" +
                "\"description\": \"Use BBC News for up-to-the-minute news, breaking news, video, audio and feature stories. BBC News provides trusted World and UK news as well as local and regional perspectives. Also entertainment, business, science, technology and health news.\",\n" +
                "\"url\": \"http://www.bbc.co.uk/news\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"gb\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"bbc-sport\",\n" +
                "\"name\": \"BBC Sport\",\n" +
                "\"description\": \"The home of BBC Sport online. Includes live sports coverage, breaking news, results, video, audio and analysis on Football, F1, Cricket, Rugby Union, Rugby League, Golf, Tennis and all the main world sports, plus major events such as the Olympic Games.\",\n" +
                "\"url\": \"http://www.bbc.co.uk/sport\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"gb\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"bild\",\n" +
                "\"name\": \"Bild\",\n" +
                "\"description\": \"Die Seite 1 für aktuelle Nachrichten und Themen, Bilder und Videos aus den Bereichen News, Wirtschaft, Politik, Show, Sport, und Promis.\",\n" +
                "\"url\": \"http://www.bild.de\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"de\",\n" +
                "\"country\": \"de\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"blasting-news-br\",\n" +
                "\"name\": \"Blasting News (BR)\",\n" +
                "\"description\": \"Descubra a seção brasileira da Blasting News, a primeira revista feita pelo  público, com notícias globais e vídeos independentes. Junte-se a nós e torne- se um repórter.\",\n" +
                "\"url\": \"https://br.blastingnews.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"pt\",\n" +
                "\"country\": \"br\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"bleacher-report\",\n" +
                "\"name\": \"Bleacher Report\",\n" +
                "\"description\": \"Sports journalists and bloggers covering NFL, MLB, NBA, NHL, MMA, college football and basketball, NASCAR, fantasy sports and more. News, photos, mock drafts, game scores, player profiles and more!\",\n" +
                "\"url\": \"http://www.bleacherreport.com\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"bloomberg\",\n" +
                "\"name\": \"Bloomberg\",\n" +
                "\"description\": \"Bloomberg delivers business and markets news, data, analysis, and video to the world, featuring stories from Businessweek and Bloomberg News.\",\n" +
                "\"url\": \"http://www.bloomberg.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"breitbart-news\",\n" +
                "\"name\": \"Breitbart News\",\n" +
                "\"description\": \"Syndicated news and opinion website providing continuously updated headlines to top news and analysis sources.\",\n" +
                "\"url\": \"http://www.breitbart.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"business-insider\",\n" +
                "\"name\": \"Business Insider\",\n" +
                "\"description\": \"Business Insider is a fast-growing business site with deep financial, media, tech, and other industry verticals. Launched in 2007, the site is now the largest business news site on the web.\",\n" +
                "\"url\": \"http://www.businessinsider.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"business-insider-uk\",\n" +
                "\"name\": \"Business Insider (UK)\",\n" +
                "\"description\": \"Business Insider is a fast-growing business site with deep financial, media, tech, and other industry verticals. Launched in 2007, the site is now the largest business news site on the web.\",\n" +
                "\"url\": \"http://uk.businessinsider.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"gb\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"buzzfeed\",\n" +
                "\"name\": \"Buzzfeed\",\n" +
                "\"description\": \"BuzzFeed is a cross-platform, global network for news and entertainment that generates seven billion views each month.\",\n" +
                "\"url\": \"https://www.buzzfeed.com\",\n" +
                "\"category\": \"entertainment\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"cbc-news\",\n" +
                "\"name\": \"CBC News\",\n" +
                "\"description\": \"CBC News is the division of the Canadian Broadcasting Corporation responsible for the news gathering and production of news programs on the corporation's English-language operations, namely CBC Television, CBC Radio, CBC News Network, and CBC.ca.\",\n" +
                "\"url\": \"http://www.cbc.ca/news\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"ca\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"cbs-news\",\n" +
                "\"name\": \"CBS News\",\n" +
                "\"description\": \"CBS News: dedicated to providing the best in journalism under standards it pioneered at the dawn of radio and television and continue in the digital age.\",\n" +
                "\"url\": \"http://www.cbsnews.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"cnn\",\n" +
                "\"name\": \"CNN\",\n" +
                "\"description\": \"View the latest news and breaking news today for U.S., world, weather, entertainment, politics and health at CNN\",\n" +
                "\"url\": \"http://us.cnn.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"cnn-es\",\n" +
                "\"name\": \"CNN Spanish\",\n" +
                "\"description\": \"Lee las últimas noticias e información sobre Latinoamérica, Estados Unidos, mundo, entretenimiento, política, salud, tecnología y deportes en CNNEspañol.com.\",\n" +
                "\"url\": \"http://cnnespanol.cnn.com/\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"es\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"crypto-coins-news\",\n" +
                "\"name\": \"Crypto Coins News\",\n" +
                "\"description\": \"Providing breaking cryptocurrency news - focusing on Bitcoin, Ethereum, ICOs, blockchain technology, and smart contracts.\",\n" +
                "\"url\": \"https://www.ccn.com\",\n" +
                "\"category\": \"technology\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"der-tagesspiegel\",\n" +
                "\"name\": \"Der Tagesspiegel\",\n" +
                "\"description\": \"Nachrichten, News und neueste Meldungen aus dem Inland und dem Ausland - aktuell präsentiert von tagesspiegel.de.\",\n" +
                "\"url\": \"http://www.tagesspiegel.de\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"de\",\n" +
                "\"country\": \"de\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"die-zeit\",\n" +
                "\"name\": \"Die Zeit\",\n" +
                "\"description\": \"Aktuelle Nachrichten, Kommentare, Analysen und Hintergrundberichte aus Politik, Wirtschaft, Gesellschaft, Wissen, Kultur und Sport lesen Sie auf ZEIT ONLINE.\",\n" +
                "\"url\": \"http://www.zeit.de/index\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"de\",\n" +
                "\"country\": \"de\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"el-mundo\",\n" +
                "\"name\": \"El Mundo\",\n" +
                "\"description\": \"Noticias, actualidad, álbumes, debates, sociedad, servicios, entretenimiento y última hora en España y el mundo.\",\n" +
                "\"url\": \"http://www.elmundo.es\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"es\",\n" +
                "\"country\": \"es\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"engadget\",\n" +
                "\"name\": \"Engadget\",\n" +
                "\"description\": \"Engadget is a web magazine with obsessive daily coverage of everything new in gadgets and consumer electronics.\",\n" +
                "\"url\": \"https://www.engadget.com\",\n" +
                "\"category\": \"technology\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"entertainment-weekly\",\n" +
                "\"name\": \"Entertainment Weekly\",\n" +
                "\"description\": \"Online version of the print magazine includes entertainment news, interviews, reviews of music, film, TV and books, and a special area for magazine subscribers.\",\n" +
                "\"url\": \"http://www.ew.com\",\n" +
                "\"category\": \"entertainment\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"espn\",\n" +
                "\"name\": \"ESPN\",\n" +
                "\"description\": \"ESPN has up-to-the-minute sports news coverage, scores, highlights and commentary for NFL, MLB, NBA, College Football, NCAA Basketball and more.\",\n" +
                "\"url\": \"https://www.espn.com\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"espn-cric-info\",\n" +
                "\"name\": \"ESPN Cric Info\",\n" +
                "\"description\": \"ESPN Cricinfo provides the most comprehensive cricket coverage available including live ball-by-ball commentary, news, unparalleled statistics, quality editorial comment and analysis.\",\n" +
                "\"url\": \"http://www.espncricinfo.com/\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"financial-post\",\n" +
                "\"name\": \"Financial Post\",\n" +
                "\"description\": \"Find the latest happenings in the Canadian Financial Sector and stay up to date with changing trends in Business Markets. Read trading and investing advice from professionals.\",\n" +
                "\"url\": \"http://business.financialpost.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"ca\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"focus\",\n" +
                "\"name\": \"Focus\",\n" +
                "\"description\": \"Minutenaktuelle Nachrichten und Service-Informationen von Deutschlands modernem Nachrichtenmagazin.\",\n" +
                "\"url\": \"http://www.focus.de\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"de\",\n" +
                "\"country\": \"de\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"football-italia\",\n" +
                "\"name\": \"Football Italia\",\n" +
                "\"description\": \"Italian football news, analysis, fixtures and results for the latest from Serie A, Serie B and the Azzurri.\",\n" +
                "\"url\": \"http://www.football-italia.net\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"it\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"fortune\",\n" +
                "\"name\": \"Fortune\",\n" +
                "\"description\": \"Fortune 500 Daily and Breaking Business News\",\n" +
                "\"url\": \"http://fortune.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"four-four-two\",\n" +
                "\"name\": \"FourFourTwo\",\n" +
                "\"description\": \"The latest football news, in-depth features, tactical and statistical analysis from FourFourTwo, the UK&#039;s favourite football monthly.\",\n" +
                "\"url\": \"http://www.fourfourtwo.com/news\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"gb\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"fox-news\",\n" +
                "\"name\": \"Fox News\",\n" +
                "\"description\": \"Breaking News, Latest News and Current News from FOXNews.com. Breaking news and video. Latest Current News: U.S., World, Entertainment, Health, Business, Technology, Politics, Sports.\",\n" +
                "\"url\": \"http://www.foxnews.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"fox-sports\",\n" +
                "\"name\": \"Fox Sports\",\n" +
                "\"description\": \"Find live scores, player and team news, videos, rumors, stats, standings, schedules and fantasy games on FOX Sports.\",\n" +
                "\"url\": \"http://www.foxsports.com\",\n" +
                "\"category\": \"sports\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"globo\",\n" +
                "\"name\": \"Globo\",\n" +
                "\"description\": \"Só na globo.com você encontra tudo sobre o conteúdo e marcas do Grupo Globo. O melhor acervo de vídeos online sobre entretenimento, esportes e jornalismo do Brasil.\",\n" +
                "\"url\": \"http://www.globo.com/\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"pt\",\n" +
                "\"country\": \"br\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news\",\n" +
                "\"name\": \"Google News\",\n" +
                "\"description\": \"Comprehensive, up-to-date news coverage, aggregated from sources all over the world by Google News.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-ar\",\n" +
                "\"name\": \"Google News (Argentina)\",\n" +
                "\"description\": \"Completa cobertura actualizada de noticias agregadas a partir de fuentes de todo el mundo por Google Noticias.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"es\",\n" +
                "\"country\": \"ar\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-au\",\n" +
                "\"name\": \"Google News (Australia)\",\n" +
                "\"description\": \"Comprehensive, up-to-date Australia news coverage, aggregated from sources all over the world by Google News.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"au\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-br\",\n" +
                "\"name\": \"Google News (Brasil)\",\n" +
                "\"description\": \"Cobertura jornalística abrangente e atualizada, agregada de fontes do mundo inteiro pelo Google Notícias.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"pt\",\n" +
                "\"country\": \"br\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-ca\",\n" +
                "\"name\": \"Google News (Canada)\",\n" +
                "\"description\": \"Comprehensive, up-to-date Canada news coverage, aggregated from sources all over the world by Google News.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"ca\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-fr\",\n" +
                "\"name\": \"Google News (France)\",\n" +
                "\"description\": \"Informations complètes et à jour, compilées par Google Actualités à partir de sources d&#39;actualités du monde entier.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"fr\",\n" +
                "\"country\": \"fr\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-in\",\n" +
                "\"name\": \"Google News (India)\",\n" +
                "\"description\": \"Comprehensive, up-to-date India news coverage, aggregated from sources all over the world by Google News.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"in\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-is\",\n" +
                "\"name\": \"Google News (Israel)\",\n" +
                "\"description\": \"כיסוי מקיף ועדכני של חדשות שהצטברו ממקורות בכל העולם על ידי &#39;חדשות Google&#39;.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"he\",\n" +
                "\"country\": \"is\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-it\",\n" +
                "\"name\": \"Google News (Italy)\",\n" +
                "\"description\": \"Copertura giornalistica completa e aggiornata ottenuta combinando fonti di notizie in tutto il mondo attraverso Google News.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"it\",\n" +
                "\"country\": \"it\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-ru\",\n" +
                "\"name\": \"Google News (Russia)\",\n" +
                "\"description\": \"Исчерпывающая и актуальная информация, собранная службой &quot;Новости Google&quot; со всего света.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"ru\",\n" +
                "\"country\": \"ru\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-sa\",\n" +
                "\"name\": \"Google News (Saudi Arabia)\",\n" +
                "\"description\": \"تغطية شاملة ومتجددة للأخبار، تم جمعها من مصادر أخبار من جميع أنحاء العالم بواسطة أخبار Google.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"ar\",\n" +
                "\"country\": \"sa\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"google-news-uk\",\n" +
                "\"name\": \"Google News (UK)\",\n" +
                "\"description\": \"Comprehensive, up-to-date UK news coverage, aggregated from sources all over the world by Google News.\",\n" +
                "\"url\": \"https://news.google.com\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"gb\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"goteborgs-posten\",\n" +
                "\"name\": \"Göteborgs-Posten\",\n" +
                "\"description\": \"Göteborgs-Posten, abbreviated GP, is a major Swedish language daily newspaper published in Gothenburg, Sweden.\",\n" +
                "\"url\": \"http://www.gp.se\",\n" +
                "\"category\": \"general\",\n" +
                "\"language\": \"sv\",\n" +
                "\"country\": \"se\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"gruenderszene\",\n" +
                "\"name\": \"Gruenderszene\",\n" +
                "\"description\": \"Online-Magazin für Startups und die digitale Wirtschaft. News und Hintergründe zu Investment, VC und Gründungen.\",\n" +
                "\"url\": \"http://www.gruenderszene.de\",\n" +
                "\"category\": \"technology\",\n" +
                "\"language\": \"de\",\n" +
                "\"country\": \"de\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"hacker-news\",\n" +
                "\"name\": \"Hacker News\",\n" +
                "\"description\": \"Hacker News is a social news website focusing on computer science and entrepreneurship. It is run by Paul Graham's investment fund and startup incubator, Y Combinator. In general, content that can be submitted is defined as \\\"anything that gratifies one's intellectual curiosity\\\".\",\n" +
                "\"url\": \"https://news.ycombinator.com\",\n" +
                "\"category\": \"technology\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"handelsblatt\",\n" +
                "\"name\": \"Handelsblatt\",\n" +
                "\"description\": \"Auf Handelsblatt lesen sie Nachrichten über Unternehmen, Finanzen, Politik und Technik. Verwalten Sie Ihre Finanzanlagen mit Hilfe unserer Börsenkurse.\",\n" +
                "\"url\": \"http://www.handelsblatt.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"de\",\n" +
                "\"country\": \"de\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"ign\",\n" +
                "\"name\": \"IGN\",\n" +
                "\"description\": \"IGN is your site for Xbox One, PS4, PC, Wii-U, Xbox 360, PS3, Wii, 3DS, PS Vita and iPhone games with expert reviews, news, previews, trailers, cheat codes, wiki guides and walkthroughs.\",\n" +
                "\"url\": \"http://www.ign.com\",\n" +
                "\"category\": \"entertainment\",\n" +
                "\"language\": \"en\",\n" +
                "\"country\": \"us\"\n" +
                "},\n" +
                "-{\n" +
                "\"id\": \"il-sole-24-ore\",\n" +
                "\"name\": \"Il Sole 24 Ore\",\n" +
                "\"description\": \"Notizie di economia, cronaca italiana ed estera, quotazioni borsa in tempo reale e di finanza, norme e tributi, fondi e obbligazioni, mutui, prestiti e lavoro a cura de Il Sole 24 Ore.\",\n" +
                "\"url\": \"https://www.ilsole24ore.com\",\n" +
                "\"category\": \"business\",\n" +
                "\"language\": \"it\",\n" +
                "\"country\": \"it\"\n" +
                "}" +
                "}" +
                "}"
    )
}