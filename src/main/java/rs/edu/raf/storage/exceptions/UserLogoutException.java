package rs.edu.raf.storage.exceptions;

public class UserLogoutException extends RuntimeException {

    public UserLogoutException() {
        super("Greska! Korisnik nije trenutni aktivni korisnik.");
    }

    public UserLogoutException(String message) {
        super(message);
    }
}
