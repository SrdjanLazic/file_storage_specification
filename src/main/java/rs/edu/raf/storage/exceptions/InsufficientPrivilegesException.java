package rs.edu.raf.storage.exceptions;

public class InsufficientPrivilegesException extends RuntimeException {

    public InsufficientPrivilegesException() {
        super("Greska! Nemate potrebne privilegije za izvrsavanje akcije");
    }

    public InsufficientPrivilegesException(String message) {
        super(message);
    }
}
