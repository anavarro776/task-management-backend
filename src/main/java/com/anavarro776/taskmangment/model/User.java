package com.anavarro776.taskmangment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size( max = 100)
    @Column(nullable = false,unique = true)
    private String name;

    @NotBlank
    @Size( max = 100)
    @Column(nullable = false,unique = true)
    private String username;

    @NotBlank
    @Size(min = 8, max = 255)
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;



    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private java.util.List<Task> tasks;


    // Getters and Setters
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", username='" + username + '\'' +   '\'' + ", role='" + role + '\'' + '}';
    }

    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof User))return false;
        User user=(User) o;
        return Objects.equals(id, user.id);


    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {this.name = name;}

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(Role role) {
        this.role=role;
    }
    public enum Role {ADMIN,USER}

}
