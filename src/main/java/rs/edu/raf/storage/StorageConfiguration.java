package rs.edu.raf.storage;

public interface StorageConfiguration {

    // TODO: work in progress...
    void initializeStorage(String path);
    void limitNumberOfFiles(int number, String directory);
    void limitStorageSize(long sizeInBytes);
    void restrictExtension(String extension);

}
