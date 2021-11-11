package rs.edu.raf.storage;

public class StorageManager {

    private static FileStorage fileStorage;

    public static void registerStorage(FileStorage fs){
        fileStorage = fs;
    }

    public static FileStorage getFileStorage(){
        return fileStorage;
    }

}
