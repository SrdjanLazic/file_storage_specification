package rs.edu.raf.storage.exceptions;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException() {
        super("Greska! Trazeni fajl ili folder nisu pronadjeni.");
    }

    public FileNotFoundException(String message) {
        super(message);
    }
}
