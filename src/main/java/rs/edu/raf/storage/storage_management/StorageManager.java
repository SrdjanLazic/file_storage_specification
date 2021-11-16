package rs.edu.raf.storage.storage_management;

public class StorageManager {

    /**
     * Sluzi za setovanje trenutnog aktivnog tipa skladista
     */
    private static FileStorage fileStorage;

    /**
     * Postavlja konkretnu implementaciju skladista
     * @param fs konkretna implementacija interfejsa FileStorage
     */
    public static void registerStorage(FileStorage fs){
        fileStorage = fs;
    }

    public static FileStorage getFileStorage(){
        return fileStorage;
    }

}
