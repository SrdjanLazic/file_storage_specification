package rs.edu.raf.storage.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Greska! Korisnik sa unetim kredencijalima vec postoji.");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
