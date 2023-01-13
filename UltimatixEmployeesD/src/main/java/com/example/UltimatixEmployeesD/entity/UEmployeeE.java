package com.example.UltimatixEmployeesD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "table_Employee_data3")
public class UEmployeeE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	private Long employeeid;
	private String firstname;
	private String lastname;
	private Long salary;
	private Long salaryhike;
	
	
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public Long getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
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
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Long getSalaryhike() {
		return salaryhike;
	}
	public void setSalaryhike(Long salaryhike) {
		this.salaryhike = salaryhike;
	}
	
	@Override
	public String toString() {
		return "Employee [sno=" + sno + ", empid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname + ", salary"+ salary + ", salaryhike" + salaryhike+"]";
	}
}

