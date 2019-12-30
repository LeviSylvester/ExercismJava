package ex02d_TwelveDays;

class TwelveDays {

    private String[] days = {"first", "second", "third", "fourth", "fifth", "sixth",
            "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
    private String[] presents = {"a Partridge in a Pear Tree.\n", "two Turtle Doves, and ", "three French Hens, ",
            "four Calling Birds, ", "five Gold Rings, ", "six Geese-a-Laying, ",
            "seven Swans-a-Swimming, ", "eight Maids-a-Milking, ", "nine Ladies Dancing, ",
            "ten Lords-a-Leaping, ", "eleven Pipers Piping, ", "twelve Drummers Drumming, "};

    String verse(int verseNumber) {
        String day = days[verseNumber - 1];
        StringBuilder present = new StringBuilder();
        for (int i = verseNumber - 1; i >= 0; i--) present.append(presents[i]);
        return String.format("On the %s day of Christmas my true love gave to me: %s", day, present.toString());
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder verses = new StringBuilder();
        for (int verseNumber = startVerse; verseNumber <= endVerse; verseNumber++) {
            verses.append(verse(verseNumber));
        }
        return verses.toString();
    }

    String sing() {
        return verses(1, 12);
    }

}