package ex01b_Isogram;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        String onlyLetters = phrase.replaceAll("\\W", "").toLowerCase();
        String uniqueLetters = onlyLetters.replaceAll("(.)(?=.*\\1)", "");
        return onlyLetters.length() == uniqueLetters.length();
    }

}





//other solutions:

//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//class IsogramChecker {
//
//    boolean isIsogram(String phrase) {
//        Set phraseSet = new HashSet();
//        char[] phraseArr = phrase.replaceAll("\\W", "").toLowerCase().toCharArray();
//        for (char c : phraseArr) {
//            phraseSet.add(c);
//        }
//        return phraseSet.size() == phraseArr.length;
//    }
//
//}


//class IsogramChecker {
//
//    boolean isIsogram(String phrase) {
//        phrase = phrase.replace("-", "").replace(" ", "").toLowerCase();
//
//        return (phrase.chars().distinct().count() == phrase.length());
//    }
//}


//public class IsogramChecker {
//    public boolean isIsogram(String word) {
//        String noSpacesOrHyphens = word.replaceAll("(?:\\s|-)", "").toLowerCase();
//        return noSpacesOrHyphens.chars().distinct().count() == noSpacesOrHyphens.length();
//    }
//}


//public class IsogramChecker {
//
//    public boolean isIsogram(String input) {
//        return
//            input.toLowerCase().chars()
//                .filter(c -> Character.isLetter(c))
//                .distinct()
//                .count() ==
//            input.toLowerCase().chars()
//                .filter(c -> Character.isLetter(c))
//                .count();
//    }
//}


//import java.util.HashSet;
//import java.util.Set;
//
//class IsogramChecker {
//
//  public boolean isIsogram(String input) {
//    Set<Integer> set = new HashSet<>();
//
//    input = input.replaceAll(" ", "");
//    input = input.replaceAll("-", "");
//    input = input.toUpperCase();
//
//    input.chars()
//      .forEach(set::add);
//
//    return set.size() == input.length();
//  }
//}


//import java.util.HashSet;
//import java.util.Set;
//
//public class IsogramChecker {
//    public boolean isIsogram(String phrase) {
//        Set<Integer> codePoints = new HashSet<>();
//        return phrase.codePoints()
//                     .filter(Character::isAlphabetic)
//                     .map(Character::toLowerCase)
//                     .allMatch(codePoints::add);
//    }
//}


//import java.util.stream.Collectors;
//
//class IsogramChecker {
//
//    boolean isIsogram(String phrase) {
//        String purePhrase = phrase.toUpperCase().replaceAll("[^A-Z]", "");
//        return purePhrase.chars().distinct().count() == purePhrase.length();
//    }
//}


//    public class IsogramChecker {
//        public boolean isIsogram(String word) {
//            word = word.toLowerCase().replaceAll("[ \\-]", "");
//            return word.length() == word.chars().distinct().count();
//        }
//    }


//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//class IsogramChecker {
//
//  boolean isIsogram(String phrase) {
//    List<Integer> pureChars = phrase.toLowerCase().chars()
//            .filter(Character::isAlphabetic)
//            .boxed()
//            .collect(Collectors.toList());
//    Set<Integer> uniques = new HashSet<>(pureChars);
//    return uniques.size() == pureChars.size();
//  }
//
//}


//import java.util.stream.Collectors;
//
//public class IsogramChecker {
//    public boolean isIsogram(String duplicates) {
//        return duplicates.chars().mapToObj(i -> (char) i)
//                .filter(Character::isLetter)
//                .map(Character::toUpperCase)
//                .collect(Collectors.toMap(ch -> ch, ch -> 1, (i1, i2) -> i1 + i2))
//                .values().stream().noneMatch(i -> i > 1);
//    }
//}


//import java.util.concurrent.atomic.AtomicInteger;
//
//class IsogramChecker {
//
//    boolean isIsogram(String phrase) {
//        AtomicInteger numCharacters = new AtomicInteger(0);
//        return phrase.toLowerCase().chars()
//                .filter(c -> c != ' ' && c != '-')
//                .peek(c -> numCharacters.incrementAndGet())
//                .distinct()
//                .count() == numCharacters.get();
//    }
//
//}


//class IsogramChecker {
//
//    boolean isIsogram(String phrase) {
//        String test = phrase.toLowerCase();
//        for (char c: test.toCharArray()) {
//            if (Character.isLetter(c) && test.indexOf(c) != test.lastIndexOf(c))
//                    return false;
//        }
//        return true;
//    }


//import java.util.Arrays;
//
//class IsogramChecker {
//
//    boolean isIsogram(String phrase) {
//
//        String lowercase_phrase = phrase.toLowerCase().replace(" ", "").replace("-","");
//        char[] letters = lowercase_phrase.toCharArray();
//
//        Arrays.sort(letters);
//        for (int i = 0; i < letters.length - 1 ; i++)
//        {
//            if (letters[i] == letters[i + 1])
//            {
//                return false;
//            }
//        }
//        if (phrase.equals(""))
//        {
//            return true;
//        }
//
//        return true;
//    }
//}

