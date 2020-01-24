import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ParanthesesTest {

    private Parantheses parantheses;

    private List<Character> asCharacterList(String paranthesesAndOtherStrings) {
        return paranthesesAndOtherStrings
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    @Test
    public void testAnEmptyInput() {
        parantheses = new Parantheses(asCharacterList(""));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testASpace() {
        parantheses = new Parantheses(asCharacterList(" "));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testALowerCaseLetter() {
        parantheses = new Parantheses(asCharacterList("a"));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testAUpperCaseLetter() {
        parantheses = new Parantheses(asCharacterList("A"));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testAShortString() {
        parantheses = new Parantheses(asCharacterList("aBc"));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testAValuableOpeningBracket() {
        parantheses = new Parantheses(asCharacterList("("));
        assertEquals("false", parantheses.areAllParanthesesClosed());
    }
    @Test
    public void testAllTypesOfClosedParantheses() {
        parantheses = new Parantheses(asCharacterList("{[()]}"));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testARandomCharOutsideParanthesis() {
        parantheses = new Parantheses(asCharacterList("A{[()]}"));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testARandomCharInsideParanthesis() {
        parantheses = new Parantheses(asCharacterList("{[(a)]}"));
        assertEquals("false", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testSomeMoreClosedParantheses() {
        parantheses = new Parantheses(asCharacterList("[{(((())))]}"));
        assertEquals("true", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testNotClosedParantheses() {
        parantheses = new Parantheses(asCharacterList("[{("));
        assertEquals("false", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testOpeningOneParanthesisWithClosingBracket() {
        parantheses = new Parantheses(asCharacterList("]"));
        assertEquals("trying to open paranthesis with closing bracket", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testOpeningParanthesesWithClosingBracket() {
        parantheses = new Parantheses(asCharacterList("}])[]}()"));
        assertEquals("trying to open paranthesis with closing bracket", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testOneMoreClosingBracket() {
        parantheses = new Parantheses(asCharacterList("()[]{}{}}"));
        assertEquals("trying to open paranthesis with closing bracket", parantheses.areAllParanthesesClosed());
    }

    @Test
    public void testMoreClosingBrackets() {
        parantheses = new Parantheses(asCharacterList("()))]]}}"));
        assertEquals("trying to open paranthesis with closing bracket", parantheses.areAllParanthesesClosed());
    }
}
