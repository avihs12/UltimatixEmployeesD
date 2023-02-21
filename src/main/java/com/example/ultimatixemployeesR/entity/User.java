package com.example.ultimatixemployeesR.entity;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class User implements Serializable{
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String password;
    private String role = "USER";
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
	public String toString() {
		return "Employee [id=" + id  +"username=" + username + "firstname=" + firstname +"lastname=" + lastname +", password=" + password+ ",role"+ role +"]";
	}
}

// firstname=" + firstname + 
// ",lastname=" + lastname + ", salary="+ 
// salary + ", salaryhike=" + salaryhike+",