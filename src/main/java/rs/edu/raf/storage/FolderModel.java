package rs.edu.raf.storage;

import java.io.File;
import java.util.List;

public class FolderModel {

    private List<FileModel> files;
    private FolderModel parentFolder;
    private Skladiste root;
    private File currentFolder;


    public FolderModel(){



    }

    public List<FileModel> getFiles() {
        return files;
    }

    public FolderModel getParentFolder() {
        return parentFolder;
    }

    public Skladiste getRoot() {
        return root;
    }

    public File getCurrentFolder() {
        return currentFolder;
    }
}
