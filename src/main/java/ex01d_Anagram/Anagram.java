package ex01d_Anagram;

import java.util.ArrayList;
import java.util.List;

class Anagram {
    private String word;

    Anagram(String word) {
        this.word = word;
    }

    List<String> match(List<String> words) {
        List<String> anagrams = new ArrayList<>();
        for (String word : words) {
            if (isAnagram(this.word, word)) {
                anagrams.add(word);
            }
        }
        return anagrams;
    }

    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        if (word1.equalsIgnoreCase(word2)) return false;
        int[] palette1 = new int[26], palette2 = new int[26];
        word1 = word1.toUpperCase();
        word2 = word2.toUpperCase();
        for (int i = 0; i < word1.length(); i++) {
            palette1[word1.charAt(i) - 'A']++;
            palette2[word2.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 26; i++)
            if (palette1[i] != palette2[i]) return false;
        return true;
    }

//other solutions:
//-with map
}

