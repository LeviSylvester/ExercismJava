package ex01c_PigLatin;

class PigLatinTranslator {

    String translate(String phrase) {
        StringBuilder translated = new StringBuilder();
        String[] words = phrase.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].substring(0, 1).matches("[AaEeIiOoUu]") ||
                    words[i].substring(0, 2).equalsIgnoreCase("xr") ||
                    words[i].substring(0, 2).equalsIgnoreCase("yt")) {
            } else {
                if (words[i].length() == 2 && words[i].charAt(1) == 'y' ||
                        words[i].substring(0, 1).equalsIgnoreCase("y")) {
                    words[i] = words[i].concat(words[i].substring(0, 1)).substring(1);
                } else {
                    while (words[i].substring(0, 2).equalsIgnoreCase("qu") ||
                            !words[i].substring(0, 1).matches("[AaEeIiOoUuYy]")) {
                        if (words[i].substring(0, 2).equalsIgnoreCase("qu")) {
                            words[i] = words[i].concat("qu").substring(2);
                        } else {
                            words[i] = words[i].concat(words[i].substring(0, 1)).substring(1);
                        }
                    }
                }
            }
            words[i] += "ay";
            if (i == 0) {
                translated.append(words[i]);
            } else {
                translated.append(" ").append(words[i]);
            }
        }
        return translated.toString();
    }

}

//other solutions:

//public class PigLatinTranslator {
//    static final String PATTERN;
//    static {
//        // ?! is zero width negative lookahead
//        String no_yt_or_xr_at_start = "(?!yt|xr)";
//        String qu_or_consonant_at_start = "(qu|[^aeiou ])";
//        String then_qu_or_consonant_except_y = "(qu|[^aeiouy ])*";
//        String consonants
//            = no_yt_or_xr_at_start
//            + qu_or_consonant_at_start
//            + then_qu_or_consonant_except_y;
//        PATTERN = String.format("(?<consonants>%s)?(?<rest>\\w+)", consonants);
//    }
//
//    public static String translate(String input) {
//        return input.replaceAll(PATTERN, "${rest}${consonants}ay");
//    }
//}


//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//class PigLatinTranslator {
//
//    String translate(String inText) {
//        Pattern vowel = Pattern.compile("^([aeiou]|y[^aeiou]|xr)");
//        Pattern consone = Pattern.compile("^([^aeiou]?qu|[^aeiouy]+|y(?=[aeiou]))");
//
//        String res = "";
//
//        for (String word: inText.split(" ")) {
//            if (vowel.matcher(word).find())
//                res += word;
//            else {
//                Matcher z = consone.matcher(word);
//                if (z.find())
//                    res += word.substring(z.end()) + z.group();
//            }
//            res += "ay ";
//        }
//
//        return res.substring(0, res.length() - 1);
//    }
//
//}


//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class PigLatin{
//
//  public static String translate(String input){
//    return Stream.of(input.split(" ")).map(PigLatin::convert).collect(Collectors.joining(" "));
//  }
//
//  public static String convert(String input){
//
//    if(input.toLowerCase().matches("[^aeiou]qu.*")) return input.substring(3, input.length()) + input.substring(0, 3) + "ay";
//
//    if(input.toLowerCase().matches("(sch|thr).*")) return input.substring(3, input.length()) + input.substring(0, 3) + "ay";
//
//    if(input.toLowerCase().matches("(th|qu|ch).*")) return input.substring(2, input.length()) + input.substring(0, 2) + "ay";
//
//    if(input.toLowerCase().matches("([aeiou]|(xr|yt)).*")) return input + "ay";
//
//    return input.substring(1, input.length()) + String.valueOf(input.charAt(0)) + "ay";
//  }
//
//}


//public class PigLatin {
//
//    public static String translate(String input) {
//        return translateComplexLetterCases(translateVowelCases(input));
//    }
//
//    private static String translateVowelCases(String input) {
//        return input.replaceAll("(\\b([euioa]|yt|xr).*\\b)", "$1ay");
//    }
//
//    private static String translateComplexLetterCases(String input) {
//        return input.replaceAll("(?i)\\b(?!yt|xr)(thr?|ch|sch|qu|[a-z&&[^euiao]](?:qu)?)([a-z]*)\\b", "$2$1ay");
//    }
//}


//import java.util.Arrays;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class PigLatinTranslator {
//    private static final Pattern SPLIT_PATTERN =
//        Pattern.compile("^(x(?!r)|y(?!t)|[^aeiouqxy]*(?:qu?)?)(.+)$");
//
//    public String translate(String phrase) {
//        return Arrays.stream(phrase.split(" "))
//                     .map(w -> SPLIT_PATTERN.matcher(w).replaceFirst("$2$1ay"))
//                     .collect(Collectors.joining(" "));
//    }
//}


//import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//class PigLatinTranslator {
//
//    private static final String VOWEL_YT_XR =
//            "^([aeiou]|yt|xr).*$";
//    private static final String THREE_CONSONANTS_3QU =
//            "^([^aeiou]qu|nth|sch|scr|shr|spl|spr|squ|str|thr).*$";
//    private static final String TWO_CONSONANTS =
//            "^(bl|br|ch|ck|cl|cr|dr|fl|fr|gh|gl|gr|ng|ph|pl|pr|qu|rh|sc|sh|sk|sl|sm|sn|sp|st|sw|th|tr|tw|wh|wr).*$";
//    private static final String ONE_CONSONANT =
//            "^[^aeiou].*$";
//    private static final String TWO_LETTERS =
//            "^.y$";
//
//    String translate(String englishPhrase) {
//        return wordsOf(englishPhrase)
//                .map(PigLatinTranslator::translateWord)
//                .collect(Collectors.joining(" "));
//    }
//
//    private static Stream<String> wordsOf(String englishPhrase) {
//        return Arrays.stream(englishPhrase.split(" "));
//    }
//
//    private static String translateWord(String word) {
//        StringBuilder translation = new StringBuilder(word);
//        if (word.matches(VOWEL_YT_XR)) {
//            translation.append("ay");
//        } else if (word.matches(THREE_CONSONANTS_3QU)) {
//            String firstThreeLetters = word.substring(0, 3);
//            translation.delete(0, 3).append(firstThreeLetters).append("ay");
//        } else if (word.matches(TWO_CONSONANTS)) {
//            String firstTwoLetters = word.substring(0, 2);
//            translation.delete(0, 2).append(firstTwoLetters).append("ay");
//        } else if (word.matches(ONE_CONSONANT) || word.matches(TWO_LETTERS)) {
//            char firstConsonant = word.charAt(0);
//            translation.deleteCharAt(0).append(firstConsonant).append("ay");
//        }
//        return translation.toString();
//    }
//}


//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//class PigLatinTranslator {
//    private List<String> vowels = List.of("a", "e", "i", "o", "u", "yt", "xr", "xy");
//    private List<String> consonantClusters = List.of("thr", "sch", "th", "ch", "rh", "qu");
//
//    public String translate(String phrase) {
//        var words = phrase.split(" ");
//        return Stream.of(words)
//            .map(this::toPigLatin)
//            .collect(Collectors.joining(" "));
//    }
//
//    private String toPigLatin(String word) {
//        var sb = new StringBuilder();
//
//        for (var vowel : vowels) {
//            if (word.startsWith(vowel)) {
//                sb.append(word);
//                sb.append("ay");
//                return sb.toString();
//            }
//        }
//
//        for (var consonantCluster : consonantClusters) {
//            if (word.startsWith(consonantCluster)) {
//                sb.append(word.substring(consonantCluster.length()));
//                sb.append(consonantCluster);
//                sb.append("ay");
//                return sb.toString();
//            }
//        }
//
//        if (word.length() > 2 && word.substring(1, 3).equals("qu")) {
//            sb.append(word.substring(3));
//            sb.append(word.charAt(0));
//            sb.append("quay");
//            return sb.toString();
//        }
//
//        sb.append(word.substring(1));
//        sb.append(word.charAt(0));
//        sb.append("ay");
//        return sb.toString();
//    }
//}


//public class PigLatin {
//
//    private static final String VOWEL_REGEX = "(?<begin>^|\\s+)(?<vowel>a|e|i|o|u|yt|xr)(?<rest>\\w+)";
//    private static final String CONSONANT_REGEX = "(?<begin>^|\\s+)(?<consonant>ch|qu|thr|th|sch|yt|\\wqu|\\w)(?<rest>\\w+)";
//
//    private static final String VOWEL_REPLACEMENT = "${begin}${vowel}${rest}ay";
//    private static final String CONSONANT_REPLACEMENT = "${begin}${rest}${consonant}ay";
//
//    public static String translate(String input) {
//        if (input.matches(VOWEL_REGEX)) {
//            return input.replaceAll(VOWEL_REGEX, VOWEL_REPLACEMENT);
//        }
//
//        return input.replaceAll(CONSONANT_REGEX, CONSONANT_REPLACEMENT);
//    }
//}


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Stream;
//
//import static java.util.stream.Collectors.joining;
//
//public final class PigLatin {
//
//    private static final Pattern leadingConsonants = Pattern.compile("([^aeiou]*qu|[^aeiou]*)([aeiou].*)");
//
//    public static String translate(String input) {
//        return Stream.of(input.split("\\p{javaWhitespace}+"))
//                     .map(PigLatin::wordToPigLatin)
//                     .collect(joining(" "));
//    }
//
//    private static String wordToPigLatin(String word) {
//        if (word.matches("^([aeiou]|yt|xr).*"))
//            return word + "ay";
//
//        Matcher matcher = leadingConsonants.matcher(word);
//        if (matcher.matches())
//            return matcher.group(2) + matcher.group(1) + "ay";
//        else
//            return word + "ay";
//    }
//}


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class PigLatinTranslator {
//
//     String translate(String input){
//
//        Pattern vowel = Pattern.compile("^(?:[aeiou]|xr|yt)");
//        Pattern consone = Pattern.compile("^([^aeiou]*qu|[^aeiouy]+|y(?=[aeiou]))");
//
//
//        StringBuilder res = new StringBuilder();
//        for (String word:input.split("\\s")){
//            if (vowel.matcher(word).find()){
//                res.append(word).append("ay");
//            }else {
//                Matcher mt = consone.matcher(word);
//                while (mt.find()){
//                    res.append(word.substring(mt.end()) + mt.group()).append("ay").append(" ");
//                }
//            }
//        }
//         return res.toString().trim();
//    }
//}


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class PigLatin {
//    private static final Pattern VOWELISH = Pattern.compile("^([aeiou]|yt|xr)");
//    private static final Pattern CONSONANTISH = Pattern.compile("^(ch|qu|thr?|sch|[a-z](qu)?)");
//
//    public static String translate(String input) {
//        return Pattern.compile(" ").splitAsStream(input)
//                .map(PigLatin::translateWord)
//                .collect(Collectors.joining(" "));
//    }
//
//    private static String translateWord(String word) {
//        return rotateLetters(word, numberOfLettersToMove(word)) + "ay";
//    }
//
//    private static int numberOfLettersToMove(String word) {
//        if (VOWELISH.matcher(word).find())
//            return 0;
//        else
//            return Stream.of(CONSONANTISH)
//                    .map(pattern -> pattern.matcher(word))
//                    .filter(Matcher::find)
//                    .mapToInt(Matcher::end)
//                    .findFirst()
//                    .orElse(0);
//    }
//
//    private static String rotateLetters(String word, int num) {
//        return word.substring(num) + word.substring(0, num);
//    }
//}


//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//public class PigLatin {
//
//	private static final String VOWELS = "[aeiou].*|yt.*|xr.*";
//	private static final String DOUBLE_CONSONANTS = "ch.*|qu.*|th.*";
//	private static final String TRIPLE_CONSONANTS = ".qu.*|thr.*|sch.*";
//
//	public static String translate(String input) {
//		return Arrays.stream(input.split(" ")).map(s -> translateWord(s))
//				.collect(Collectors.joining(" "));
//	}
//
//	private static String translateWord(String word) {
//		if (word.matches(VOWELS)) return word + "ay";
//		if (word.matches(TRIPLE_CONSONANTS)) return word.substring(3) + word.substring(0,3) + "ay";
//		if (word.matches(DOUBLE_CONSONANTS)) return word.substring(2) + word.substring(0,2) + "ay";
//		return word.substring(1) + word.charAt(0) + "ay";
//	}
//}


//public class PigLatin
//{
//    public static String translateMainMethod(String input)
//    {
//        String result = "";
//        if (input.substring(0,1).matches("\\b[auioe]"))
//        {
//            result = input + "ay";
//        }
//        else
//        {
//            result = input.substring(1) + input.charAt(0) + "ay";
//
//            // exceptions
//            String exceptionTest = input.length() > 1 ?  input.substring(0,2) : ""; // to prevent string length problem
//            if (exceptionTest.equals("ch") || exceptionTest.equals("qu") || exceptionTest.equals("th") || exceptionTest.equals("xr"))
//            {
//                result = input.substring(2) + exceptionTest + "ay";
//            }
//            if (exceptionTest.equals("yt") || exceptionTest.equals("xr"))
//            {
//                result = input + "ay";
//            }
//            exceptionTest = input.length() > 2 ?  input.substring(0,3) : ""; // to prevent string length problem
//            if (exceptionTest.equals("sch") || exceptionTest.equals("thr") || exceptionTest.matches("\\b[^auioe]qu"))
//            {
//                result = input.substring(3) + exceptionTest + "ay";
//            }
//        }
//        return result;
//    }
//    public static String translate(String input)
//    {
//        String result = "";
//        for (String word : input.toLowerCase().split(" "))
//        {
//            result += translateMainMethod(word) + " ";
//        }
//        return result.trim();
//    }
//}


//import java.util.Arrays;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class PigLatin {
//
//	private static final String NOT_VOVELS_REGEX = "[^aeiou]";
//
//	private static final String SPECIAL_QU = "qu";
//	private static final Set<String> THREE_CONSONANTS_SPECIAL = Stream.of("thr", "sch").collect(Collectors.toSet());
//	private static final Set<String> TWO_CONSONANTS_SPECIAL = Stream.of("ch", SPECIAL_QU, "th").collect(Collectors.toSet());
//	private static final Set<String> TWO_VOWELS_SPECIAL = Stream.of("yt", "xr").collect(Collectors.toSet());
//
//	private static final String TERMINATOR = "ay";
//
//	public static String translate(final String input) {
//		final String[] words = input.split("[\\s]");
//
//		return Arrays.stream(words)
//			.map(word -> {
//				if (THREE_CONSONANTS_SPECIAL.stream().anyMatch(special3 -> word.startsWith(special3)) ||
//						word.substring(0, 1).matches(NOT_VOVELS_REGEX) && word.substring(1, 3).equals(SPECIAL_QU)) {
//					return buildSplittedWord(word, 3);
//				} else if (TWO_CONSONANTS_SPECIAL.stream().anyMatch(special2c -> word.startsWith(special2c))) {
//					return buildSplittedWord(word, 2);
//				} else if (TWO_VOWELS_SPECIAL.stream().anyMatch(special2v -> word.startsWith(special2v))) {
//					return word + TERMINATOR;
//				} else if (word.substring(0, 1).matches(NOT_VOVELS_REGEX)) {
//					return buildSplittedWord(word, 1);
//				} else {
//					return word + TERMINATOR;
//				}
//			})
//			.collect(Collectors.joining(" "));
//	}
//
//	private static String buildSplittedWord(final String word, final int splitAt) {
//		return word.substring(splitAt, word.length()) + word.substring(0, splitAt) + TERMINATOR;
//	}
//}


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//class PigLatinTranslator {
//
//    String translate(String phrase) {
//        Pattern vowel = Pattern.compile("^([aeiou]|yt|xr)");
//        Pattern consonant = Pattern.compile("y(?=[aeiou])|[^aeiou]?qu|[^aeiouy]+");
//
//        StringBuilder result = new StringBuilder();
//
//        for (String word : phrase.split("\\s")) {
//            if (vowel.matcher(word).find()) {
//                result.append(word);
//            } else {
//                Matcher matcher = consonant.matcher(word);
//                if (matcher.find()) {
//                    result.append(word.substring(matcher.end())).append(matcher.group());
//                }
//            }
//
//            result.append("ay").append(" ");
//        }
//
//        result.setLength(result.length() - 1);
//
//        return result.toString();
//    }
//}


//import java.util.Arrays;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class PigLatinTranslator {
//
// private static final Pattern VOWELS_PATTERN = Pattern.compile("((?<!q)[aeiou])|([xy](?![aeiou]))");
//
// public static String translate(String phrase) {
//    return Arrays
//      .stream(phrase.trim().toLowerCase().split(" "))
//      .map(PigLatinTranslator::translateWord)
//      .collect(Collectors.joining(" "));
//  }
//
//  private static String translateWord(String word) {
//    Matcher matcher = VOWELS_PATTERN.matcher(word);
//    int vowelIndex = matcher.find() ? matcher.start() : 0;
//    return word.substring(vowelIndex) + word.substring(0, vowelIndex) + "ay";
//  }
//}


//public class PigLatinTranslator{
//  public PigLatinTranslator(){
//
//  }
//  public String translate(String phrase){
//    StringBuilder joiner = new StringBuilder();
//    for (String word : phrase.split(" ")) {
//      int i = 0;
//      while (word.charAt(i) != 'a' &&
//      word.charAt(i) != 'e' &&
//      word.charAt(i) != 'i' &&
//      word.charAt(i) != 'o' &&
//      word.charAt(i) != 'u') {
//        i++;
//      }
//      if (i > 0 && word.charAt(i - 1) == 'q' && word.charAt(i) == 'u') i++;
//      if (word.startsWith("yt") || word.startsWith("xr")) i = 0;
//
//      joiner.append(word.substring(i) + word.substring(0, i) + "ay");
//    }
//
//    return joiner.toString();
//  }
//
//
//}


//public class PigLatinTranslator {
//    private StringBuilder pigLatinPhrase;
//
//    public String translate(String englishPhrase) {
//        pigLatinPhrase = new StringBuilder();
//        String[] englishSentence = englishPhrase.split(" ");
//
//        for(int i = 0; i < englishSentence.length; i++){
//            translateWord(englishSentence[i]);
//
//            if(i != englishSentence.length-1)
//                pigLatinPhrase.append(" ");
//        }
//
//        return pigLatinPhrase.toString();
//    }
//
//    private void translateWord(String word){
//        if(isaVowelSound(word)){
//            pigLatinPhrase.append(word+"ay");
//
//        }else if(isaThreeLetterSound(word)){
//            char firstLetter = word.charAt(0);
//            char secondLetter = word.charAt(1);
//            char thirdLetter = word.charAt(2);
//            pigLatinPhrase.append(word.substring(3).concat(String.valueOf(firstLetter) + String.valueOf(secondLetter)
//                    + String.valueOf(thirdLetter) + "ay"));
//        }
//        else if(isaTwoLetterSound(word)){
//            char firstLetter = word.charAt(0);
//            char secondLetter = word.charAt(1);
//            pigLatinPhrase.append(word.substring(2).concat(String.valueOf(firstLetter) + String.valueOf(secondLetter) + "ay"));
//        }
//        else{
//            char firstLetter = word.charAt(0);
//            pigLatinPhrase.append(word.substring(1).concat(String.valueOf(firstLetter) + "ay"));
//        }
//    }
//
//    private boolean isaTwoLetterSound(String word) {
//        return word.charAt(0) == 'c' && word.charAt(1) == 'h' ||
//                word.charAt(0) == 'q' && word.charAt(1) == 'u' ||
//                word.charAt(0) == 't' && word.charAt(1) == 'h' ||
//                word.charAt(0) == 's' && word.charAt(1) == 'c' ||
//                word.charAt(0) == 'y' && word.charAt(1) == 't' ||
//                word.charAt(0) == 'x' && word.charAt(1) == 'r' ||
//                word.charAt(0) == 'c' && word.charAt(1) == 'h';
//    }
//
//    private boolean isaThreeLetterSound(String word) {
//        return word.charAt(0) == 's' && word.charAt(1) == 'q' && word.charAt(2) == 'u' ||
//                word.charAt(0) == 't' && word.charAt(1) == 'h' && word.charAt(2) == 'r' ||
//                word.charAt(0) == 's' && word.charAt(1) == 'c' && word.charAt(2) == 'h' ||
//                word.charAt(0) == 'y' && word.charAt(1) == 't' && word.charAt(2) == 't';
//    }
//
//    private boolean isaVowelSound(String word) {
//        return word.charAt(0)=='a' || word.charAt(0)=='e' ||
//                word.charAt(0)=='i' || word.charAt(0)=='o' ||
//                        word.charAt(0)=='u' || (word.charAt(0)=='x' &&
//                            (word.charAt(1)!='e')) || (word.charAt(0)=='y'
//                                && word.charAt(1)!='e');
//    }
//}


//import java.util.Arrays;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class PigLatinTranslator {
//    public String translate(String str) {
//        return Arrays.stream(str.split(" "))
//            .map(it -> new Rules(new Rule1(it), new Rule2QU(it), new Rule2(it), new Rule3(it), new Rule4(it)).change())
//            .collect(Collectors.joining(" "));
//    }
//}
//
//class Rules{
//    private final List<Rule> rules;
//
//    public Rules(Rule... rules){
//        this.rules = Arrays.asList(rules);
//    }
//
//    public String change(){
//        for(Rule r : rules){
//            if(r.matches()){
//                return r.change();
//            }
//        }
//
//        throw new UnsupportedOperationException();
//    }
//}
//
//interface Rule{
//    String change();
//    boolean matches();
//}
//
//
//class Rule1 implements Rule{
//    private final String word;
//    private static final Pattern PATTERN = Pattern.compile("^(?i)([aeiou]|xr|yt).*$");
//
//    public Rule1(String word) {
//        this.word = word;
//    }
//
//    @Override
//    public boolean matches() {
//        return PATTERN.matcher(word).matches();
//    }
//
//    @Override
//    public String change() {
//        return word + "ay";
//    }
//}
//
//class Rule2QU implements Rule{
//    private final String word;
//    private static final Pattern PATTERN = Pattern.compile("^(?i)(qu|[^aeiouy]+qu)(.*)$");
//
//    public Rule2QU(String word) {
//        this.word = word;
//    }
//
//    @Override
//    public boolean matches() {
//        return PATTERN.matcher(word).matches();
//    }
//
//    @Override
//    public String change() {
//        Matcher m = PATTERN.matcher(word);
//
//        return m.find() ? m.group(2) + m.group(1) + "ay" : word;
//    }
//}
//
//class Rule2 implements Rule{
//    private final String word;
//    private final Pattern PATTERN = Pattern.compile("^(?i)([^aeiouy]+|y)([aeiouy].*)$");
//
//    public Rule2(String word) {
//        this.word = word;
//    }
//
//    @Override
//    public boolean matches() {
//        return PATTERN.matcher(word).matches();
//    }
//
//    @Override
//    public String change() {
//        Matcher m = PATTERN.matcher(word);
//
//        return m.find() ? m.group(2) + m.group(1) + "ay" : word;
//    }
//}
//
//class Rule3 implements Rule{
//    private final String word;
//    private final Pattern PATTERN = Pattern.compile("^(?i)([^aeiouy]+(qu)+|y)([aeiouy].*)$");
//
//    public Rule3(String word) {
//        this.word = word;
//    }
//
//    @Override
//    public boolean matches() {
//        return PATTERN.matcher(word).matches();
//    }
//
//    @Override
//    public String change() {
//        Matcher m = PATTERN.matcher(word);
//
//        return m.find() ? m.group(3) + m.group(1) + "ay" : word;
//    }
//}
//
//class Rule4 implements Rule{
//    // in Rule2
//    private final String word;
//
//    public Rule4(String word) {
//        this.word = word;
//    }
//
//    @Override
//    public boolean matches() {
//        return false;
//    }
//
//    @Override
//    public String change() {
//        return word;
//    }
//}


//class PigLatinTranslator {
//
//	public PigLatinTranslator() {}
//
//	public String translate(String word) {
//
//		if (word.split(" ").length > 1) {
//			String out = "";
//			for (String s : word.split(" "))
//				out += translate(s) + " ";
//
//			return out.trim();
//		}
//
//		if (word.matches("^(ch|qu|the|rh).*")
//			return word.substring(2)+word.substring(0,2)+"ay";
//
//		if (word.matches("^(sch|squ|thr).*"))
//			return word.substring(3)+word.substring(0,3)+"ay";
//
//		if ("aeiou".contains(String.valueOf(word.charAt(0))) ||
//				word.matches("^(x|y)(?!e).*"))
//			return word+"ay";
//
//		return word.substring(1)+word.charAt(0)+"ay";
//	}
//
//}


//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class PigLatinTranslator {
//
//    private static final String PIG_LATIN_SUFFIX = "ay";
//    private static final Pattern LEADING_CONSONANTS_PATTERN = Pattern.compile("([^yaeiou]*qu|[^yaeiou]*)([yaeiou]*.*)");
//    private static final String LEADING_VOWELS_REGEX = "^([aeiou]|yt|xr).*";
//
//    public String translate(String input) {
//        return Stream.of(input.split(" "))
//                .map(this::wordToPigLatin)
//                .collect(Collectors.joining(" "));
//    }
//
//    private String wordToPigLatin(String word) {
//        if (word.matches(LEADING_VOWELS_REGEX)) {
//            return word + PIG_LATIN_SUFFIX;
//        }
//
//        if (word.charAt(0) == 'y') { // Treat 'y' like a consonant at the beginning of a word
//            return word.substring(1) + "y" + PIG_LATIN_SUFFIX;
//        }
//
//        var matcher = LEADING_CONSONANTS_PATTERN.matcher(word);
//        if (matcher.matches()) {
//            return matcher.group(2) + matcher.group(1) + PIG_LATIN_SUFFIX;
//        }
//
//        return word + PIG_LATIN_SUFFIX;
//    }
//}