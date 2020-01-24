import java.util.*;
import java.util.stream.Collectors;

/*You are given a List of random paranthesis characters (curly, square and round)
and any characters in between.
Verify if all parantheses are closed (and no more closing brackets than needed, meaning
make sure you aren't opening any paranthesis with a closing bracket.*/

class Parantheses {

    private static final Map<Character, Integer> BRACKETS_VALUES = new HashMap<>();

    static {
        putEachBracketOnMapWithItsValue("{[(", -1);
        putEachBracketOnMapWithItsValue("}])", 1);
    }

    private static int sumOfCurlyBrackets;

    private static int sumOfSquareBrackets;
    private static int sumOfRoundBrackets;
    private static boolean tryingToOpenParanthesisWithClosingBracket;

    public Parantheses(List<Character> parantheses) {
        calculateSumOfBracketValuesByParanthesisType(parantheses);
    }

    public String areAllParanthesesClosed() {
        return tryingToOpenParanthesisWithClosingBracket ?
                "trying to open paranthesis with closing bracket"
                :
                Boolean.toString(sumOfCurlyBrackets == 0 && sumOfSquareBrackets == 0 && sumOfRoundBrackets == 0);
    }

    private static void calculateSumOfBracketValuesByParanthesisType(List<Character> parantheses) {
        for (Character bracket : parantheses) {
            if (!tryingToOpenParanthesisWithClosingBracket) {
                if (isCharacterOneOfTheseBrackets(bracket, '{', '}')) {
                    sumOfCurlyBrackets += BRACKETS_VALUES.get(bracket);
                    stopCheckingIfPositive(sumOfCurlyBrackets);
                } else if (isCharacterOneOfTheseBrackets(bracket, '[', ']')) {
                    sumOfSquareBrackets += BRACKETS_VALUES.get(bracket);
                    stopCheckingIfPositive(sumOfSquareBrackets);
                } else if (isCharacterOneOfTheseBrackets(bracket, '(', ')')) {
                    sumOfRoundBrackets += BRACKETS_VALUES.get(bracket);
                    stopCheckingIfPositive(sumOfRoundBrackets);
                }
            }
        }
    }

    private static boolean isCharacterOneOfTheseBrackets(Character character,
                                                         Character openingBracket,
                                                         Character closingBracket) {
        return character.equals(openingBracket) || character.equals(closingBracket);
    }

    private static void stopCheckingIfPositive(int sumOfBracketPairs) {
        if (sumOfBracketPairs > 0) {
            tryingToOpenParanthesisWithClosingBracket = true;
        }
    }

    private static void putEachBracketOnMapWithItsValue(String brackets, int value) {
        brackets.chars().forEach(bracket -> BRACKETS_VALUES.put((char) bracket, value));
    }

    public static void main(String[] args) {
        System.out.println(
                new Parantheses(
//                        "" // true
//                        " " // true
//                        "a" // true
//                        "A" // true
//                        "aBc" // true
//                        "(" // false
//                        "{[()]}" // true
//                        "A{[()]}" // true
//                        "{[(aBc)d]e}" // true
//                        "[{(((())))]}" // true
//                        "[{(" // false
//                        "]" // trying to open paranthesis with closing bracket
//                        "}])[]}()" // trying to open paranthesis with closing bracket
//                        "()[]{}{}}" // trying to open paranthesis with closing bracket
                        "()))]]}}" // trying to open paranthesis with closing bracket
                                .chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.toList())
                )
                        .areAllParanthesesClosed()
        );
    }
}

//toDo: verify if parantheses ara closed in inverse order
//toDo: tell if no bracket present

//other solutions:

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///*You are given a List of random paranthesis characters (curly, square and round)
//and any characters in between.
//Verify if all parantheses are closed (and no more closing brackets than needed, meaning
//make sure you aren't opening any paranthesis with a closing bracket.*/
//
//class Parantheses {
//
//    private static final Map<Character, Integer> BRACKETS_VALUES = new HashMap<>() {{
//        put('{', -1);
//        put('}', 1);
//        put('[', -1);
//        put(']', 1);
//        put('(', -1);
//        put(')', 1);
//    }};
//
//    private static int sumOfCurlyBrackets;
//    private static int sumOfSquareBrackets;
//    private static int sumOfRoundBrackets;
//
//    public Parantheses(List<Character> parantheses) throws IllegalClosingBracketException {
//        calculateSumOfBracketValuesByParanthesisType(parantheses);
//    }
//
//    public boolean areAllParanthesesClosed() {
//        return sumOfCurlyBrackets == 0 && sumOfSquareBrackets == 0 && sumOfRoundBrackets == 0;
//    }
//
//    private static void calculateSumOfBracketValuesByParanthesisType(List<Character> parantheses)
//            throws IllegalClosingBracketException {
//        for (Character bracket : parantheses) {
//            if (isThisTypeOfParanthesis(bracket, '{', '}')) {
//                addBracketValueAndThrowExceptionIfSumIsPositive(sumOfCurlyBrackets, bracket);
//            } else if (isThisTypeOfParanthesis(bracket, '[', ']')) {
//                addBracketValueAndThrowExceptionIfSumIsPositive(sumOfSquareBrackets, bracket);
//            } else if (isThisTypeOfParanthesis(bracket, '(', ')')) {
//                addBracketValueAndThrowExceptionIfSumIsPositive(sumOfRoundBrackets, bracket);
//            }
//        }
//    }
//
//    private static boolean isThisTypeOfParanthesis(Character bracket,
//                                                   Character thisOpeningBracket,
//                                                   Character thisClosingBracket) {
//        return bracket.equals(thisOpeningBracket) || bracket.equals(thisClosingBracket);
//    }
//
//    private static void addBracketValueAndThrowExceptionIfSumIsPositive(int sumOfTheseBrackets,
//                                                                        Character bracket)
//            throws IllegalClosingBracketException {
//        sumOfTheseBrackets += BRACKETS_VALUES.get(bracket);
//        throwIllegalClosingBracketExceptionIfPositive(sumOfTheseBrackets);
//    }
//
//    private static void throwIllegalClosingBracketExceptionIfPositive(int sumOfBracketPairs)
//            throws IllegalClosingBracketException {
//        if (sumOfBracketPairs > 0) throw new IllegalClosingBracketException();
//    }
//}
