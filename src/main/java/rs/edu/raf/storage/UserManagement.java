package rs.edu.raf.storage;

import rs.edu.raf.storage.enums.Privileges;

import java.util.Set;

public interface UserManagement {

    // TODO: work in progress...
    void addNewUser(AbstractUser user, Set<Privileges> privilegesSet);
    void disconnectUser(AbstractUser user);
}
