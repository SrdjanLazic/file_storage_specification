package rs.edu.raf.storage.exceptions;

public class FileDeleteFailedException extends RuntimeException {

    public FileDeleteFailedException(){
        super("Greska! Fajl nije uspesno obrisan.");
    }

    public FileDeleteFailedException(String message){
        super(message);
    }
}
