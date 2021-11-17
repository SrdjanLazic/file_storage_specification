package rs.edu.raf.storage.user_management;

import rs.edu.raf.storage.enums.Privileges;

import java.util.*;


/**
 * Klasa User predstavlja jednog korisnika skladista
 */
public class User {

    private String username;
    private String password;
    private Set<Privileges> privileges;
    private Map<String, Set<Privileges>> folderPrivileges = new HashMap<>();

    public User(){

    }

    /**
     * Kreira novu instancu klase User
     * @param username username korisnika
     * @param password password korisnika
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.privileges = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Privileges> getPrivileges() {
        return privileges;
    }

    /**
     * Postavlja privilegije za korisnika
     * @param privileges set privilegija koji se dodaje korisniku
     */
    public void setPrivileges(Set<Privileges> privileges) {
        Set<Privileges> privilegesToAdd = new HashSet<>();

        if(privileges.contains(Privileges.DELETE))
            privilegesToAdd.addAll(List.of(Privileges.DELETE, Privileges.CREATE, Privileges.DOWNLOAD, Privileges.VIEW));
        else if(privileges.contains(Privileges.CREATE))
            privilegesToAdd.addAll(List.of(Privileges.CREATE, Privileges.DOWNLOAD, Privileges.VIEW));
        else if(privileges.contains(Privileges.DOWNLOAD))
            privilegesToAdd.addAll(List.of(Privileges.DOWNLOAD, Privileges.VIEW));
        else if(privileges.contains(Privileges.VIEW))
            privilegesToAdd.add((Privileges.VIEW));

        this.privileges = privilegesToAdd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privileges=" + privileges +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equalsIgnoreCase(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public Map<String, Set<Privileges>> getFolderPrivileges() {
        return folderPrivileges;
    }

    public void setFolderPrivileges(Map<String, Set<Privileges>> folderPrivileges) {
        this.folderPrivileges = folderPrivileges;
    }
}
