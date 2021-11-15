package rs.edu.raf.storage;

import rs.edu.raf.storage.enums.Operations;
import rs.edu.raf.storage.enums.Privileges;
import rs.edu.raf.storage.exceptions.*;

import java.util.Set;

public interface FileStorage {
    // TODO: srediti potpise metoda (koje exceptione throw-uju):

    // TODO: nijedna metoda ne sme da ispisuje!

    // Operacije nad skladistem:
    // ----------------------------------------------------------

    void createFolder(String path, String ... folderNames); // ako unapred zadajemo putanju
    void createFile(String path, String ... filenames) throws InvalidExtensionException;
    void createFolder(String folderName); // ako smestamo u korenski dir
    void createFile(String filename) throws InvalidExtensionException;
    void delete(String ... paths) throws FileNotFoundException, InsufficientPrivilegesException;
    void move(String destination, String ... sources);
    void put(String destination, String ... sources) throws FileAlreadyInStorageException;
    void list(String path); // default implementacija bez argumenata: prikazi sve foldere i fajlove u root-u skladista
    void list(String path, String argument, Operations operation);
    void get(String ... paths);  // preuzimanje u local storage-u je smestanje u neki ranije definisani folder

    // TODO: work in progress...
    void initializeStorage(String path) throws UserNotFoundException;
    void limitNumberOfFiles(int number, String directory) throws InsufficientPrivilegesException, FileNotFoundException;
    void limitStorageSize(long sizeInBytes) throws InsufficientPrivilegesException;
    void restrictExtension(String extension) throws InsufficientPrivilegesException;

    // TODO: work in progress...
    void addNewUser(User user, Set<Privileges> privilegesSet) throws UserAlreadyExistsException;
    void removeUser(User user) throws UserNotFoundException;
    void login(User user);
    void logout(User user);



}
