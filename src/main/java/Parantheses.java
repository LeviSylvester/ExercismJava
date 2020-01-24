package ex05__ScrabbleScore;

import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private static final Map<Character, Integer> CHARACTER_VALUES = new HashMap<>();

    static {
        putEachLetterOnMapWithItsValue("AEIOULNRST", 1);
        putEachLetterOnMapWithItsValue("DG", 2);
        putEachLetterOnMapWithItsValue("BCMP", 3);
        putEachLetterOnMapWithItsValue("FHVWY", 4);
        putEachLetterOnMapWithItsValue("K", 5);
        putEachLetterOnMapWithItsValue("JX", 8);
        putEachLetterOnMapWithItsValue("QZ", 10);
    }

    private int score;

    Scrabble(String word) {
        this.score = word.toUpperCase().chars().map(letter -> CHARACTER_VALUES.get((char) letter)).sum();
    }

    int getScore() {
        return this.score;
    }

    private static void putEachLetterOnMapWithItsValue(String letters, int value) {
        letters.chars().forEach(letter -> CHARACTER_VALUES.put((char) letter, value));
    }

}


//other solutions:


//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//class Scrabble {
//
//    private static final Map<Character, Integer> CHARACTER_VALUES = new HashMap<>();
//
//    static {
//        putEachLetterOnMapWithItsValue("AEIOULNRST", 1);
//        putEachLetterOnMapWithItsValue("DG", 2);
//        putEachLetterOnMapWithItsValue("BCMP", 3);
//        putEachLetterOnMapWithItsValue("FHVWY", 4);
//        putEachLetterOnMapWithItsValue("K", 5);
//        putEachLetterOnMapWithItsValue("JX", 8);
//        putEachLetterOnMapWithItsValue("QZ", 10);
//    }
//
//    private int score;
//
//    Scrabble(String word) {
//        this.score = IntStream.range(0, word.length()).boxed()
//                .collect(Collectors.summingInt(i -> CHARACTER_VALUES.get(word.toUpperCase().charAt(i))));
//    }
//
//    int getScore() {
//        return this.score;
//    }
//
//    private static void putEachLetterOnMapWithItsValue(String letters, int value) {
//        letters.chars().forEach(letter -> CHARACTER_VALUES.put((char) letter, value));
//    }
//
//}


//import java.util.HashMap;
//import java.util.Map;
//
//class Scrabble {
//
//    private static final Map<Character, Integer> CHARACTER_VALUES = new HashMap<>();
//
//    static {
//        putEachLetterOnMapWithItsValue("AEIOULNRST", 1);
//        putEachLetterOnMapWithItsValue("DG", 2);
//        putEachLetterOnMapWithItsValue("BCMP", 3);
//        putEachLetterOnMapWithItsValue("FHVWY", 4);
//        putEachLetterOnMapWithItsValue("K", 5);
//        putEachLetterOnMapWithItsValue("JX", 8);
//        putEachLetterOnMapWithItsValue("QZ", 10);
//    }
//
//    private int score;
//
//    Scrabble(String word) {
//        word = word.toUpperCase();
//        int wordLength = word.length();
//        for (int charIndex = 0; charIndex < wordLength; charIndex++) {
//            this.score += CHARACTER_VALUES.get(word.charAt(charIndex));
//        }
//    }
//
//    int getScore() {
//        return this.score;
//    }
//
//    private static void putEachLetterOnMapWithItsValue(String letters, int value) {
//        letters.chars().forEach(letter -> CHARACTER_VALUES.put((char) letter, value));
//    }
//
//}


//import java.util.HashMap;
//import java.util.Map;
//
//class Scrabble {
//
//    private static final Character[] CHARACTERS = {
//            'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T',
//            'D', 'G',
//            'B', 'C', 'M', 'P',
//            'F', 'H', 'V', 'W', 'Y',
//            'K',
//            'J', 'X',
//            'Q', 'Z'
//    };
//
//    private static final Integer[] VALUES = {
//            1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
//            2, 2,
//            3, 3, 3, 3,
//            4, 4, 4, 4, 4,
//            5,
//            8, 8,
//            10, 10
//    };
//
//    private static final Map<Character, Integer> CHARACTER_VALUES = new HashMap<>();
//
//    static {
//        for (int i = 0; i < 26; i++) {
//            CHARACTER_VALUES.put(CHARACTERS[i], VALUES[i]);
//        }
//    }
//
//    private int score;
//
//    Scrabble(String word) {
//        word = word.toUpperCase();
//        int wordLength = word.length();
//        for (int charIndex = 0; charIndex < wordLength; charIndex++) {
//            this.score += CHARACTER_VALUES.get(word.charAt(charIndex));
//        }
//    }
//
//    int getScore() {
//        return this.score;
//    }
//
//}


//class Scrabble {
//
//    private int score;
//
//    private int valueOf(String I) {
//        int value = 0;
//        if (I.matches("[AEIOULNRST]")) value = 1;
//        else if (I.matches("[DG]")) value = 2;
//        else if (I.matches("[BCMP]")) value = 3;
//        else if (I.matches("[FHVWY]")) value = 4;
//        else if (I.matches("[K]")) value = 5;
//        else if (I.matches("[JX]")) value = 8;
//        else if (I.matches("[QZ]")) value = 10;
//        return value;
//    }
//
//    Scrabble(String word) {
//        final String WORD = word.toUpperCase();
//        final int LENGTH = WORD.length();
//        for (int I = 0; I < LENGTH; I++) {
//            this.score += valueOf(WORD.substring(I, I + 1));
//        }
//    }
//
//    int getScore() {
//        return this.score;
//    }
//
//}


//class Scrabble {
//
//    private int score;
//
//    private int valueOf(String I) {
//        int value = 0;
//        if (I.matches("[AEIOULNRST]")) value = 1;
//        if (I.matches("[DG]")) value = 2;
//        if (I.matches("[BCMP]")) value = 3;
//        if (I.matches("[FHVWY]")) value = 4;
//        if (I.matches("[K]")) value = 5;
//        if (I.matches("[JX]")) value = 8;
//        if (I.matches("[QZ]")) value = 10;
//        return value;
//    }
//
//    Scrabble(String word) {
//        final String WORD = word.toUpperCase();
//        final int LENGTH = WORD.length();
//        for (int I = 0; I < LENGTH; I++) {
//            this.score += valueOf(WORD.substring(I, I + 1));
//        }
//    }
//
//    int getScore() {
//        return this.score;
//    }
//
//}


//class Scrabble {
//
//    private int score;
//
//    private int valueOf(char character) {
//        int value = 0;
//        String c = Character.toString(character);
//        if (c.matches("[AEIOULNRST]")) value = 1;
//        if (c.matches("[DG]")) value = 2;
//        if (c.matches("[BCMP]")) value = 3;
//        if (c.matches("[FHVWY]")) value = 4;
//        if (c.matches("[K]")) value = 5;
//        if (c.matches("[JX]")) value = 8;
//        if (c.matches("[QZ]")) value = 10;
//        return value;
//    }
//
//    Scrabble(String word) {
//        char[] wordChars = word.toUpperCase().toCharArray();
//        for (char c : wordChars) {
//            this.score += valueOf(c);
//        }
//    }
//
//    int getScore() {
//        return this.score;
//    }
//
//}