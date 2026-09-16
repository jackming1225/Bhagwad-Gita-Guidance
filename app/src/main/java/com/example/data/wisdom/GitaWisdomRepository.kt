package com.example.data.wisdom

import com.example.data.model.GitaLanguage
import com.example.data.model.GitaVerse

object GitaWisdomRepository {

    val VERSES: List<GitaVerse> = listOf(
        GitaVerse(
            chapter = 2,
            verse = 47,
            sanskrit = "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।\nमा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
            transliteration = "karmaṇy-evādhikāras te mā phaleṣhu kadāchana\nmā karma-phala-hetur bhūr mā te saṅgo ’stvakarmaṇi",
            translations = mapOf(
                "en" to "You have a right to perform your prescribed duty, but you are not entitled to the fruits of action. Never consider yourself the cause of the results, nor be attached to inaction.",
                "sa" to "तव कर्मणि एव अधिकारः अस्ति, फलेषु कदापि मा अस्तु। त्वं कर्मफलस्य हेतुः मा भव, तथा अकर्मणि अपि तव आसक्तिः मा भवतु।",
                "hi" to "तुम्हारा अधिकार केवल कर्म करने में है, उसके फलों में कभी नहीं। इसलिए कर्म के फलों के हेतु मत बनो और न ही तुम्हारी अकर्मण्यता (कर्म न करने) में आसक्ति हो।",
                "ta" to "கடமையைச் செய்வதில் மட்டுமே உனக்கு உரிமை உண்டு; அதன் பயன்களில் ஒருபோதும் இல்லை. செயலின் பலனுக்கு நீ காரணமாகாதே; செயலற்ற தன்மையிலும் பற்று கொள்ளாதே.",
                "te" to "కర్మలు చేయడంలోనే నీకు అధికారం ఉంది కానీ, వాటి ఫలితాలపై ఎన్నడూ లేదు. కర్మఫలాలకు నీవు కారణం కావద్దు, అలాగని కర్మలను విడిచిపెట్టడంపై ఆసక్తి పెంచుకోవద్దు.",
                "bn" to "কর্মে তোমার অধিকার আছে, কিন্তু কর্মফলে কখনো নয়। কর্মফলের কারণ হয়ো না এবং নিষ্ক্রিয়তায় যেন তোমার আসক্তি না জন্মে।",
                "mr" to "फक्त कर्म करण्याचाच तुला अधिकार आहे, त्याच्या फळावर कधीही नाही. म्हणून तू कर्माच्या फळाचा हेतू होऊ नकोस आणि कर्म न करण्यामध्ये तुझी आसक्ती नसावी.",
                "gu" to "તારો અધિકાર માત્ર કર્મ કરવામાં જ છે, તેના ફળમાં ક્યારેય નહીં. કર્મફળનો હેતુ તું ન બન અને કર્મ ન કરવામાં તારી આસક્તિ ન થાય.",
                "kn" to "ಕರ್ಮವನ್ನು ಮಾಡುವುದರಲ್ಲಿ ಮಾತ್ರ ನಿನಗೆ ಅಧಿಕಾರವಿದೆ, ಅದರ ಫಲಗಳಲ್ಲಿ ಎಂದಿಗೂ ಇಲ್ಲ. ಕರ್ಮಫಲಕ್ಕೆ ನೀನು ಕಾರಣನಾಗಬೇಡ ಮತ್ತು ಕರ್ಮಮಾಡದೆ ಇರುವುದರಲ್ಲಿ ನಿನಗೆ ಆಸಕ್ತಿ ಇರಬಾರದು.",
                "ml" to "കർമ്മം ചെയ്യുവാൻ മാത്രമേ നിനക്ക് അധികാരമുള്ളൂ, ഫലങ്ങളിൽ ഒരിക്കലുമില്ല. കർമ്മഫലത്തിന് നീ കാരണക്കാരനാകരുത്, കർമ്മം ചെയ്യാതിരിക്കാൻ നിനക്ക് തോന്നുകയുമരുത്.",
                "or" to "କେବଳ କର୍ମ କରିବାରେ ତୁମର ଅଧିକାର ଅଛି, ଫଳରେ କଦାପି ନୁହେଁ। କର୍ମଫଳର କାରଣ ହୁଅ ନାହିଁ କିମ୍ବା କର୍ମତ୍ୟାଗ ପ୍ରତି ଆସକ୍ତ ହୁଅ ନାହିଁ।",
                "pa" to "ਤੇਰਾ ਅਧਿਕਾਰ ਸਿਰਫ ਕਰਮ ਕਰਨ ਵਿੱਚ ਹੈ, ਉਸਦੇ ਫਲ ਵਿੱਚ ਕਦੇ ਨਹੀਂ। ਇਸ ਲਈ ਕਰਮ ਦੇ ਫਲ ਦਾ ਕਾਰਨ ਨਾ ਬਣੋ ਅਤੇ ਨਾ ਹੀ ਕਰਮ ਨਾ ਕਰਨ ਵਿੱਚ ਲਗਾਵ ਹੋਵੇ।"
            ),
            lifeTheme = "Work & Duty without Anxiety",
            guidance = mapOf(
                "en" to "Whenever you feel stressed about outcomes—whether an exam, project, or career decision—remember that anxiety stems from wanting to control the future. Pour 100% of your energy into the present action, and surrender the outcome to the universe.",
                "sa" to "यदा भविष्यस्य चिन्ता मनः व्याकुलं करोति, तदा स्मरतु यत् कर्मणि एव अस्माकं वशः। फलं ईश्वराय समर्पयतु, वर्तमाने शान्त्या कर्म कुरु।",
                "hi" to "जब भी आपको भविष्य के परिणामों की चिंता सताए, तो स्मरण करें कि बेचैनी परिणाम को नियंत्रित करने की इच्छा से आती है। अपना संपूर्ण समर्पण वर्तमान कर्म में लगाएं, फल की चिंता ईश्वर पर छोड़ दें।",
                "ta" to "முடிவுகளைப் பற்றிய கவலையில் ஆழும் போது, நிகழ்காலத்தில் உங்கள் முழு உழைப்பையும் செலுத்தி பலனை இறைவனிடம் ஒப்படைப்பதே அமைதிக்கான வழி.",
                "te" to "ఫలితం గురించిన ఆందోళన కలిగినప్పుడు, ప్రస్తుత పనిపై పూర్తి దృష్టి పెట్టి ఫలితాన్ని భగవంతుడికి సమర్పించడమే పరమ శాంతి.",
                "bn" to "ফলাফলের উদ্বেগ দূর করতে বর্তমান কর্মে সম্পূর্ণ মনোযোগ দিন এবং ফলাফল ঈশ্বরের উপর সমর্পণ করুন।",
                "mr" to "भविष्याची चिंता न करता आजच्या कर्तव्यावर मन एकाग्र करा, हेच मनःशांतीचे रहस्य आहे.",
                "gu" to "પરિણામની ચિંતા છોડીને વર્તમાન કર્તવ્યમાં સમર્પિત થાઓ, આ જ ભગવદ્ ગીતાનો મૂળ મંત્ર છે.",
                "kn" to "ಫಲಿತಾಂಶದ ಆತಂಕವನ್ನು ಬಿಟ್ಟು, ಪ್ರಸ್ತುತ ಕರ್ತವ್ಯದಲ್ಲಿ ಸಂಪೂರ್ಣ ಮನಸ್ಸನ್ನಿಟ್ಟು ಕೆಲಸ ಮಾಡಿ.",
                "ml" to "ഫലത്തെക്കുറിച്ചുള്ള ഉൽക്കണ്ഠ വെടിഞ്ഞ് ഇപ്പോഴത്തെ കർമ്മത്തിൽ മുഴുകുക.",
                "or" to "ଭବିଷ୍ୟତ ଫଳର ଚିନ୍ତା ଛାଡ଼ି ନିଜ କର୍ତ୍ତବ୍ୟରେ ସମ୍ପୂର୍ଣ୍ଣ ମନୋନିବେଶ କରନ୍ତୁ।",
                "pa" to "ਨਤੀਜੇ ਦੀ ਚਿੰਤਾ ਛੱਡ ਕੇ ਆਪਣੇ ਅੱਜ ਦੇ ਕੰਮ ਤੇ ਪੂਰਾ ਧਿਆਨ ਲਗਾਓ।"
            ),
            contemplationPrompt = mapOf(
                "en" to "What is one task today where you can detach your happiness from the result and simply enjoy doing it with pure care?",
                "hi" to "आज ऐसा कौन सा कार्य है जिसे आप परिणाम की चिंता किए बिना केवल निष्काम भाव और प्रेम से कर सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I will focus on my efforts with full heart and let go of anxiety regarding results.",
                "hi" to "आज मैं अपने प्रयासों में निष्ठा रखूंगा और परिणाम की चिंता से मुक्त रहूंगा।"
            )
        ),
        GitaVerse(
            chapter = 2,
            verse = 14,
            sanskrit = "मात्रास्पर्शास्तु कौन्तेय शीतोष्णसुखदुःखदाः।\nआगमापायिनोऽनित्यास्तांस्तितिक्षस्व भारत॥",
            transliteration = "mātrā-sparśhās tu kaunteya śhītoṣhṇa-sukha-duḥkha-dāḥ\nāgamāpāyino ’nityās tans-titikṣhasva bhārata",
            translations = mapOf(
                "en" to "O son of Kunti, the contact between the senses and sense objects gives rise to fleeting feelings of heat and cold, pleasure and pain. They are temporary and ever-changing; learn to endure them patiently.",
                "sa" to "हे कौन्तेय! इन्द्रियाणां विषयेभ्यः संयोगेन शीत-उष्ण-सुख-दुःखानि उत्पद्यन्ते। एते अनित्याः उत्पत्त्या विनाशशीलाः च सन्ति, अतः हे भारत! तान् तितिक्षस्व (सहनं कुरु)।",
                "hi" to "हे कुन्तीपुत्र! इन्द्रियों और विषयों का संयोग शीत-उष्ण और सुख-दुःख देने वाला है। ये आने-जाने वाले और अनित्य हैं, इसलिए हे भारत! तुम इनको धैर्यपूर्वक सहन करो।",
                "ta" to "புலன்களின் உணர்வுகள் இன்ப துன்பங்களையும், குளிர் வெப்பத்தையும் தருகின்றன. அவை வந்து போகக்கூடிய தற்காலிகமானவை; அவற்றை பொறுமையுடன் தாங்கிக்கொள்.",
                "te" to "ఇంద్రియ విషయాల సంయోగం వలన సుఖదుఃఖాలు, చలివేడి కలుగుతాయి. అవి వచ్చిపోయే తాత్కాలికమైనవి. వాటిని ఓర్పుతో భరించు.",
                "bn" to "ইন্দ্রিয় ও বিষয়ের সংযোগে সুখ-দুঃখ এবং শীত-গ্রীষ্মের অনুভূতি হয়। এগুলি অনিত্য এবং ক্ষণস্থায়ী; তাই ধৈর্য ধরে এগুলি সহ্য করো।",
                "mr" to "सुख आणि दुःख हे हवामानासारखे क्षणिक आहेत, ते येतात आणि जातात. त्यांना धैर्याने सहन करायला शिका.",
                "gu" to "સુખ-દુઃખ અનિત્ય છે અને આવવા-જવા વાળા છે, માટે તેને ધૈર્યથી સહન કરો.",
                "kn" to "ಸುಖ-ದುಃಖಗಳು ಚಳಿಗಾಲ-ಬೇಸಿಗೆಯಂತೆ ಬಂದು ಹೋಗುವಂತವು. ಅವುಗಳನ್ನು ತಾಳ್ಮೆಯಿಂದ ಸಹಿಸಿಕೊಳ್ಳಿ.",
                "ml" to "സുഖദുഃഖങ്ങൾ വന്നുപോകുന്നവയാണ്; അവയെ ക്ഷമയോടെ നേരിടുക.",
                "or" to "ସୁଖ ଏବଂ ଦୁଃଖ କ୍ଷଣସ୍ଥାୟୀ, ତେଣୁ ସେସବୁକୁ ଧୈର୍ଯ୍ୟର ସହିତ ସହନ କର।",
                "pa" to "ਸੁੱਖ-ਦੁੱਖ ਆਉਣ ਜਾਣ ਵਾਲੇ ਹਨ, ਇਸ ਲਈ ਇਹਨਾਂ ਨੂੰ ਧੀਰਜ ਨਾਲ ਸਹਿਣ ਕਰੋ।"
            ),
            lifeTheme = "Resilience & Emotional Balance",
            guidance = mapOf(
                "en" to "Neither joyful highs nor painful lows last forever. When emotional storms arrive, stand firm like an observer. Pain passes just as joy does. Developing this inner patience (Titiksha) is the secret to enduring peace.",
                "hi" to "जीवन में न सुख सदा रहता है न दुःख। जब भी मन विचलित हो, स्वयं को याद दिलाएं कि यह समय भी बीत जाएगा। धैर्य और समत्व ही आत्मिक शक्ति का आधार है।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Notice an uncomfortable emotion right now. Can you observe it without fighting it, knowing it will soon change?",
                "hi" to "वर्तमान में किसी असुविधा या उदासी को बिना लड़े केवल एक दृष्टा की तरह देखें, यह भी क्षणिक है।"
            ),
            mindfulIntention = mapOf(
                "en" to "I will stay calm and centered amidst changing circumstances today.",
                "hi" to "आज मैं अनुकूल और प्रतिकूल दोनों परिस्थितियों में मन का संतुलन बनाए रखूंगा।"
            )
        ),
        GitaVerse(
            chapter = 2,
            verse = 20,
            sanskrit = "न जायते म्रियते वा कदाचिन्\nनायं भूत्वा भविता वा न भूयः।\nअजो नित्यः शाश्वतोऽयं पुराणो\nन हन्यते हन्यमाने शरीरे॥",
            transliteration = "na jāyate mriyate vā kadāchin\nnāyaṁ bhūtvā bhavitā vā na bhūyaḥ\najo nityaḥ śhāśhvato ’yaṁ purāṇo\nna hanyate hanyamāne śharīre",
            translations = mapOf(
                "en" to "The soul is never born, nor does it ever die; nor having once existed, does it ever cease to be. The soul is unborn, eternal, ever-existing, and primeval. It is not destroyed when the body is slain.",
                "sa" to "अयम् आत्मा न कदापि जायते न वा म्रियते। अयम् अजः, नित्यः, शाश्वतः, पुरातनः च। शरीरस्य नाशे अपि अस्य विनाशः न भवति।",
                "hi" to "आत्मा किसी काल में भी न तो जन्म लेती है और न मरती ही है। यह अजन्मा, नित्य, सनातन और पुरातन है। शरीर के नष्ट होने पर भी यह नहीं मरती।",
                "ta" to "ஆன்மா பிறப்பதுமில்லை, இறப்பதுமில்லை. அது பிறப்பற்றது, நித்தியமானது, அழியாதது. உடல் அழியும் போதும் ஆன்மா அழிவதில்லை.",
                "te" to "ఆత్మ జన్మించదు, మరణించదు. అది నిత్యమైనది, శాశ్వతమైనది. శరీరం నశించినా ఆత్మ నశించదు.",
                "bn" to "আত্মার কখনো জন্ম হয় না, মৃত্যুও হয় না। ইহা শাশ্বত, সনাতন ও পুরাতন। শরীরের বিনাশেও আত্মার বিনাশ হয় না।",
                "mr" to "आत्मा कधीही जन्मत नाही किंवा मरत नाही. तो अजन्मा, नित्य आणि शाश्वत आहे. शरीराचा नाश झाला तरी आत्मा नष्ट होत नाही.",
                "gu" to "આત્મા ક્યારેય જન્મતો નથી કે મરતો નથી. તે અજન્મા, નિત્ય અને શાશ્વત છે.",
                "kn" to "ಆತ್ಮಕ್ಕೆ ಹುಟ್ಟು ಇಲ್ಲ, ಸಾವೂ ಇಲ್ಲ. ಅದು ನಿತ್ಯ, ಶಾಶ್ವತ ಮತ್ತು ಪುರಾತನವಾದುದು.",
                "ml" to "ആത്മാവ് ജനിക്കുന്നില്ല, മരിക്കുന്നതുമില്ല. ശരീരം നശിച്ചാലും ആത്മാവ് നശിക്കുന്നില്ല.",
                "or" to "ଆତ୍ମାର କେବେ ଜନ୍ମ ବା ମୃତ୍ୟୁ ହୁଏ ନାହିଁ। ଏହା ଅଜନ୍ମା, ନିତ୍ୟ ଓ ଶାଶ୍ୱତ।",
                "pa" to "ਆਤਮਾ ਕਦੇ ਜੰਮਦੀ ਨਹੀਂ ਅਤੇ ਨਾ ਹੀ ਮਰਦੀ ਹੈ। ਇਹ ਸਨਾਤਨ ਅਤੇ ਅਮਰ ਹੈ।"
            ),
            lifeTheme = "Overcoming Fear of Loss & Death",
            guidance = mapOf(
                "en" to "Your true essence is infinite, eternal consciousness, not merely this fragile body or worried mind. When grief or existential dread arises, ground yourself in your undying spiritual nature.",
                "hi" to "आप केवल हाड़-मांस का शरीर या विचारों से घिरा मन नहीं हैं, आप वह अमर चेतना हैं जो कभी नष्ट नहीं होती। इस सत्य के स्मरण से भय और शोक मिट जाते हैं।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Reflect on that silent awareness within you that observes every breath and thought. That presence is immortal.",
                "hi" to "अपने भीतर की उस शांत चेतना का अनुभव करें जो हर विचार और श्वास को देख रही है। वह नित्य है।"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I will remember my higher spiritual nature beyond daily bodily anxieties.",
                "hi" to "आज मैं स्वयं को नश्वर चिंताओं से ऊपर उठाकर अपनी शाश्वत आत्म-शांति में स्थिर रखूंगा।"
            )
        ),
        GitaVerse(
            chapter = 2,
            verse = 62,
            sanskrit = "ध्यायतो विषयान्पुंसः सङ्गस्तेषूपजायते।\nसङ्गात्सञ्जायते कामः कामात्क्रोधोऽभिजायते॥",
            transliteration = "dhyāyato viṣhayān puṁsaḥ saṅgas teṣhūpajāyate\nsaṅgāt sañjāyate kāmaḥ kāmāt krodho ’bhijāyate",
            translations = mapOf(
                "en" to "While contemplating the objects of the senses, a person develops attachment for them. From attachment desire arises, and from unfulfilled desire, anger flares up.",
                "sa" to "विषयाणां निरन्तरं चिन्तनेन तेषु आसक्तिः उत्पद्यते। आसक्त्या कामः (कामना) जायते, कामस्य बाधायां क्रोधः प्रजायते।",
                "hi" to "विषयों का चिंतन करने वाले मनुष्य की उनमें आसक्ति हो जाती है। आसक्ति से कामना उत्पन्न होती है और कामना में विघ्न पड़ने से क्रोध उत्पन्न होता है।",
                "ta" to "புலன் இன்பங்களை எண்ணிக் கொண்டே இருப்பதால் பற்று உண்டாகிறது. பற்றிலிருந்து ஆசையும், ஆசை தடைபடும் போது கோபமும் பிறக்கிறது.",
                "te" to "విషయాలపై నిరంతరం ఆలోచించడం వల్ల వాటిపై వ్యామోహం పెరుగుతుంది. వ్యామోహం నుండి కోరిక, కోరిక నెరవేరకపోతే కోపం పుడతాయి.",
                "bn" to "ভোগ্যবস্তুর চিন্তা করতে করতে তাতে আসক্তি জন্মায়। আসক্তি থেকে কামনা এবং কামনা অপূর্ণ থাকলে ক্রোধের জন্ম হয়।",
                "mr" to "विषयांचे सतत चिंतन केल्याने त्यांच्यात आसक्ती निर्माण होते. आसक्तीतून वासना आणि वासनेत अडथळा आल्यास क्रोध उत्पन्न होतो.",
                "gu" to "વિષયોનું ચિંતન કરવાથી તેમાં આસક્તિ થાય છે. આસક્તિથી કામના અને કામના અટકે ત્યારે ક્રોધ પેદા થાય છે.",
                "kn" to "ವಿಷಯಗಳ ನಿರಂತರ ಚಿಂತನೆಯಿಂದ ಆಸಕ್ತಿ ಬೆಳೆಯುತ್ತದೆ. ಆಸಕ್ತಿಯಿಂದ ಕಾಮನೆ, ಕಾಮನೆ ಭಂಗವಾದಾಗ ಕ್ರೋಧ ಹುಟ್ಟುತ್ತದೆ.",
                "ml" to "വിഷയങ്ങളെ ചിന്തിക്കുമ്പോൾ ആസക്തിയും, ആസക്തിയിൽ നിന്ന് കാമവും, കാമത്തിൽ നിന്ന് ക്രോധവും ജനിക്കുന്നു.",
                "or" to "ବିଷୟ ଚିନ୍ତାରୁ ଆସକ୍ତି, ଆସକ୍ତିରୁ କାମନା ଏବଂ କାମନାରେ ବାଧା ଆସିଲେ କ୍ରୋଧ ଜନ୍ମ ନିଏ।",
                "pa" to "ਵਿਸ਼ਿਆਂ ਦੇ ਚਿੰਤਨ ਨਾਲ ਉਹਨਾਂ ਵਿੱਚ ਮੋਹ ਪੈਦਾ ਹੁੰਦਾ ਹੈ। ਮੋਹ ਤੋਂ ਕਾਮਨਾ ਅਤੇ ਕਾਮਨਾ ਵਿੱਚ ਰੁਕਾਵਟ ਨਾਲ ਕ੍ਰੋਧ ਭੜਕਦਾ ਹੈ।"
            ),
            lifeTheme = "Overcoming Anger & Obsession",
            guidance = mapOf(
                "en" to "Krishna diagnoses the psychology of anger: it always traces back to obsessive dwelling on desires. When things don't go your way, anger is born. Watch what you feed your mind daily—guard your attention, and anger loses its fuel.",
                "hi" to "क्रोध का मूल कारण इच्छाओं में रुकावट है। जब हम किसी वस्तु या परिस्थिति के प्रति अति-आसक्त हो जाते हैं, तो थोड़ा सा व्यवधान भी क्रोध बन जाता है। अपनी आसक्तियों को ढीला करें, क्रोध शांत हो जाएगा।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Where in your life did an unmet expectation turn into frustration? Can you let go of demanding that reality obey your wishes?",
                "hi" to "हाल ही में किस इच्छा के पूरा न होने पर आपको गुस्सा आया? क्या आप उस अपेक्षा को त्याग सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, when frustration arises, I will take three deep breaths and pause before reacting.",
                "hi" to "आज जब भी क्रोध या चिड़चिड़ापन आए, मैं प्रतिक्रिया देने से पहले शांत होकर श्वास लूंगा।"
            )
        ),
        GitaVerse(
            chapter = 2,
            verse = 70,
            sanskrit = "आपूर्यमाणमचलप्रतिष्ठं\nसमुद्रमापः प्रविशन्ति यद्वत्।\nतद्वत्कामा यं प्रविशन्ति सर्वे\nस शान्तिमाप्नोति न कामकामी॥",
            transliteration = "āpūryamāṇam achala-pratiṣhṭhaṁ\nsamudram āpaḥ praviśhanti yadvat\ntadvat kāmā yaṁ praviśhanti sarve\nsa śhāntim āpnoti na kāma-kāmī",
            translations = mapOf(
                "en" to "Just as the ocean remains undisturbed while countless rivers continuously pour into it, one who remains unmoved by the incoming flow of desires attains peace, not the person who strives to satisfy every desire.",
                "sa" to "यथा नाना नद्यः आपूर्यमाणं स्थिरं समुद्रं प्रविशन्ति तथापि समुद्रः न क्षुभ्यते, तथैव यस्मिन् मुनौ सर्वे भोगाः विलीनं गच्छन्ति स एव शान्तिं प्राप्नोति।",
                "hi" to "जैसे सब ओर से जल से परिपूर्ण समुद्र में अनेक नदियां प्रवेश करती हैं, फिर भी वह अपनी मर्यादा में स्थिर रहता है; वैसे ही जिस पुरुष में सब भोग बिना विचलित किए समा जाते हैं, वही शांति पाता है, भोगों की कामना करने वाला नहीं।",
                "ta" to "எல்லா நதிகளும் கடலில் கலந்தாலும் கடல் தன் அமைதியை இழப்பதில்லை; அதேபோல் ஆசைகளின் அலைகளால் அசைக்கப்படாதவனே உண்மையான அமைதியைப் பெறுகிறான்.",
                "te" to "అన్ని వైపుల నుండి నదులు ప్రవహించినా సముద్రం ఎలా నిశ్చలంగా ఉంటుందో, కోరికల వల్ల చలించని వాడే శాంతిని పొందుతాడు.",
                "bn" to "যেমন সমস্ত নদী সমুদ্রে মিশে গেলেও সমুদ্র শান্ত থাকে, তেমনই কামনাবাসনা যার মধ্যে লীন হয় তিনিই শান্তি পান।",
                "mr" to "नद्यांचे पाणी सामावून घेऊनही समुद्र जसा शांत राहतो, तसेच वासनांनी विचलित न होणारा मनुष्यच खरी शांती अनुभवतो.",
                "gu" to "જેમ સમુદ્રમાં બધી નદીઓ સમાઈ જાય છતાં તે સ્થિર રહે છે, તેમ જે મનુષ્યમાં બધી કામનાઓ શાંત થઈ જાય છે તે જ પરમ શાંતિ પામે છે.",
                "kn" to "ನದಿಗಳು ಬಂದು ಸೇರಿದರೂ ಸಾಗರವು ಹೇಗೆ ಶಾಂತವಾಗಿರುತ್ತದೆಯೋ, ಹಾಗೆ ಕಾಮನೆಗಳಿಂದ ವಿಚಲಿತನಾಗದವನೇ ಶಾಂತಿ ಪಡೆಯುತ್ತಾನೆ.",
                "ml" to "സമുദ്രം നദികളെ ഉൾക്കൊണ്ട് ശാന്തമായിരിക്കുന്നതുപോലെ, ആഗ്രഹങ്ങളാൽ ചലിക്കാത്തവൻ ശാന്തി നേടുന്നു.",
                "or" to "ଯେପରି ନଦୀଗୁଡ଼ିକ ମିଶିଲେ ବି ସମୁଦ୍ର ସ୍ଥିର ରହେ, ସେପରି କାମନା ଦ୍ୱାରା ଅବିଚଳିତ ବ୍ୟକ୍ତି ହିଁ ଶାନ୍ତି ଲାଭ କରେ।",
                "pa" to "ਜਿਸ ਤਰ੍ਹਾਂ ਨਦੀਆਂ ਦੇ ਪਾਣੀ ਨਾਲ ਵੀ ਸਮੁੰਦਰ ਸ਼ਾਂਤ ਰਹਿੰਦਾ ਹੈ, ਉਸੇ ਤਰ੍ਹਾਂ ਇੱਛਾਵਾਂ ਤੋਂ ਅਡਿੱਗ ਰਹਿਣ ਵਾਲਾ ਹੀ ਸ਼ਾਂਤੀ ਪਾਉਂਦਾ ਹੈ।"
            ),
            lifeTheme = "Oceanic Inner Peace",
            guidance = mapOf(
                "en" to "Be like the ocean, vast and deep. Outer thoughts, notifications, compliments, and insults are like river waters entering you—let them enter and dissolve without disturbing your foundational calm.",
                "hi" to "समुद्र की तरह गहरे और गंभीर बनें। विचार और परिस्थितियां आएंगी और जाएंगी, अपने आंतरिक शांत स्वभाव को कभी न खोएं।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Feel the vast, undisturbed stillness beneath the surface chatter of your mind. Rest in that ocean.",
                "hi" to "अपने मन की सतह के नीचे बह रही अगाध शांति को महसूस करें। आप वह समुद्र हैं।"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I choose to remain centered like the ocean, no matter what waves splash against me.",
                "hi" to "आज मैं हर परिस्थिति में समुद्र की भांति अडिग और शांत बना रहूंगा।"
            )
        ),
        GitaVerse(
            chapter = 6,
            verse = 5,
            sanskrit = "उद्धरेदात्मनात्मानं नात्मानमवसादयेत्।\nआत्मैव ह्यात्मनो बन्धुरात्मैव रिपुरात्मनः॥",
            transliteration = "uddhared ātmanātmānaṁ nātmānam avasādayet\nātmaiva hyātmano bandhur ātmaiva ripur ātmanaḥ",
            translations = mapOf(
                "en" to "Elevate yourself through the power of your mind, and do not degrade yourself. For the mind can be your greatest friend, and the mind can also be your greatest enemy.",
                "sa" to "मनुष्यः स्वमनसा एव स्वस्य उद्धारं कुर्यात्, आत्मानं नैव अधः पातयेत्। यतः आत्मनः (मनसः) बन्धुः स्वयमेव, तथा आत्मनः शत्रुः अपि स्वयमेव अस्ति।",
                "hi" to "मनुष्य को चाहिए कि वह अपने मन के द्वारा अपना उद्धार करे, अपने को नीचे न गिराए। क्योंकि मन ही मनुष्य का सबसे बड़ा मित्र है और मन ही उसका सबसे बड़ा शत्रु है।",
                "ta" to "உன் மனதால் உன்னை உயர்த்திக் கொள்; உன்னை தாழ்த்திக் கொள்ளாதே. ஏனெனில் மனம் உனக்கு நண்பனாகவும் இருக்கலாம், பகைவனாகவும் மாறலாம்.",
                "te" to "నీ మనస్సు ద్వారా నిన్ను నీవు ఉద్ధరించుకో, అధోగతి పాలు చేసుకోకు. మనస్సే నీకు ఆప్తమిత్రుడు, మనస్సే నీకు పరమ శత్రువు.",
                "bn" to "নিজের মন দ্বারা নিজেকে উন্নত করো, অধঃপতিত হতে দিও না। কারণ মনই তোমার একমাত্র বন্ধু এবং মনই তোমার শত্রু।",
                "mr" to "आपल्या मनानेच स्वतःचा उद्धार करा, स्वतःला कधीही हीन लेखू नका. कारण मन हेच आपले मित्र आणि मन हेच आपले वैरी आहे.",
                "gu" to "પોતાના મન દ્વારા પોતાનો ઉદ્ધાર કરો, ક્યારેય હતાશ ન થાઓ. મન જ આપણો પરમ મિત્ર છે અને મન જ શત્રુ છે.",
                "kn" to "ನಿನ್ನ ಮನಸ್ಸಿನಿಂದ ನಿನ್ನನ್ನು ಉದ್ಧಾರ ಮಾಡಿಕೊ, ಕೀಳಾಗಿ ಕಾಣಬೇಡ. ಮನಸ್ಸೇ ನಿನ್ನ ಮಿತ್ರ, ಮನಸ್ಸೇ ನಿನ್ನ ಶತ್ರು.",
                "ml" to "മനസ്സുകൊണ്ട് സ്വയം ഉയരുക, തളരരുത്. മനസ്സ് തന്നെയാണ് മിത്രവും ശത്രുവും.",
                "or" to "ନିଜ ମନ ଦ୍ୱାରା ନିଜର ଉନ୍ନତି କର, ନିଜକୁ ହତାଶ କର ନାହିଁ। କାରଣ ମନ ହିଁ ମିତ୍ର ଓ ମନ ହିଁ ଶତ୍ରୁ।",
                "pa" to "ਆਪਣੇ ਮਨ ਨਾਲ ਆਪਣਾ ਉਧਾਰ ਕਰੋ, ਨਿਰਾਸ਼ ਨਾ ਹੋਵੋ। ਮਨ ਹੀ ਮਿੱਤਰ ਹੈ ਅਤੇ ਮਨ ਹੀ ਵੈਰੀ ਹੈ।"
            ),
            lifeTheme = "Self-Belief & Mind Mastery",
            guidance = mapOf(
                "en" to "Never give up on yourself or speak harshly to your inner self. When your mind is trained in positive, truthful habits, it becomes a loyal guardian. When allowed to wander into negative rumination, it becomes your fiercest tormentor. Train your mind like a cherished friend.",
                "hi" to "कभी भी अपने प्रति नकारात्मक न सोचें। आपका मन यदि सकारात्मक और अनुशासित है, तो आपका सबसे बड़ा मित्र है। यदि अनियंत्रित है, तो शत्रु बन जाता है। अपने मन से मित्रता करें।"
            ),
            contemplationPrompt = mapOf(
                "en" to "How is your inner self-talk right now? Is your mind speaking to you as an encouraging friend or a harsh critic?",
                "hi" to "आपका मन आपसे इस समय कैसा संवाद कर रहा है? एक सच्चे मित्र की तरह या एक आलोचक की तरह?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I will practice self-compassion and lift myself up with positive, mindful thoughts.",
                "hi" to "आज मैं आत्म-सहानુભूતિ रखूंगा और अपने मन को शुभ संकल्पों से भरूंगा।"
            )
        ),
        GitaVerse(
            chapter = 6,
            verse = 26,
            sanskrit = "यतो यतो निश्चरति मनश्चञ्चलमस्थिरम्।\nततस्ततो नियम्यैतदात्मन्येव वशं नयेत्॥",
            transliteration = "yato yato niśhcharati manaśh chañchalam asthiram\ntatas tato niyamyaitad ātmanyeva vaśhaṁ nayet",
            translations = mapOf(
                "en" to "From wherever the fickle and unsteady mind wanders away, one should gently restrain it and bring it back under the control of the Self.",
                "sa" to "चञ्चलं तथा अस्थिरं मनः येभ्यः येभ्यः विषयेभ्यः बहिः धावति, तेभ्यः तेभ्यः तं नियम्य पुनः आत्मनि एव स्थापयेत्।",
                "hi" to "यह चंचल और अस्थिर मन जिस-जिस विषय की ओर भटके, उन-उन विषयों से इसको हटाकर बार-बार अपनी आत्मा (सच्चे स्वरूप) में ही स्थिर करे।",
                "ta" to "அலைபாயும் சஞ்சலமான மனம் எங்கெல்லாம் ஓடுகிறதோ, அங்கிருந்தெல்லாம் அதைத் தடுத்து நிறுத்தி ஆன்மாவில் நிலைநிறுத்த வேண்டும்.",
                "te" to "చంచలమైన మనస్సు ఎటువైపు పరుగెత్తుతుందో, అక్కడి నుంచి దాన్ని మరలించి మళ్లీ ఆత్మ యందే నిలపాలి.",
                "bn" to "চঞ্চল ও অস্থির মন যে যে দিকে ধাবিত হয়, সেখান থেকে একে ফিরিয়ে এনে আত্মাতেই স্থির করতে হবে।",
                "mr" to "चंचल मन ज्या ज्या दिशेला भटकते, तिथून त्याला परत आणून अंतरात्म्यात स्थिर करावे.",
                "gu" to "ચંચળ મન જ્યાં જ્યાં ભટકે ત્યાંથી તેને પાછું લાવીને આત્મામાં સ્થિર કરવું.",
                "kn" to "ಚಂಚಲ ಮನಸ್ಸು ಎಲ್ಲಿಗೆ ಓಡುತ್ತದೆಯೋ, ಅಲ್ಲಿಂದ ಅದನ್ನು ಮರಳಿ ತಂದು ಆತ್ಮದಲ್ಲಿ ನೆಲೆಗೊಳಿಸು.",
                "ml" to "ചഞ്ചലമായ മനസ്സ് എങ്ങോട്ടൊക്കെ അലയുന്നുവോ, അവിടെനിന്നെല്ലാം അതിനെ തിരിച്ചുപിടിച്ച് ആത്മാവിൽ ഉറപ്പിക്കുക.",
                "or" to "ଚଞ୍ଚଳ ମନ ଯେଉଁଆଡ଼େ ଭ୍ରମଣ କରେ, ସେଠାରୁ ତାକୁ ଫେରାଇ ଆଣି ଆତ୍ମାରେ ସ୍ଥିର କର।",
                "pa" to "ਚੰਚਲ ਮਨ ਜਿੱਥੇ-ਜਿੱਥੇ ਭਟਕਦਾ ਹੈ, ਉੱਥੋਂ ਮੋੜ ਕੇ ਇਸਨੂੰ ਆਤਮਾ ਵਿੱਚ ਸਥਿਰ ਕਰੋ।"
            ),
            lifeTheme = "Gentle Mindfulness & Focus",
            guidance = mapOf(
                "en" to "Krishna does not tell us to brutally force or punish the mind when it wanders during work or meditation. Simply notice with kindness: 'Ah, my mind drifted,' and gently guide it back to your breath and duty, again and again.",
                "hi" to "मन का स्वभाव भटकना है। जब भी ध्यान या काम से मन हटे, तो क्रोधित न हों। स्नेह और कोमलता से उसे पुनः अपने कर्तव्य और ईश्वर में लौटा लाएं।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Notice where your attention is right now. Can you gently return it to the present moment without self-judgment?",
                "hi" to "इस क्षण आपका ध्यान कहाँ है? क्या आप बिना किसी शिकायत के उसे वर्तमान में ला सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I will gently bring my attention back to the present whenever I catch myself daydreaming or worrying.",
                "hi" to "आज जब भी मन भटकेगा, मैं धैर्यपूर्वक उसे वर्तमान क्षण में वापस लाऊंगा।"
            )
        ),
        GitaVerse(
            chapter = 6,
            verse = 35,
            sanskrit = "श्रीभगवानुवाच\nअसंशयं महाबाहो मनो दुर्निग्रहं चलम्।\nअभ्यासेन तु कौन्तेय वैराग्येण च गृह्यते॥",
            transliteration = "śhrī-bhagavān uvācha\nasaṁśhayaṁ mahā-bāho mano durnigrahaṁ chalam\nabhyāsena tu kaunteya vairāgyeṇa cha gṛihyate",
            translations = mapOf(
                "en" to "Lord Krishna said: O mighty-armed son of Kunti, without doubt the mind is exceedingly hard to subdue and restless. But it can be mastered through persistent practice (Abhyasa) and detachment (Vairagya).",
                "sa" to "श्रीभगवान् उवाच—हे महाबाहो! निःसन्देहं मनः चञ्चलं दुर्निग्रहं च अस्ति। किन्तु हे कौन्तेय! अभ्यासेन (पुनः पुनः यत्नेन) तथा वैराग्येण एतत् वशीक्रियते।",
                "hi" to "श्री भगवान बोले—हे महाबाहो! निःसंदेह मन चंचल और कठिनता से वश में होने वाला है। परन्तु हे कुन्तीपुत्र! यह अभ्यास और वैराग्य के द्वारा वश में किया जा सकता है।",
                "ta" to "பகவான் கூறினார்: அடக்குவதற்கு கடினமானதும் அலைபாயக் கூடியதுமான மனம் என்பதில் ஐயமில்லை. ஆயினும் தொடர்ந்த பயிற்சியினாலும் பற்றின்மையினாலும் அதை வசப்படுத்தலாம்.",
                "te" to "భగవానుడు పలికెను: నిస్సందేహంగా మనస్సు చంచలమైనది, నిగ్రహించడం కష్టమైనదే. కానీ నిరంతర సాధన మరియు వైరాగ్యం ద్వారా దాన్ని వశం చేసుకోవచ్చు.",
                "bn" to "ভগবান বললেন: হে অর্জুন! নিশ্চয়ই মন অত্যন্ত চঞ্চল ও নিয়ন্ত্রণ করা কঠিন। কিন্তু নিরন্তর অভ্যাস এবং বৈরাগ্যের দ্বারা একে বশ করা সম্ভব।",
                "mr" to "श्रीकृष्ण म्हणाले: मन खरोखरच चंचल आणि आवरण्यास कठीण आहे. पण निरंतर सराव आणि अनासक्तीने त्यावर ताबा मिळवता येतो.",
                "gu" to "ભગવાન બોલ્યા: નિઃસંદેહ મન ચંચળ અને કાબૂમાં રાખવું મુશ્કેલ છે, પરંતુ અભ્યાસ અને વૈરાગ્યથી તે વશ થાય છે.",
                "kn" to "ಶ್ರೀಕೃಷ್ಣನು ಹೇಳಿದನು: ಮನಸ್ಸು ಚಂಚಲವೂ ನಿಗ್ರಹಿಸಲು ಕಷ್ಟವೂ ಹೌದು. ಆದರೆ ನಿರಂತರ ಅಭ್ಯಾಸ ಮತ್ತು ವೈರಾಗ್ಯದಿಂದ ಅದನ್ನು ಗೆಲ್ಲಬಹುದು.",
                "ml" to "ഭഗവാൻ പറഞ്ഞു: മനസ്സ് അടക്കാൻ പ്രയാസമുള്ളതും ചഞ്ചലവുമാണ്. എന്നാൽ നിരന്തരമായ അഭ്യാസത്താലും വൈരാഗ്യത്താലും അതിനെ നിയന്ത്രിക്കാം.",
                "or" to "ଶ୍ରୀ ଭଗବାନ କହିଲେ: ମନ ଚଞ୍ଚଳ ଓ କଠିନ, କିନ୍ତୁ ଅଭ୍ୟାସ ଓ ବୈରାଗ୍ୟ ଦ୍ୱାରା ଏହାକୁ ବଶ କରାଯାଇପାରିବ।",
                "pa" to "ਸ਼੍ਰੀ ਕ੍ਰਿਸ਼ਨ ਨੇ ਕਿਹਾ: ਬੇਸ਼ੱਕ ਮਨ ਬਹੁਤ ਚੰਚਲ ਹੈ, ਪਰ ਨਿਰੰਤਰ ਅਭਿਆਸ ਅਤੇ ਵੈਰਾਗ ਨਾਲ ਇਸਨੂੰ ਕਾਬੂ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ।"
            ),
            lifeTheme = "Overcoming the Restless Mind",
            guidance = mapOf(
                "en" to "Krishna validates your struggle: yes, calming the mind is difficult for everyone. But he gives the twin remedies: Abhyasa (consistent daily practice) and Vairagya (letting go of trivial cravings). Don't expect instant perfection; trust daily practice.",
                "hi" to "भगवान कृष्ण स्वयं स्वीकारते हैं कि मन को रोकना कठिन है। निराश न हों! अभ्यास (निरंतर प्रयास) और वैराग्य (अनावश्यक इच्छाओं से मुक्ति) से मन धीरे-धीरे वश में आ जाता है।"
            ),
            contemplationPrompt = mapOf(
                "en" to "What small habit of stillness can you commit to practicing every single day, even for just 5 minutes?",
                "hi" to "ऐसी कौन सी छोटी साधना है जिसे आप प्रतिदिन बिना नागा 5 मिनट भी करने का संकल्प ले सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I will trust the power of small, consistent efforts rather than expecting overnight perfection.",
                "hi" to "आज मैं निरंतर अभ्यास में विश्वास रखूंगा और अधीर नहीं होऊंगा।"
            )
        ),
        GitaVerse(
            chapter = 9,
            verse = 22,
            sanskrit = "अनन्याश्चिन्तयन्तो मां ये जनाः पर्युपासते।\nतेषां नित्याभियुक्तानां योगक्षेमं वहाम्यहम्॥",
            transliteration = "ananyāśh chintayanto māṁ ye janāḥ paryupāsate\nteṣhāṁ nityābhiyuktānāṁ yoga-kṣhemaṁ vahāmyaham",
            translations = mapOf(
                "en" to "To those who always remember Me with undivided devotion and meditate on Me, to them who are constantly united with Me, I personally carry and preserve what they lack and protect what they have.",
                "sa" to "ये जनाः अनन्यभावेन मां चिन्तयन्तः सम्यक् उपासते, तेषां नित्ययुक्तानां भक्तानां योगक्षेमं (अप्राप्तस्य प्राप्तिं प्राप्तस्य च रक्षणं) अहं स्वयम् वहामि।",
                "hi" to "जो अनन्य भक्तजन मेरा ही चिंतन करते हुए मुझे भजते हैं, उन नित्य-युक्त पुरुषों के योग-क्षेम (जो उनके पास नहीं है उसे देना और जो है उसकी रक्षा करना) का वहन मैं स्वयं करता हूँ।",
                "ta" to "வேறெந்த சிந்தனையுமின்றி என்னை மட்டுமே வழிபடும் பக்தர்களுக்கு, அவர்களுக்குத் தேவையானதை வழங்கி, அவர்களிடம் உள்ளதைப் பாதுகாக்கும் பொறுப்பை நானே ஏற்கிறேன்.",
                "te" to "అనన్య భక్తితో నన్నే స్మరిస్తూ ఉపాసించే నిత్య భక్తుల యోగక్షేమాలను నేనే స్వయంగా వహిస్తాను.",
                "bn" to "যারা অনন্য চিত্তে আমার ধ্যান করে আমার উপাসনা করেন, সেই নিত্যযুক্ত ভক্তদের যাবতীয় প্রয়োজন আমি বহন করি।",
                "mr" to "जे अनन्यभावाने माझे चिंतन करत माझी भक्ती करतात, त्यांच्या योगक्षेमाची काळजी मी स्वतः घेतो.",
                "gu" to "જે અનન્યભાવે મારું ચિંતન કરીને મારી ઉપાસના કરે છે, તેમના યોગક્ષેમનું વહન હું પોતે કરું છું.",
                "kn" to "ಯಾರು ಬೇರೆ ಯಾವುದೇ ಚಿಂತೆಯಿಲ್ಲದೆ ನನ್ನನ್ನೇ ಧ್ಯಾನಿಸುತ್ತಾರೋ, ಅಂತಹ ಭಕ್ತರ ಯೋಗಕ್ಷೇಮವನ್ನು ನಾನೇ ಹೊರುತ್ತೇನೆ.",
                "ml" to "ഏകാഗ്രതയോടെ എന്നെ മാത്രം ഭജിക്കുന്നവരുടെ യോഗക്ഷേമം ഞാൻ സ്വയം വഹിക്കുന്നു.",
                "or" to "ଯେଉଁମାନେ ଏକାଗ୍ର ଭାବରେ ମୋର ଉପାସନା କରନ୍ତି, ସେମାନଙ୍କର ଯୋଗକ୍ଷେମ ମୁଁ ନିଜେ ବହନ କରେ।",
                "pa" to "ਜੋ ਪੂਰੀ ਸ਼ਰਧਾ ਨਾਲ ਮੈਨੂੰ ਯਾਦ ਕਰਦੇ ਹਨ, ਉਹਨਾਂ ਦੇ ਯੋਗ-ਖੇਮ ਦੀ ਜ਼ਿੰਮੇਵਾਰੀ ਮੈਂ ਖੁਦ ਚੁੱਕਦਾ ਹਾਂ।"
            ),
            lifeTheme = "Divine Grace & Refuge in Anxiety",
            guidance = mapOf(
                "en" to "You don't have to carry the overwhelming burdens of life alone. When you act with integrity and surrender the outcome to the Divine, the universe aligns to support and protect you. Relax into this divine assurance.",
                "hi" to "जीवन का सारा बोझ अकेले अपने कंधों पर मत उठाइए। जब आप सच्ची निष्ठा से अपना कर्म करते हैं और समर्पण करते हैं, तो परमात्मा स्वयं आपका ध्यान रखते हैं। चिंता त्यागें।"
            ),
            contemplationPrompt = mapOf(
                "en" to "What heavy worry can you consciously surrender into the hands of the Divine today?",
                "hi" to "आज अपनी किस भारी चिंता को आप ईश्वर के चरणों में समर्पित कर हल्का महसूस कर सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I walk with faith knowing that grace guides and sustains my path.",
                "hi" to "आज मैं इस विश्वास के साथ जिऊंगा कि ईश्वर मेरे साथ हैं और मेरा कल्याण करेंगे।"
            )
        ),
        GitaVerse(
            chapter = 18,
            verse = 66,
            sanskrit = "सर्वधर्मान्परित्यज्य मामेकं शरणं व्रज।\nअहं त्वा सर्वपापेभ्यो मोक्षयिष्यामि मा शुचः॥",
            transliteration = "sarva-dharmān parityajya mām ekaṁ śharaṇaṁ vraja\nahaṁ tvāṁ sarva-pāpebhyo mokṣhayiṣhyāmi mā śhuchaḥ",
            translations = mapOf(
                "en" to "Abandon all varieties of dharmas and simply surrender unto Me alone. I shall liberate you from all sins and sorrow. Do not fear, do not grieve.",
                "sa" to "सर्वान् धर्मान् परित्यज्य केवलं ममैव शरणं आगच्छ। अहं त्वां सर्वेभ्यः पापेभ्यः मुञ्चयिष्यामि, शोकं मा कुरु।",
                "hi" to "सब धर्मों को (सभी मानसिक बंधनों व कर्ताभाव को) त्यागकर केवल मेरी शरण में आ जाओ। मैं तुम्हें समस्त पापों और भयों से मुक्त कर दूंगा; शोक मत करो।",
                "ta" to "அனைத்து கவலைகளையும் கடமைகளையும் என் மீது சமர்ப்பித்து, என்னை மட்டுமே சரணடை. உன்னை அனைத்து துயரங்களிலிருந்தும் விடுவிப்பேன்; அஞ்சாதே.",
                "te" to "సమస్త ధర్మాలను పరిత్యజించి నన్ను మాత్రమే శరణు వేడుము. నిన్ను సమస్త పాపముల నుండి నేను విముక్తుడిని చేస్తాను; దుఃఖించకు.",
                "bn" to "সর্বধর্ম ত্যাগ করে একমাত্র আমারই শরণ গ্রহণ করো। আমি তোমাকে সমস্ত পাপ ও শোক থেকে মুক্ত করব; কোনো ভয় পেয়ো না।",
                "mr" to "सर्व बंधने सोडून केवळ माझ्या चरणी लीन हो. मी तुला सर्व संकटांतून मुक्त करीन; मुळीच शोक करू नकोस.",
                "gu" to "બધા ધર્મો છોડીને કેવળ મારી શરણમાં આવી જા. હું તને બધા પાપોમાંથી મુક્ત કરીશ; શોક ન કર.",
                "kn" to "ಎಲ್ಲವನ್ನೂ ತ್ಯಜಿಸಿ ನನ್ನೊಬ್ಬನನ್ನೇ ಶರಣುಹೊಂದು. ನಿನ್ನನ್ನು ಎಲ್ಲ ಪಾಪಗಳಿಂದ ನಾನು ಮುಕ್ತಗೊಳಿಸುತ್ತೇನೆ; ಶೋಕಿಸಬೇಡ.",
                "ml" to "എല്ലാ ധർമ്മങ്ങളും വെടിഞ്ഞ് എന്നെ മാത്രം ശരണം പ്രാപിക്കുക. ഞാൻ നിന്നെ സർവ്വ പാപങ്ങളിൽ നിന്നും മോചിപ്പിക്കും; ഭയപ്പെടേണ്ട.",
                "or" to "ସମସ୍ତ ଧର୍ମ ତ୍ୟାଗ କରି କେବଳ ମୋ ଶରଣକୁ ଆସ। ମୁଁ ତୁମକୁ ସମସ୍ତ ପାପରୁ ମୁକ୍ତ କରିବି; ଶୋକ କର ନାହିଁ।",
                "pa" to "ਸਾਰੇ ਧਰਮਾਂ ਨੂੰ ਤਿਆਗ ਕੇ ਕੇਵਲ ਮੇਰੀ ਸ਼ਰਣ ਵਿੱਚ ਆ ਜਾ। ਮੈਂ ਤੈਨੂੰ ਸਾਰੇ ਦੁੱਖਾਂ ਤੋਂ ਮੁਕਤ ਕਰਾਂਗਾ; ਚਿੰਤਾ ਨਾ ਕਰ।"
            ),
            lifeTheme = "Ultimate Surrender & Freedom from Fear",
            guidance = mapOf(
                "en" to "This is Krishna's crowning promise: whenever guilt, confusion, and fear overwhelm you, lay down your ego's burdens at His feet. 'Mā śhuchaḥ' means 'Do not grieve.' You are unconditionally loved, forgiven, and guided.",
                "hi" to "यह गीता का परम आश्वासन है। जब भी असहाय महसूस करें, अपने अहं और संशयों को प्रभु के चरणों में समर्पित कर दें। 'मा शुचः'—शोक मत करो, तुम कभी अकेले नहीं हो।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Can you exhale all guilt and anxiety, resting in total trust of the divine wisdom?",
                "hi" to "क्या आप अपने भीतर के सारे अपराधबोध और चिंता को छोड़कर परम शांति में विश्राम कर सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I choose surrender over struggle and inner peace over panic.",
                "hi" to "आज मैं संघर्ष के स्थान पर समर्पण और भय के स्थान पर भगवत्-विश्वास चुनूंगा।"
            )
        ),
        GitaVerse(
            chapter = 3,
            verse = 19,
            sanskrit = "तस्मादसक्तः सततं कार्यं कर्म समाचर।\nअसक्तो ह्याचरन्कर्म परमाप्नोति पूरुषः॥",
            transliteration = "tasmād asaktaḥ satataṁ kāryaṁ karma samāchara\nasakto hy ācharan karma param āpnoti pūruṣhaḥ",
            translations = mapOf(
                "en" to "Therefore, without attachment to personal gain, constantly perform the duties that are prescribed for you. By working selflessly, one attains the supreme state.",
                "sa" to "तस्मात् त्वम् आसक्तिरहितः सन् नियतं कर्तव्यकर्म कुरु। आसक्तिं विहाय कर्म कुर्वन् मनुष्यः परमं पदं प्राप्नोति।",
                "hi" to "इसलिए तुम आसक्ति से रहित होकर निरंतर अपने कर्तव्य कर्म का भली-भांति आचरण करो, क्योंकि अनासक्त होकर कर्म करता हुआ मनुष्य परमात्मा को प्राप्त होता है।",
                "ta" to "எனவே பற்றின்றி கடமைகளை தொடர்ந்து செய். பற்றற்ற செயலின் மூலமே மனிதன் மேலான நிலையை அடைகிறான்.",
                "te" to "కాబట్టి ఫలాసక్తిని విడిచిపెట్టి నిరంతరం నీ కర్తవ్య కర్మలను ఆచరించు. నిష్కామ కర్మ ద్వారా మానవుడు పరమపదాన్ని పొందుతాడు."
            ),
            lifeTheme = "Dedicated Action without Selfish Attachment",
            guidance = mapOf(
                "en" to "Procrastination and lack of motivation dissolve when you shift from 'What will I get?' to 'What can I give and do with excellence right now?' Pour your heart into the work before you.",
                "hi" to "आलस्य और अनिच्छा तब समाप्त होती है जब आप फल के मोह से हटकर कर्तव्य के आनंद में लीन होते हैं। अपने कर्म को ही ईश्वर की पूजा बनाएं।"
            ),
            contemplationPrompt = mapOf(
                "en" to "What is one task waiting on your desk that you can complete today purely for the joy of doing it well?",
                "hi" to "आज कौन सा ऐसा कार्य है जिसे आप बिना किसी शिकायत के पूर्ण निष्ठा से संपन्न करेंगे?"
            ),
            mindfulIntention = mapOf(
                "en" to "I act with passion, diligence, and selfless commitment today.",
                "hi" to "आज मैं अपने प्रत्येक कार्य को पूर्ण समर्पण और निष्ठा के साथ करूँगा।"
            )
        ),
        GitaVerse(
            chapter = 3,
            verse = 35,
            sanskrit = "श्रेयान्स्वधर्मो विगुणः परधर्मात्स्वनुष्ठितात्।\nस्वधर्मे निधनं श्रेयः परधर्मो भयावहः॥",
            transliteration = "śhreyān sva-dharmo viguṇaḥ para-dharmāt sv-anuṣhṭhitāt\nsva-dharme nidhanaṁ śhreyaḥ para-dharmo bhayāvahaḥ",
            translations = mapOf(
                "en" to "Better is one's own natural duty, though imperfectly performed, than another's duty performed to perfection. Destruction in one's own natural calling is beneficial, but following an alien path is perilous.",
                "sa" to "उत्तमप्रकारेण आचरितात् परधर्मात् अपूर्णः अपि स्वधर्मः श्रेष्ठः। स्वधर्मे मरणं कल्याणकरं, परधर्मः तु भयप्रदः अस्ति।",
                "hi" to "दूसरों के कर्तव्य का भली-भाँति पालन करने की अपेक्षा अपना प्राकृतिक कर्तव्य (स्वधर्म) दोषयुक्त होते हुए भी अधिक कल्याणकारी है। अपने स्वभावानुकूल धर्म में जीना ही श्रेयस्कर है, दूसरों का अनुकरण भयप्रद है।",
                "ta" to "பிறரின் கடமையை திறம்பட செய்வதை விட, தன் சொந்த இயல்பான கடமையை செய்வதே சிறந்தது. அடுத்தவரின் வழியைப் பின்பற்றுவது ஆபத்தானது.",
                "te" to "ఇతరుల ధర్మాన్ని చక్కగా ఆచరించడం కన్నా, లోపభూయిష్టమైనదైనా తన స్వధర్మాన్ని ఆచరించడమే శ్రేయస్కరం. ఇతరుల మార్గం భయావహమైనది."
            ),
            lifeTheme = "Authenticity & Honoring Your True Calling (Swadharma)",
            guidance = mapOf(
                "en" to "Stop comparing your journey, status, or timeline with others. When you try to live someone else's definition of success, you create inner turmoil. Embrace your authentic strengths and walk your own path with integrity.",
                "hi" to "दूसरों की नकल और तुलना करना छोड़ दें। आपका व्यक्तित्व, आपकी यात्रा और आपकी क्षमताएं अनूठी हैं। अपने स्वाभाविक गुणों को पहचानें और अपने मार्ग पर अडिग रहें।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Where in your life are you copying someone else instead of honoring your authentic gifts?",
                "hi" to "जीवन के किस क्षेत्र में आप दूसरों की अपेक्षाओं या अनुकरण के बोझ तले दबे हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "I honor my unique nature and walk my genuine path with courage.",
                "hi" to "आज मैं अपनी अनूठी प्रतिभा और मार्ग का सम्मान करूँगा।"
            )
        ),
        GitaVerse(
            chapter = 4,
            verse = 38,
            sanskrit = "न हि ज्ञानेन सदृशं पवित्रमिह विद्यते।\nतत्स्वयं योगसंसिद्धः कालेनात्मनि विन्दति॥",
            transliteration = "na hi jñānena sadṛiśhaṁ pavitram iha vidyate\ntat svayaṁ yoga-saṁsiddhaḥ kālenātmani vindati",
            translations = mapOf(
                "en" to "In this world, there is nothing as purifying as spiritual knowledge and wisdom. One who has attained mastery through yoga realizes this truth within their own heart in due course of time.",
                "sa" to "अस्मिन् संसारे ज्ञानेन सदृशं पवित्रं किमपि नास्ति। योगेन संसिद्धः पुरुषः कालेन तज्ज्ञानं स्वयमेव आत्मनि प्राप्नोति।",
                "hi" to "इस संसार में ज्ञान के समान पवित्र करने वाला वास्तव में कुछ भी नहीं है। उस ज्ञान को कर्मयोग में निष्णात हुआ मनुष्य समय पाकर स्वतः ही अपने अंतःकरण में अनुभव करता है।",
                "ta" to "இந்த உலகில் மெய்ஞ்ஞானத்தைப் போல தூய்மையானது வேறு எதுவும் இல்லை. யோகத்தில் தேர்ச்சி பெற்றவன் அதை காலப்போக்கில் தன் இதயத்தில் உணர்கிறான்.",
                "te" to "ఈ లోకంలో జ్ఞానంతో సమానమైన పవిత్రమైనది ఏదీ లేదు. కర్మయోగంలో సిద్ధుడైనవాడు కాలక్రమేణా ఆ జ్ఞానాన్ని తన ఆత్మలోనే పొందుతాడు."
            ),
            lifeTheme = "The Purifying Power of Wisdom & Continuous Learning",
            guidance = mapOf(
                "en" to "Whenever confusion or feelings of inadequacy cloud your mind, seek understanding rather than hasty reaction. Wisdom burns through the darkness of doubt like dawn burns through the night.",
                "hi" to "जब भी जीवन में भ्रम या अज्ञान का अंधेरा छाए, तो सीखने और ज्ञान के प्रकाश की ओर बढ़ें। आत्मज्ञान समस्त संशयों और भयों को भस्म कर देता है।"
            ),
            contemplationPrompt = mapOf(
                "en" to "What is one deeper truth or lesson your current challenge is trying to teach you?",
                "hi" to "आपकी वर्तमान चुनौती आपको कौन सी महत्वपूर्ण सीख देने का प्रयास कर रही है?"
            ),
            mindfulIntention = mapOf(
                "en" to "I remain an open, humble student of life, seeking truth and understanding.",
                "hi" to "आज मैं एक जागरूक शिक्षार्थी बनकर ज्ञान और समझ को आत्मसात करूँगा।"
            )
        ),
        GitaVerse(
            chapter = 12,
            verse = 13,
            sanskrit = "अद्वेष्टा सर्वभूतानां मैत्रः करुण एव च।\nनिर्ममो निरहङ्कारः समदुःखसुखः क्षमी॥",
            transliteration = "adveṣhṭā sarva-bhūtānāṁ maitraḥ karuṇa eva cha\nnirmamo nirahaṅkāraḥ sama-duḥkha-sukhaḥ kṣhamī",
            translations = mapOf(
                "en" to "One who is free from malice toward all beings, friendly and compassionate, free from possessiveness and ego, balanced in pleasure and pain, and forgiving—such a devotee is very dear to Me.",
                "sa" to "यः सर्वभूतानां द्वेषरहितः, मित्रभावयुक्तः, दयावान्, ममतारहितः, अहङ्कारशून्यः, सुखदुःखयोः समः, क्षमाशीलः च वर्तते, सः मम प्रियः।",
                "hi" to "जो किसी भी प्राणी से द्वेष नहीं करता, सबका मित्र और दयालु है, ममता और अहंकार से मुक्त है, सुख-दुःख में समभाव रखता है और क्षमावान है—वह मुझे अतिशय प्रिय है।",
                "ta" to "எவரிடமும் பகையின்றி, அனைவரிடமும் நட்புடனும் கருணையுடனும், 'எனது' என்ற அகந்தையின்றி, இன்ப துன்பங்களில் சமநிலை கொண்டு, மன்னிக்கும் குணம் கொண்டவனே எனக்கு மிகவும் பிரியமானவன்.",
                "te" to "ఎవరిపట్లా ద్వేషం లేకుండా, అందరితో మైత్రి, కరుణ కలిగి, మమకారం అహంకారం లేక, సుఖదుఃఖాలలో సమభావం పాటిస్తూ, క్షమాగుణం కలవాడు నాకు అత్యంత ప్రియుడు."
            ),
            lifeTheme = "Harmony in Relationships, Compassion & Forgiveness",
            guidance = mapOf(
                "en" to "When dealing with difficult people or broken relationships, protect your peace by dropping the poison of bitterness. Forgive not because they necessarily deserve it, but because your soul deserves tranquility.",
                "hi" to "सम्बन्धों में कलह और कटुता का समाधान क्रोध नहीं, बल्कि क्षमा और मैत्रीभाव है। जब आप बदले की भावना त्यागते हैं, तो सबसे पहले आपका अपना हृदय शांत और निर्मल होता है।"
            ),
            contemplationPrompt = mapOf(
                "en" to "Who in your life can you release from your resentment today, freeing yourself from emotional baggage?",
                "hi" to "आज आप अपने मन से किसके प्रति शिकायत या नाराजगी को क्षमा में परिवर्तित कर सकते हैं?"
            ),
            mindfulIntention = mapOf(
                "en" to "Today, I respond to negativity with calmness, kindness, and clear boundaries.",
                "hi" to "आज मैं कटुता के उत्तर में शांति, सद्भाव और क्षमा का वरण करूँगा।"
            )
        )
    )

    fun getVerseByCitation(citation: String): GitaVerse? {
        val clean = citation.trim().replace(":", ".").uppercase()
        return VERSES.firstOrNull { 
            it.citation.uppercase() == clean ||
            it.citation.uppercase().removePrefix("BG ") == clean.removePrefix("BG ")
        }
    }

    fun getDailyVerse(dayOfYear: Int): GitaVerse {
        val index = (dayOfYear % VERSES.size + VERSES.size) % VERSES.size
        return VERSES[index]
    }

    fun findRelevantVerse(query: String): GitaVerse {
        val lower = query.lowercase().trim()
        return when {
            // Career / Motivation / Action / Work / Laziness / Duty
            lower.contains("motiv") || lower.contains("unmotiv") || lower.contains("lazy") || 
            lower.contains("procrastin") || lower.contains("career") || lower.contains("job") ||
            lower.contains("work") || lower.contains("duties") || lower.contains("कर्म") ||
            lower.contains("आलस") || lower.contains("काम") || lower.contains("नौकरी") ->
                VERSES[10] // 3.19 (Dedicated action) or 0 (2.47)

            // Anxiety / Stress / Worry / Tension / Future
            lower.contains("anxi") || lower.contains("worry") || lower.contains("stress") || 
            lower.contains("future") || lower.contains("nervous") || lower.contains("panic") ||
            lower.contains("चिंता") || lower.contains("तनाव") || lower.contains("घबराहट") ->
                VERSES[0] // 2.47

            // Pain / Sadness / Grief / Suffering / Heartbreak / Breakup
            lower.contains("pain") || lower.contains("sad") || lower.contains("grief") || 
            lower.contains("suffer") || lower.contains("cry") || lower.contains("tear") ||
            lower.contains("breakup") || lower.contains("heartbreak") || lower.contains("दुःख") || 
            lower.contains("दर्द") || lower.contains("उदासी") || lower.contains("रोना") ->
                VERSES[1] // 2.14

            // Death / Loss / Immortality / Soul
            lower.contains("death") || lower.contains("die") || lower.contains("dying") || 
            lower.contains("loss") || lower.contains("soul") || lower.contains("mortal") ||
            lower.contains("मृत्यु") || lower.contains("मौत") || lower.contains("आत्मा") ->
                VERSES[2] // 2.20

            // Anger / Frustration / Rage / Irritation / Temper
            lower.contains("anger") || lower.contains("angry") || lower.contains("furious") || 
            lower.contains("rage") || lower.contains("temper") || lower.contains("frustrat") ||
            lower.contains("irritat") || lower.contains("क्रोध") || lower.contains("गुस्सा") ->
                VERSES[3] // 2.62

            // Peace / Calm / Stillness / Silence
            lower.contains("peace") || lower.contains("calm") || lower.contains("still") || 
            lower.contains("quiet") || lower.contains("tranquil") || lower.contains("शांति") || 
            lower.contains("सुकून") || lower.contains("चैन") ->
                VERSES[4] // 2.70

            // Depression / Low self-esteem / Hopeless / Worthless / Uplift / Confidence
            lower.contains("depress") || lower.contains("hopeless") || lower.contains("down") || 
            lower.contains("worthless") || lower.contains("failure") || lower.contains("fail") ||
            lower.contains("confidence") || lower.contains("उद्धार") || lower.contains("हताश") || 
            lower.contains("निराश") || lower.contains("असफल") ->
                VERSES[5] // 6.5

            // Restless mind / Focus / Concentration / Distraction / Overthinking
            lower.contains("mind") || lower.contains("wander") || lower.contains("focus") || 
            lower.contains("distract") || lower.contains("overthink") || lower.contains("concentrat") ||
            lower.contains("study") || lower.contains("exam") || lower.contains("मन") || 
            lower.contains("चंचल") || lower.contains("भटक") || lower.contains("पढ़ाई") ->
                VERSES[6] // 6.26

            // Meditation / Discipline / Practice / Habit
            lower.contains("meditat") || lower.contains("practice") || lower.contains("restless") || 
            lower.contains("habit") || lower.contains("dhyan") || lower.contains("ध्यान") || 
            lower.contains("अभ्यास") || lower.contains("साधना") ->
                VERSES[7] // 6.35

            // Divine Grace / Faith / God / Krishna / Protection / Lonely
            lower.contains("help") || lower.contains("protect") || lower.contains("carry") || 
            lower.contains("burden") || lower.contains("god") || lower.contains("krishna") ||
            lower.contains("faith") || lower.contains("lonely") || lower.contains("alone") ||
            lower.contains("भगवान") || lower.contains("ईश्वर") || lower.contains("कृपा") || 
            lower.contains("अकेला") || lower.contains("योगक्षेम") ->
                VERSES[8] // 9.22

            // Fear / Guilt / Surrender / Sin / Forgiveness
            lower.contains("fear") || lower.contains("scared") || lower.contains("sin") || 
            lower.contains("guilt") || lower.contains("surrender") || lower.contains("regret") ||
            lower.contains("भय") || lower.contains("डर") || lower.contains("पाप") || 
            lower.contains("शरण") || lower.contains("समर्पण") ->
                VERSES[9] // 18.66

            // Authenticity / Swadharma / Comparison / Calling / Purpose
            lower.contains("purpose") || lower.contains("calling") || lower.contains("compare") || 
            lower.contains("jealous") || lower.contains("dharma") || lower.contains("choice") ||
            lower.contains("confus") || lower.contains("उद्देश्य") || lower.contains("धर्म") || 
            lower.contains("तुलना") || lower.contains("स्वधर्म") ->
                VERSES[11] // 3.35

            // Learning / Knowledge / Wisdom / Truth / Book
            lower.contains("knowledg") || lower.contains("wisdom") || lower.contains("learn") || 
            lower.contains("truth") || lower.contains("ज्ञान") || lower.contains("सत्य") || 
            lower.contains("विद्या") ->
                VERSES[12] // 4.38

            // Relationships / People / Enemy / Friends / Forgive / Love / Toxic
            lower.contains("relat") || lower.contains("friend") || lower.contains("enem") || 
            lower.contains("peopl") || lower.contains("forgiv") || lower.contains("love") ||
            lower.contains("hate") || lower.contains("toxic") || lower.contains("मित्र") || 
            lower.contains("शत्रु") || lower.contains("प्रेम") || lower.contains("सम्बन्ध") || 
            lower.contains("रिश्ते") || lower.contains("क्षमा") ->
                VERSES[13] // 12.13

            else -> {
                // Return a varied verse based on query content so responses are never identically pinned
                val hashIndex = Math.abs(query.hashCode()) % VERSES.size
                VERSES[hashIndex]
            }
        }
    }
}
