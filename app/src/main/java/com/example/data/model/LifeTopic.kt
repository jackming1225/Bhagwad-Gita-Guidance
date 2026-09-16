package com.example.data.model

data class LifeTopic(
    val id: String,
    val title: String,
    val subtitle: String,
    val sampleQuery: String,
    val iconName: String
) {
    companion object {
        val ALL = listOf(
            LifeTopic(
                id = "anxiety",
                title = "Anxiety & Peace",
                subtitle = "Calming an overthinking mind",
                sampleQuery = "I feel constantly anxious about my future and overwhelmed by thoughts. What does the Gita say about finding peace?",
                iconName = "Spa"
            ),
            LifeTopic(
                id = "duty",
                title = "Work & Purpose",
                subtitle = "Focus without burnout or fear of results",
                sampleQuery = "How do I perform my work dedicatedly without being paralyzed by fear of failure and expectations?",
                iconName = "Work"
            ),
            LifeTopic(
                id = "loss",
                title = "Grief & Letting Go",
                subtitle = "Dealing with loss and impermanence",
                sampleQuery = "I am grieving a difficult loss and finding it hard to accept changes in life. How can Gita help me heal?",
                iconName = "FavoriteBorder"
            ),
            LifeTopic(
                id = "anger",
                title = "Anger & Self-Mastery",
                subtitle = "Overcoming anger and restlessness",
                sampleQuery = "I lose my temper easily when things go wrong and regret it. How can I control anger and desires according to Krishna?",
                iconName = "Psychology"
            ),
            LifeTopic(
                id = "courage",
                title = "Courage in Crisis",
                subtitle = "Facing tough decisions like Arjuna",
                sampleQuery = "I feel disheartened, weak, and unmotivated before a huge challenge. How did Krishna inspire Arjuna to rise and fight?",
                iconName = "Shield"
            ),
            LifeTopic(
                id = "attachment",
                title = "Love & Detachment",
                subtitle = "Healthy love vs possessive attachment",
                sampleQuery = "How do I love people deeply without suffering from possessiveness, expectations, and emotional dependency?",
                iconName = "VolunteerActivism"
            ),
            LifeTopic(
                id = "meditation",
                title = "Mind & Meditation",
                subtitle = "Stillness in daily chaos",
                sampleQuery = "My mind wanders like wild wind during meditation and work. How did Krishna advise controlling the restless mind?",
                iconName = "SelfImprovement"
            ),
            LifeTopic(
                id = "surrender",
                title = "Surrender & Faith",
                subtitle = "Letting the Divine carry your burdens",
                sampleQuery = "I feel lonely and exhausted carrying the weight of the world. How does surrendering to God bring freedom and refuge?",
                iconName = "Lightbulb"
            )
        )
    }
}
