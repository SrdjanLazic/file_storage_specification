package rs.edu.raf.storage.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Greska! Korisnik sa unetim kredencijalima nije pronadjen.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
