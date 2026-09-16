package com.example.data.model

enum class GitaLanguage(
    val code: String,
    val nativeName: String,
    val englishName: String,
    val greeting: String,
    val promptInstruction: String
) {
    ENGLISH(
        code = "en",
        nativeName = "English",
        englishName = "English",
        greeting = "Namaste seeker. Ask your question about life, purpose, or peace, and receive guidance from the Bhagavad Gita.",
        promptInstruction = "English. Provide clear, empathetic explanations and advice in English alongside the original Sanskrit verses."
    ),
    SANSKRIT(
        code = "sa",
        nativeName = "संस्कृतम्",
        englishName = "Sanskrit",
        greeting = "नमस्ते साधक। स्वजीवने संशयान् पृच्छतु, श्रीमद्भगवद्गीतायाः दिव्यज्ञानेन मार्गदर्शनं प्राप्नोतु।",
        promptInstruction = "Sanskrit (संस्कृतम्). Provide devotional and authentic explanations in lucid Sanskrit (सरल संस्कृतम्) along with the original Bhagavad Gita shlokas."
    ),
    HINDI(
        code = "hi",
        nativeName = "हिन्दी",
        englishName = "Hindi",
        greeting = "नमस्ते प्रिय साधक। जीवन, कर्म, चिंता या शांति से जुड़े अपने प्रश्न पूछें, श्रीमद्भगवद्गीता से दिव्य मार्गदर्शन प्राप्त करें।",
        promptInstruction = "Hindi (हिन्दी). Provide warm, conversational, and empathetic guidance in pure, accessible Hindi, explaining the Sanskrit verses deeply."
    ),
    TAMIL(
        code = "ta",
        nativeName = "தமிழ்",
        englishName = "Tamil",
        greeting = "வணக்கம் அன்பரே. வாழ்க்கை, கடமை, மன அமைதி குறித்த உங்கள் கேள்விகளை கேளுங்கள். பகவத் கீதையின் வழிகாட்டுதலைப் பெறுங்கள்.",
        promptInstruction = "Tamil (தமிழ்). Provide empathetic, culturally resonant guidance and verse translations in Tamil."
    ),
    TELUGU(
        code = "te",
        nativeName = "తెలుగు",
        englishName = "Telugu",
        greeting = "నమస్కారం మిత్రమా. జీవితం, ధర్మం, మనశ్శాంతిపై మీ సందేహాలను అడగండి. భగవద్గీత జ్ఞానంతో పరిష్కారం పొందండి.",
        promptInstruction = "Telugu (తెలుగు). Provide thoughtful, compassionate wisdom and verse translations in Telugu."
    ),
    BENGALI(
        code = "bn",
        nativeName = "বাংলা",
        englishName = "Bengali",
        greeting = "নমস্কার বন্ধু। জীবন, কর্ম ও মানসিক শান্তি নিয়ে আপনার জিজ্ঞাসা জানান, শ্রীমদ্ভগবদ্গীতার আলোয় পথ খুঁজুন।",
        promptInstruction = "Bengali (বাংলা). Provide soulful, empathetic guidance and verse translations in Bengali."
    ),
    MARATHI(
        code = "mr",
        nativeName = "मराठी",
        englishName = "Marathi",
        greeting = "नमस्कार साधका. जीवन, कर्तव्य आणि मनःशांतीविषयीचे आपले प्रश्न विचारा, श्रीमद्भगवद्गीतेचे मार्गदर्शन मिळवा.",
        promptInstruction = "Marathi (मराठी). Provide heartfelt, practical wisdom and verse translations in Marathi."
    ),
    GUJARATI(
        code = "gu",
        nativeName = "ગુજરાતી",
        englishName = "Gujarati",
        greeting = "નમસ્તે પ્રિય સાધક. જીવન, કર્મ અને શાંતિ વિશે તમારા પ્રશ્નો પૂછો, ભગવદ્ ગીતામાંથી દિવ્ય માર્ગદર્શન મેળવો.",
        promptInstruction = "Gujarati (ગુજરાતી). Provide empathetic and practical wisdom with verse translations in Gujarati."
    ),
    KANNADA(
        code = "kn",
        nativeName = "ಕನ್ನಡ",
        englishName = "Kannada",
        greeting = "ನಮಸ್ಕಾರ ಸಾಧಕರೇ. ಜೀವನ, ಕರ್ಮ ಮತ್ತು ಮನಃಶಾಂತಿಯ ಕುರಿತು ನಿಮ್ಮ ಪ್ರಶ್ನೆಗಳನ್ನು ಕೇಳಿ, ಭಗವದ್ಗೀತೆಯ ದಿವ್ಯ ಮಾರ್ಗದರ್ಶನ ಪಡೆಯಿರಿ.",
        promptInstruction = "Kannada (ಕನ್ನಡ). Provide warm, insightful guidance and verse translations in Kannada."
    ),
    MALAYALAM(
        code = "ml",
        nativeName = "മലയാളം",
        englishName = "Malayalam",
        greeting = "നമസ്കാരം പ്രിയ സുഹൃത്തേ. ജീവിതം, കർമ്മം, മനശ്ശാന്തി എന്നിവയെക്കുറിച്ചുള്ള സംശയങ്ങൾ ചോദിക്കൂ, ഭഗവദ്ഗീതയുടെ ദിവ്യവെളിച്ചം നേടൂ.",
        promptInstruction = "Malayalam (മലയാളം). Provide gentle, profound wisdom and verse translations in Malayalam."
    ),
    ODIA(
        code = "or",
        nativeName = "ଓଡ଼ିଆ",
        englishName = "Odia",
        greeting = "ନମସ୍କାର ସାଧକ। ଜୀବନ, କର୍ମ ଓ ମାନସିକ ଶାନ୍ତି ବିଷୟରେ ନିଜର ପ୍ରଶ୍ନ ପଚାରନ୍ତୁ, ଶ୍ରୀମଦ୍ଭଗବଦ୍ଗୀତାରୁ ମାର୍ଗଦର୍ଶନ ପାଆନ୍ତୁ।",
        promptInstruction = "Odia (ଓଡ଼ିଆ). Provide compassionate wisdom and verse translations in Odia."
    ),
    PUNJABI(
        code = "pa",
        nativeName = "ਪੰਜਾਬੀ",
        englishName = "Punjabi",
        greeting = "ਸਤਿ ਸ੍ਰੀ ਅਕਾਲ / ਨਮਸਕਾਰ। ਜ਼ਿੰਦਗੀ, ਕਰਮ ਅਤੇ ਮਾਨਸਿਕ ਸ਼ਾਂਤੀ ਬਾਰੇ ਆਪਣੇ ਸਵਾਲ ਪੁੱਛੋ, ਭਗਵਦ ਗੀਤਾ ਦੀ ਸਿੱਖਿਆ ਤੋਂ ਮਾਰਗਦਰਸ਼ਨ ਪਾਓ।",
        promptInstruction = "Punjabi (ਪੰਜਾਬੀ). Provide encouraging, empathetic wisdom and verse translations in Punjabi."
    );

    companion object {
        fun fromCode(code: String): GitaLanguage {
            return entries.firstOrNull { it.code.equals(code, ignoreCase = true) } ?: ENGLISH
        }
    }
}
