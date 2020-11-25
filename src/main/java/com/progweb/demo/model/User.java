package com.progweb.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity //become a JP entity???
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email")) // name the table
public class User {

    @Id //id become a primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY) //strategie de la cle primaire
    private Long id;

    @Column(name ="first_name") // noms des colonnes
    private String firstName;

    @Column(name="last_name")
    private String lastName;

//without definir @column le nom de la colonne est automatiquement le  nom de la classe
    private String email;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User(){

    }

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
