package rs.edu.raf.storage.exceptions;

public class FileNotInStorageException extends RuntimeException {

    public FileNotInStorageException(){
        super("Greska! Prosledjeni fajl se ne nalazi u skladistu.");
    }

    public FileNotInStorageException(String message){
        super(message);
    }
}
