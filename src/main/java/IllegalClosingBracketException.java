public class IllegalParanthesisException extends Exception {

    public IllegalParanthesisException() {
        super("Trying to open paranthesis with closing bracket!");
    }

    public IllegalParanthesisException(String message) {
        super(message);
    }
}
