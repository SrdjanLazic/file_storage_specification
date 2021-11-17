package rs.edu.raf.storage.exceptions;

public class CurrentUserIsNullException extends RuntimeException {

    public CurrentUserIsNullException(){
        super("Greska! Trenutno nijedan korisnik nije aktivan.");
    }

    public CurrentUserIsNullException(String message){
        super(message);
    }
}
