package ashish.springsecuirty.SpringSecurityDemo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auth_id;

    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private users users;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return auth_id;
    }

    public void setId(int id) {
        this.auth_id = id;
    }

    public ashish.springsecuirty.SpringSecurityDemo.Entity.users getUsers() {
        return users;
    }

    public void setUsers(ashish.springsecuirty.SpringSecurityDemo.Entity.users users) {
        this.users = users;
    }

    public authorities() {
    }

    public authorities(int id, String authority, ashish.springsecuirty.SpringSecurityDemo.Entity.users users) {
        this.auth_id = id;
        this.authority = authority;
        this.users = users;
    }

    @Override
    public String toString() {
        return "authorities{" +
                "auth_id=" + auth_id +
                ", authority='" + authority + '\'' +
                ", users=" + users +
                '}';
    }
}
