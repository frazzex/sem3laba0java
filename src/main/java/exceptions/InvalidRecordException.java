package exceptions;

public class InvalidRecordException extends Exception {
    private final int lineNumber;

    public InvalidRecordException(int lineNumber, String message) {
        super("Ошибка в строке " + lineNumber + ": " + message);
        this.lineNumber = lineNumber;
    }

    public InvalidRecordException(int lineNumber, String message, Throwable cause) {
        super("Ошибка в строке " + lineNumber + ": " + message, cause);
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
