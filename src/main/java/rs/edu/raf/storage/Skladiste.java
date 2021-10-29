package rs.edu.raf.storage;

import java.io.File;
import java.util.List;

public class Skladiste {

    private File users;
    private File config;
    private List<FolderModel> folders;
    private List<FileModel> files;

    public Skladiste() {
        //users = new File(root + "/users.json");
        // za config isto to

        // upisi u fajl users.json username i password korisnika koji je kreirao ovo skladiste
        // upisi u config root direktorijum skladista i sve ostalo sto skladiste ima

        // eksportuj ta dva fajla i sacuvaj ih
    }

    public List<FolderModel> getFolders() {
        return folders;
    }

    public List<FileModel> getFiles() {
        return files;
    }
}

