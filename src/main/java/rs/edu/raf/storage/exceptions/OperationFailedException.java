package rs.edu.raf.storage.exceptions;

public class OperationFailedException extends RuntimeException {

    public OperationFailedException(){
        super("Greska! Operacija nije uspesno izvrsena.");
    }

    public OperationFailedException(String message){
        super(message);
    }
}
