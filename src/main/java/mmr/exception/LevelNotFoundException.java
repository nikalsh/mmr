package mmr.exception;

public class LevelNotFoundException extends Exception {

    public LevelNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public LevelNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
