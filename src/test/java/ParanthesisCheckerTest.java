import org.junit.Test;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParanthesisCheckerTest {

    @Test
    public void testAnEmptyInput() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList(Character.MIN_VALUE)));
    }

    @Test
    public void testASpace() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList(' ')));
    }

    @Test
    public void testALowerCaseLetter() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('a')));
    }

    @Test
    public void testAnUpperCaseLetter() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('B')));
    }

    @Test
    public void testOtherCharacters() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('a', 'B', 'c')));
    }

    @Test
    public void testAnOpeningBracket() {
        assertEquals("false",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(')));
    }

    @Test
    public void testAllTypesOfClosedParantheses() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(', '{', '[', ']', '}', ')')));
    }

    @Test
    public void testARandomCharOutsideParanthesis() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('A', '(', '{', '[', ']', '}', ')')));
    }

    @Test
    public void testRandomCharsInsideParanthesis() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(', '{', '[', 'a', 'B', 'c', ']', 'd', '}', 'e', ')')));
    }

    @Test
    public void testSomeMoreClosedParantheses() {
        assertEquals("true",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(', '{', '[', '[', ']', ']', '}', ')')));
    }

    @Test
    public void testNotClosedParantheses() {
        assertEquals("false",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(', '{', '[')));
    }

    @Test
    public void testOpeningOneParanthesisWithClosingBracket() {
        assertEquals("trying to open paranthesis with closing bracket",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('}')));
    }

    @Test
    public void testOpeningParanthesesWithClosingBracket() {
        assertEquals("trying to open paranthesis with closing bracket",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList(']', '}', ')', '[', ']', '}', '(', ')')));
    }

    @Test
    public void testOneMoreClosingBracket() {
        assertEquals("trying to open paranthesis with closing bracket",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(', ')', '[', ']', '{', '}', '}')));
    }

    @Test
    public void testMoreClosingBrackets() {
        assertEquals("trying to open paranthesis with closing bracket",
                ParanthesisChecker.areAllParanthesesClosed(
                        Arrays.asList('(', ')', ')', ')', ']', ']', '}', '}')));
    }

    @After
    public void resetParanthesisCheckerStaticVariables() {
        ParanthesisChecker.sumOfCurlyBrackets = 0;
        ParanthesisChecker.sumOfSquareBrackets = 0;
        ParanthesisChecker.sumOfRoundBrackets = 0;
        ParanthesisChecker.stop = false;
    }
}
