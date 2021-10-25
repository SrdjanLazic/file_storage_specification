package rs.edu.raf.storage;

import javax.swing.plaf.DimensionUIResource;

public interface FileStorage {

    public void create(String path);
    public void delete(String path);
    public void move(String source, String destination);
    // TODO: list metode:
    public void list();
    public void list(String argument);
    // TODO: put metoda:
    // preuzimanje u local storage-u je smestanje u neki ranije definisani folder
    public void get(String path);



}
