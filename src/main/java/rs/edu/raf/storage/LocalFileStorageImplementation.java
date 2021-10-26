package rs.edu.raf.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class LocalFileStorageImplementation implements FileStorage {

    private String downloadFolder = "/Download";
    // TODO: treba dodati polje koje drzi root direktorijum skladista, i onda sve putanje promeniti tako da su relativne u odnosu na root
    private String currentDirectory = "C:";

    @Override
    public void create(String path, String filename) {
        if(filename.contains("{") && filename.contains("}")){
            filename = filename.substring(1, filename.length()-1);
            //String[] files = filename.split(",");
            for(String files : filename.split(",")){
                String fullPath = path + "/" + files;
                File newFile = new File(fullPath);
                try {
                    newFile.createNewFile();
                } catch (IOException e) { // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        else {
            String fullPath = path + "/" + filename;
            File newFile = new File(fullPath);
            try {
                newFile.createNewFile();
            } catch (IOException e) { // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void create(String filename) {
        String fullPath = currentDirectory + "/skladiste/" + filename;
        File newFile = new File(fullPath);
        try {
            newFile.createNewFile();
        } catch (IOException e) { // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String path) {
        File file = new File(path);

        if(!file.exists()) {
            System.out.println("Greska! Navedeni fajl ne postoji.");
            return;
        }

        String type = file.isDirectory() ? "Folder" : "Fajl";
		boolean deleted = file.delete();

		if(deleted)
			System.out.println(type + " je uspesno obrisan.");
		else
            System.out.println("\nBrisanje nije uspelo. Proverite da li ste ispravno napisali naziv fajla i ekstenziju.");
    }

    @Override
    public void move(String source, String destination) {

        Path result = null;

        try {
            result = Files.move(Paths.get(source), Paths.get(destination));
        } catch (NoSuchFileException e1) {
            System.out.println("Greska! Navedeni fajl ne postoji.");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result != null)
			System.out.println("Fajl je uspesno premesten.");
		else
			System.out.println("Fajl nije premesten.");
    }

    @Override
    public void list() {
        //File rootDirectory = new File("D:");
        File rootDirectory = new File(currentDirectory);
        File[] fileList = rootDirectory.listFiles();
        String type;

        System.out.println("\nLista fajlova i foldera u skladistu:");
        System.out.println("-----------------------------------\n");
        for (File file: fileList){
            type = file.isDirectory() ? "folder" : "file";
            System.out.println(file.getName() + " --- " + file.length() / (1024 * 1024) + " MB " + " --- " + type);
        }
    }

    @Override
    public void list(String argument) {

    }

    @Override
    public void get(String path) {
        move(path, downloadFolder);
    }
}
