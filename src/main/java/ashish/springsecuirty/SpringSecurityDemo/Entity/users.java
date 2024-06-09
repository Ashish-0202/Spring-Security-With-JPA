package ashish.springsecuirty.SpringSecurityDemo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class users {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "users" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ashish.springsecuirty.SpringSecurityDemo.Entity.authorities> authorities;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<ashish.springsecuirty.SpringSecurityDemo.Entity.authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<ashish.springsecuirty.SpringSecurityDemo.Entity.authorities> authorities) {
        this.authorities = authorities;
    }

    public users() {
    }

    public users(int user_id, String username, String password, boolean enabled, Set<ashish.springsecuirty.SpringSecurityDemo.Entity.authorities> authorities) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
