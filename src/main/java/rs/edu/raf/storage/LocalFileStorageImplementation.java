package rs.edu.raf.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class LocalFileStorageImplementation implements FileStorage {

    private String downloadFolder = "/Download";
    // TODO: treba dodati polje koje drzi root direktorijum skladista, i onda sve putanje promeniti tako da su relativne u odnosu na root
    //private String currentDirectory = "D:";
    private String currentDirectory = "E:";

    private List<File> getFileList() {
        File directory = new File(currentDirectory);
        File[] fileList = directory.listFiles();
        return Arrays.asList(fileList);
    }

    @Override
    public void create(String path, String filename) {
        currentDirectory = path;
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
        List<File> fileList = getFileList();
        String type;

        System.out.println("\nLista fajlova i foldera u skladistu:");
        System.out.println("-----------------------------------\n");
        for (File file: fileList){
            type = file.isDirectory() ? "DIR" : "FILE";
            System.out.println(file.getName() + " --- " + file.length() / (1024 * 1024) + " MB " + " --- " + type);
        }
    }

    @Override
    public void list(String argument, Operations operation) {

        String type;
        List<File> fileList = getFileList();

        if (operation == Operations.FILTER_EXTENSION) {
            String extension = argument;
            System.out.println("\nLista fajlova sa datom ekstenzijom u skladistu:");
            System.out.println("------------------------------------------------\n");
            for (File file : fileList) {
                if (file.getName().endsWith(extension))
                    System.out.println(file.getPath());
            }
        } else if (operation == Operations.FILTER_FILENAME) {
            String filename = argument;
            System.out.println("\nLista fajlova ciji nazivi sadrze dati tekst:");
            System.out.println("----------------------------------------------\n");
            for (File file : fileList) {
                if (file.getName().contains(filename))
                    System.out.println(file.getPath());
            }
        } else if (operation == Operations.SORT_BY_NAME_ASC || operation == Operations.SORT_BY_NAME_DESC) {
            String order;
            if(operation == Operations.SORT_BY_NAME_ASC) {
                fileList.sort(new FileNameComparator());
                order = " rastuce ";
            }
            else {
                fileList.sort(new FileNameComparator().reversed());
                order = " opadajuce ";
            }

            System.out.println("\nLista fajlova i foldera sortirana" + order + "po nazivu:");
            System.out.println("-----------------------------------------------------\n");
            for (File file : fileList) {
                type = file.isDirectory() ? "DIR" : "FILE";
                System.out.println(file.getName() + " --- " + file.length() / (1024 * 1024) + " MB " + " --- " + type);
            }
        } else if (operation == Operations.SORT_BY_DATE_MODIFIED_ASC || operation == Operations.SORT_BY_DATE_MODIFIED_DESC) {
            String order;
            if(operation == Operations.SORT_BY_DATE_MODIFIED_ASC) {
                fileList.sort(new FileModifiedDateComparator());
                order = " rastuce ";
            }
            else {
                fileList.sort(new FileModifiedDateComparator().reversed());
                order = " opadajuce ";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            System.out.println("\nLista fajlova i foldera sortirana" + order + "po datumu izmene:");
            System.out.println("-----------------------------------------------------\n");
            for (File file : fileList) {

                type = file.isDirectory() ? "DIR" : "FILE";
                System.out.println(file.getName() + " --- " + file.length() / (1024 * 1024) + " MB" + " --- " + type + " --- " + sdf.format(file.lastModified()));
            }
        // TODO: treba videti sta sa ovim, po onome sto sam citao na netu,
        //  Linux ne pise uopste ovu vrednost, tako da ja ne znam da li ovo moze ikako da se uradi a da radi svuda
        } else if (operation == Operations.SORT_BY_DATE_CREATED) {

        }
    }

    @Override
    public void get(String path) {
        move(path, downloadFolder);
    }
}
