package rs.edu.raf.storage.exceptions;

public class UserAlreadyLoggedInException extends RuntimeException{
    public UserAlreadyLoggedInException() {
        super("Greska! Korisnik je vec ulogovan.");
    }

    public UserAlreadyLoggedInException(String message) {
        super(message);
    }
}
