package rs.edu.raf.storage;

import rs.edu.raf.storage.enums.Operations;
import rs.edu.raf.storage.enums.Privileges;
import rs.edu.raf.storage.exceptions.*;

import java.util.Collection;
import java.util.Set;

public interface FileStorage {
    // TODO: srediti potpise metoda (koje exceptione throw-uju):

    // TODO: nijedna metoda ne sme da ispisuje!

    // Operacije nad skladistem:
    // ----------------------------------------------------------

    void createFolder(String path, String ... folderNames) throws InsufficientPrivilegesException, FileNotFoundException; // ako unapred zadajemo putanju
    void createFile(String path, String ... filenames) throws InsufficientPrivilegesException, InvalidExtensionException, FileNotFoundException, FileLimitExceededException;
    void createFolder(String folderName) throws InsufficientPrivilegesException; // ako smestamo u korenski dir
    void createFile(String filename) throws InsufficientPrivilegesException, InvalidExtensionException, FileLimitExceededException;
    void delete(String ... paths) throws FileNotFoundException, InsufficientPrivilegesException, FileDeleteFailedException;
    void move(String destination, String ... sources) throws InsufficientPrivilegesException, FileLimitExceededException, FileNotFoundException, StorageSizeExceededException, InvalidExtensionException;
    void put(String destination, String ... sources) throws FileAlreadyInStorageException, FileNotFoundException, FileLimitExceededException, InsufficientPrivilegesException, InvalidExtensionException, StorageSizeExceededException;
    Collection<String> list(String path, boolean searchSubdirectories) throws InsufficientPrivilegesException, FileNotFoundException; // default implementacija bez argumenata: prikazi sve foldere i fajlove u root-u skladista
    Collection<String> list(String path, String argument, Operations operation, boolean searchSubderictories) throws InsufficientPrivilegesException, FileNotFoundException;
    void get(String ... paths) throws InsufficientPrivilegesException, FileNotFoundException;  // preuzimanje u local storage-u je smestanje u neki ranije definisani folder

    // TODO: work in progress...
    void initializeStorage(String path) throws UserNotFoundException;
    void limitNumberOfFiles(int number, String directory) throws InsufficientPrivilegesException, FileNotFoundException;
    void limitStorageSize(long sizeInBytes) throws InsufficientPrivilegesException;
    void restrictExtension(String extension) throws InsufficientPrivilegesException;

    // TODO: work in progress...
    void addNewUser(User user, Set<Privileges> privilegesSet) throws UserAlreadyExistsException, InsufficientPrivilegesException;
    void removeUser(User user) throws UserNotFoundException, InsufficientPrivilegesException;
    void login(User user) throws UserAlreadyLoggedInException, UserNotFoundException;
    void logout(User user) throws UserNotFoundException, UserLogoutException;



}
