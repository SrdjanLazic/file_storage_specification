package rs.edu.raf.storage;

public interface FileStorage {

    // Operacije nad skladistem:
    // ----------------------------------------------------------

    void createFolder(String path, String folderName); // ako unapred zadajemo putanju
    void createFile(String path, String filename);
    void createFolder(String folderName); // ako smestamo u korenski dir
    void createFile(String filename);
    void delete(String path);
    void move(String source, String destination);
    void list(); // default implementacija bez argumenata: prikazi sve foldere i fajlove u root-u skladista
    void list(String argument, Operations operation);
    // TODO: put metoda (smestanje):

    void get(String path);  // preuzimanje u local storage-u je smestanje u neki ranije definisani folder



    // TODO: Konfiguracija skladsita (work in progress):
    // ------------------------------------------------------------

    void initializeStorage(String path);
    void limitNumberOfFiles(int number, String directory);
    void limitStorageSize(long sizeInBytes);
    void restrictExtension(String extension);

    // TODO: Dodavanje, uklanjanje korisnika:
    // -------------------------------------------------------------

}
