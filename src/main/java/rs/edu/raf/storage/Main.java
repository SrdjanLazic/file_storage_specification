package rs.edu.raf.storage;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileStorage fileStorage = new LocalFileStorageImplementation();
        Scanner input =  new Scanner(System.in);
        String command = input.nextLine();

        //fileStorage.list();

        //fileStorage.move("D:/skladiste/hello.txt", "D:/");

        //fileStorage.delete("D:/skladiste/tekst.txt");
        if (command.contains("create")) {
            fileStorage.create("C:/skladiste", "{1,2,3,4}");
        }
    }

}
