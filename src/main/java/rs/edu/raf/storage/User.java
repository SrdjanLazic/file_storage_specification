package rs.edu.raf.storage;

import java.util.HashSet;
import java.util.Set;

public class User extends AbstractUser {

    private String username;
    private String password;
    private Set<Privileges> privileges;
    // TODO: Privilegije!
    // TODO: Apstraktna klasa User, koju nasledjuju Superuser i RegularUser?
    // TODO: mozda da User ima polje gde pisemo kom Skladistu pripada?
    // TODO: polje tipa boolean isSuperuser


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
        this.privileges = privileges;
    }
}
