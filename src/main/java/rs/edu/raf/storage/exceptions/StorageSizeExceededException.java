package rs.edu.raf.storage.exceptions;

public class StorageSizeExceededException extends RuntimeException {

    public StorageSizeExceededException() {
        super("Greska! Prekoracena je maksimalna dozvoljena velicina skladista.");
    }

    public StorageSizeExceededException(String message) {
        super(message);
    }
}
