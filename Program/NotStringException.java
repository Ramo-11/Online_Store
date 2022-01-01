package Program;

public class NotStringException extends NumberFormatException {
    public NotStringException() {
        super("Input is not a string");
    }
}
