package rs.edu.raf.storage.exceptions;

public class InvalidExtensionException extends RuntimeException {

    public InvalidExtensionException(){
        super("Greska! Nije moguce cuvati fajl u ovoj ekstenziji.");
    }

    public InvalidExtensionException(String message){
        super(message);
    }
}
