package rs.edu.raf.storage;
import rs.edu.raf.storage.enums.Operations;
import rs.edu.raf.storage.enums.Privileges;
import rs.edu.raf.storage.exceptions.*;
import java.util.Collection;
import java.util.Set;

public interface FileStorage {

    /**
     * Kreira jedan ili vise direktorijuma
     * @param path direktorijum u kojem se kreira jedan ili vise praznih direktorijuma
     * @param folderNames nazivi foldera koji se kreiraju
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     */
    void createFolder(String path, String ... folderNames) throws InsufficientPrivilegesException, FileNotFoundException; // ako unapred zadajemo putanju


    /**
     * Kreira jedan ili vise praznih fajlova
     * @param path direktorijum u kojem se kreira jedan ili vise praznih fajlova
     * @param filenames nazivi fajlova koji se kreiraju
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws InvalidExtensionException skladiste ne podrzava ekstenziju prosledjenog fajla
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     * @throws FileLimitExceededException prekoracen je broj fajlova koji se mogu smestiti u folder
     */
    void createFile(String path, String ... filenames) throws InsufficientPrivilegesException, InvalidExtensionException, FileNotFoundException, FileLimitExceededException;


    /**
     * Kreira folder u korenskom direktorijumu skladista
     * @param folderName naziv foldera koji se kreira
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     */
    void createFolder(String folderName) throws InsufficientPrivilegesException; // ako smestamo u korenski dir


    /**
     * Kreira prazan fajl u korenskom direktorijumu skladista
     * @param filename naziv fajla koji se kreira
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws InvalidExtensionException skladiste ne podrzava ekstenziju prosledjenog fajla
     * @throws FileLimitExceededException prekoracen je broj fajlova koji se mogu smestiti u folder
     */
    void createFile(String filename) throws InsufficientPrivilegesException, InvalidExtensionException, FileLimitExceededException;


    /**
     * Brise jedan ili vise fajlova iz skladista
     * @param paths fajlovi koji se brisu
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws FileDeleteFailedException fajl nije uspesno obrisan
     */
    void delete(String ... paths) throws FileNotFoundException, InsufficientPrivilegesException, FileDeleteFailedException;


    /**
     * Premesta fajl ili vise njih iz jednog direktorijuma u drugi u okviru skladista
     * @param destination direktorijum u koji se premestaju fajlovi
     * @param sources fajlovi koji se premestaju
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws OperationFailedException operacija nije uspesno izvrsena
     * @throws FileLimitExceededException prekoracen je broj fajlova koji se mogu smestiti u folder
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     * @throws StorageSizeExceededException prekoracena je maksimalna dozvoljena velicina skladista
     * @throws InvalidExtensionException skladiste ne podrzava ekstenziju prosledjenog fajla
     */
    void move(String destination, String ... sources) throws InsufficientPrivilegesException, OperationFailedException, FileLimitExceededException, FileNotFoundException, StorageSizeExceededException, InvalidExtensionException;


    /**
     * Smesta fajl ili vise njih koji se ne nalaze u skladistu u skladiste
     * @param destination direktorijum u koji se smestaju fajlovi
     * @param sources fajlovi koji se smestaju
     * @throws FileAlreadyInStorageException prosledjeni fajl se vec nalazi u skladistu
     * @throws OperationFailedException operacija nije uspesno izvrsena
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     * @throws FileLimitExceededException prekoracen je broj fajlova koji se mogu smestiti u folder
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws InvalidExtensionException skladiste ne podrzava ekstenziju prosledjenog fajla
     * @throws StorageSizeExceededException prekoracena je maksimalna dozvoljena velicina skladista
     */
    void put(String destination, String ... sources) throws FileAlreadyInStorageException, OperationFailedException, FileNotFoundException, FileLimitExceededException, InsufficientPrivilegesException, InvalidExtensionException, StorageSizeExceededException;


    /**
     * Vrsi pregled svih fajlova i foldera u nekom direktorijumu u skladistu, i opciono njegovim poddirektorijumima
     * @param path direktorijum ciji sadrzaj zelimo da pregledamo
     * @param searchSubdirectories moze biti true ili false, u zavisnosti od toga da li zelimo da pretrazimo i podfoldere
     * @return vraca listu stringova gde je svaki string u formatu "putanja fajla - velicina fajla - tip fajla"
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     */
    Collection<String> list(String path, boolean searchSubdirectories) throws InsufficientPrivilegesException, FileNotFoundException; // default implementacija bez argumenata: prikazi sve foldere i fajlove u root-u skladista


    /**
     * Vrsi napredni pregled svih fajlova i foldera u nekom direktorijumu u skladistu, i opciono njegovim poddirektorijumima
     * @param path direktorijum ciji sadrzaj zelimo da pregledamo
     * @param argument za filtriranje ekstenzija prosledjuje se ekstenzija, a za filtriranje naziva naziv fajla ili foldera
     * @param operation definise tip pregleda - sortiranje (opadajuce ili rastuce) po imenu ili datumu i filtriranje ekstenzije ili imena
     * @param searchSubderictories moze biti true ili false, u zavisnosti od toga da li zelimo da pretrazimo i podfoldere
     * @return vraca listu stringova gde je svaki string u formatu "putanja fajla - velicina fajla - tipafajla"
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     */
    Collection<String> list(String path, String argument, Operations operation, boolean searchSubderictories) throws InsufficientPrivilegesException, FileNotFoundException;


    /**
     * Preuzima fajl koji se nalazi u skladistu
     * @param paths fajl koji se preuzima iz skladista
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     */
    void get(String ... paths) throws InsufficientPrivilegesException, FileNotFoundException;  // preuzimanje u local storage-u je smestanje u neki ranije definisani folder


    /**
     * Inicijalizuje novo skladiste
     * @param path // korenski direktorijum skladista koje se kreira
     * @throws UserNotFoundException korisnik sa unetim kredencijalima nije pronadjen
     */
    void initializeStorage(String path) throws UserNotFoundException;


    /**
     * Dodajemo ogranicenje maksimalnog broja fajlova koji se moze dodati u neki direktorijum u skladistu
     * @param number maksimalan dozvoljeni broj fajlova
     * @param directory direktorijum ciji broj fajlova ogranicavamo
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     * @throws FileNotFoundException ne postoji folder ili fajl na zadatoj putanji
     */
    void limitNumberOfFiles(int number, String directory) throws InsufficientPrivilegesException, FileNotFoundException;


    /**
     * Dodajemo ogranicenje maksimalne velicine skladista u bajtovima koja se ne moze prekoraciti
     * @param sizeInBytes velicina u bajtovima na koju ogranicavamo velicinu skladista
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     */
    void limitStorageSize(long sizeInBytes) throws InsufficientPrivilegesException;


    /**
     * Dodajemo ogranicenje ekstenzije fajla koja se ne moze dodati u skladiste
     * @param extension ekstenzija koju zabranjujemo u skladistu
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     */
    void restrictExtension(String extension) throws InsufficientPrivilegesException;


    /**
     * Dodajemo novog korisnika skladista
     * @param user korisnik kojeg kreiramo, svaki korisnik ima username, password i set privilegija
     * @param privilegesSet privilegije korisnika, mogu biti VIEW, CREATE, DELETE, DOWNLOAD
     * @throws UserAlreadyExistsException korisnik kojeg dodajemo vec postoji
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     */
    void addNewUser(User user, Set<Privileges> privilegesSet) throws UserAlreadyExistsException, InsufficientPrivilegesException;


    /**
     * Uklanjamo korisnika skladista
     * @param user korisnik kojeg uklanjamo, svaki korisnik ima username, password i set privilegija
     * @throws UserNotFoundException korisnik sa unetim kredencijalima nije pronadjen
     * @throws InsufficientPrivilegesException trenutni korisnik nema neophodne privilegije
     */
    void removeUser(User user) throws UserNotFoundException, InsufficientPrivilegesException;


    /**
     * Logovanje postojeceg korisnika skladista
     * @param user korisnik koji se login-uje, svaki korisnik ima username, password i set privilegija
     * @throws UserAlreadyLoggedInException korisnik je vec ulogovan
     * @throws UserNotFoundException korisnik sa unetim kredencijalima nije pronadjen
     */
    void login(User user) throws UserAlreadyLoggedInException, UserNotFoundException;


    /**
     * Logautovanje postojeceg skladista
     * @param user korisnik koji se logout-uje, svaki korisnik ima username, password i set privilegija
     * @throws UserNotFoundException korisnik sa unetim kredencijalima nije pronadjen
     * @throws UserLogoutException korisnik nije trenutni aktivni korisnik
     */
    void logout(User user) throws UserNotFoundException, UserLogoutException;


}
