package com.example.UltimatixEmployeesD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "table_ultimatix_data")

public class UEmployeeE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	private Long employeeid;
	private String firstname;
	private String lastname;
	private int salary;
	private int salarhike;
	@Override
	public String toString() {
	return "Employee [sno=" + sno + ", empid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname + ", salary"+ salary + ", salaryhike" + salarhike+"]";
	}
}

