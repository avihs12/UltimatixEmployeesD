package com.example.UltimatixEmployeesD.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private int employeeid;
    @Column(nullable = false)
    private String username;
    private String password;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private int salaryhike;
    @Column(nullable = false)
    private boolean enabled;
    @Column(nullable = false)
    private boolean isAccountNonExpired;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
   

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
	public String toString() {
		return "Employee [id=" + id + ", empid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname + ", salary="+ salary + ", salaryhike=" + salaryhike+", password=" + password+ ", roles=" + roles+"]";
	}

    public Object map(Object object) {
        return null;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setIsEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setIsAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public void  setIsAccountNonLocked(boolean isAccountNonLocked){
        this.isAccountNonExpired = isAccountNonLocked;
    }
    public void  setIsCredentialsNonExpired(boolean isCredentialsNonExpired){
        this.isAccountNonExpired = isCredentialsNonExpired;
    }

    public boolean getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public boolean  getIsAccountNonLocked(){
        return isAccountNonExpired;
    }
    public boolean  getIsCredentialsNonExpired(){
        return isAccountNonExpired;
    }
    
}