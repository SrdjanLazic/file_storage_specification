package rs.edu.raf.storage.exceptions;

public class FileLimitExceededException extends RuntimeException {

    public FileLimitExceededException() {
        super("Greska! Prekoracen je maksimalan dozvoljeni broj fajlova u folderu.");
    }

    public FileLimitExceededException(String message){
        super(message);
    }
}
