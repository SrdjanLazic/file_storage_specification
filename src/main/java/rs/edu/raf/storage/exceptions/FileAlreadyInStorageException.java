package rs.edu.raf.storage.exceptions;

public class FileAlreadyInStorageException extends RuntimeException {

    public FileAlreadyInStorageException(){
        super("Greska! Prosledjeni fajl se vec nalazi u skladistu.");
    }

    public FileAlreadyInStorageException(String message){
        super(message);
    }
}
