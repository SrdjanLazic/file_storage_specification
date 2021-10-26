package rs.edu.raf.storage;

public interface FileStorage {

    // ako unapred zadajemo putanju:
    void create(String path, String filename);
    // ako smestamo u korenski dir:
    void create(String filename);
    void delete(String path);
    void move(String source, String destination);
    // TODO: list metode:
    // default implementacija bez argumenata: prikazi sve foldere i fajlove u root-u skladista:
    void list();
    void list(String argument);
    // TODO: put metoda (smestanje):

    // preuzimanje u local storage-u je smestanje u neki ranije definisani folder
    void get(String path);

}
