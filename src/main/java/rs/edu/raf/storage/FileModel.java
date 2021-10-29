package rs.edu.raf.storage;

import java.io.File;

public class FileModel {

    private FolderModel parentFolder;
    private File currentFile;

    public FileModel(){

    }

    public FolderModel getParentFolder() {
        return parentFolder;
    }

    public File getCurrentFile() {
        return currentFile;
    }
}
