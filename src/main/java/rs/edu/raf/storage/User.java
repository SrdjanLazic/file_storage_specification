package rs.edu.raf.storage;

import rs.edu.raf.storage.enums.Privileges;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User {

    private String username;
    private String password;
    private Set<Privileges> privileges;


    public User(){

    }

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

    public void setPrivileges(Set<Privileges> privileges) {
        Set<Privileges> privilegesToAdd = new HashSet<>();

        if(privileges.contains(Privileges.DELETE))
            privilegesToAdd.addAll(List.of(Privileges.WRITE, Privileges.READ, Privileges.DELETE));
        else if(privileges.contains(Privileges.WRITE))
            privilegesToAdd.addAll(List.of(Privileges.READ, Privileges.WRITE));
        else if(privileges.contains(Privileges.READ))
            privilegesToAdd.add((Privileges.READ));

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

        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
