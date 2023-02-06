package com.example.ultimatixemployeesR.entity;

import jakarta.persistence.*;

@Entity
public class User{
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private int employeeid;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private int salaryhike;
    private String role = "USER";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalaryhike() {
        return salaryhike;
    }

    public void setSalaryhike(int salaryhike) {
        this.salaryhike = salaryhike;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
	public String toString() {
		return "Employee [id=" + id + ", empid=" + employeeid + ", firstname=" + firstname + 
        ",lastname=" + lastname + ", salary="+ 
        salary + ", salaryhike=" + salaryhike+", password=" + password+ ",role"+role+"]";
	}
}
