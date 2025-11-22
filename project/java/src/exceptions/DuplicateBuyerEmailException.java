public class DuplicateBuyerEmailException extends RuntimeException {
    public DuplicateBuyerEmailException() {
        super("Buyer with same email already exists.");
    }
    public DuplicateBuyerEmailException(String msg) {
        super(msg);
    }
}
