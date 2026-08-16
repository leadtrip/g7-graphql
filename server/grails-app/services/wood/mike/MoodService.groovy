package wood.mike

import groovy.transform.CompileStatic

@CompileStatic
class MoodService {

    private static final List<String> MOODS = [
            'Ecstatic',
            'Melancholy',
            'Serene',
            'Anxious',
            'Optimistic',
            'Nostalgic',
            'Irritated',
            'Contemplative',
            'Euphoric',
            'Apathetic',
            'Enthusiastic',
            'Gloomy',
            'Pensive',
            'Restless',
            'Content',
            'Sullen',
            'Vibrant',
            'Listless',
            'Whimsical',
            'Cynical'
    ].asUnmodifiable()

    /**
     * Returns a random mood from the static list of 20 moods.
     */
    String getRandomMood() {
        return MOODS[new Random().nextInt(MOODS.size())]
    }

    /**
     * Returns all 20 static moods.
     */
    List<String> getAllMoods() {
        return MOODS
    }
}