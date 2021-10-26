package rs.edu.raf.storage;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileStorage fileStorage = new LocalFileStorageImplementation();
        fileStorage.list();

        //fileStorage.move("D:/skladiste/hello.txt", "D:/");

        //fileStorage.delete("D:/skladiste/tekst.txt");
    }

}
