package rs.edu.raf.storage;

import rs.edu.raf.storage.exceptions.InvalidExtensionException;

import java.util.Set;

public interface FileStorage {

    // Operacije nad skladistem:
    // ----------------------------------------------------------

    void createFolder(String path, String folderName); // ako unapred zadajemo putanju
    void createFile(String path, String filename) throws InvalidExtensionException;
    void createFolder(String folderName); // ako smestamo u korenski dir
    void createFile(String filename) throws InvalidExtensionException;
    void delete(String path);
    void move(String source, String destination);
    void put(String source, String destination);
    void list(); // default implementacija bez argumenata: prikazi sve foldere i fajlove u root-u skladista
    void list(String argument, Operations operation);

    void get(String path);  // preuzimanje u local storage-u je smestanje u neki ranije definisani folder



    // TODO: Konfiguracija skladsita (work in progress):
    // ------------------------------------------------------------

    void initializeStorage(String path);
    void limitNumberOfFiles(int number, String directory);
    void limitStorageSize(long sizeInBytes);
    void restrictExtension(String extension);

    // TODO: Dodavanje, uklanjanje korisnika, diskonektovanje:
    // -------------------------------------------------------------
    void addNewUser(AbstractUser user, Set<Privileges> privilegesSet);
    void disconnectUser(AbstractUser user);


}
