public class IllegalClosingBracketException extends Exception {

    public IllegalClosingBracketException() {
        super("Trying to open paranthesis with closing bracket!");
    }

    public IllegalClosingBracketException(String message) {
        super(message);
    }
}
