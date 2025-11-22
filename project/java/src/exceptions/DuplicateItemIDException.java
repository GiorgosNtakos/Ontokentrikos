public class DuplicateItemIDException extends RuntimeException {
    public DuplicateItemIDException() {
        super("Item with same ID already exists.");
    }
    public DuplicateItemIDException(String msg) {
        super(msg);
    }
}
