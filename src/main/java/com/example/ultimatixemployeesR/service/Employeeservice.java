package com.example.ultimatixemployeesR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.ultimatixemployeesR.entity.User;
import com.example.ultimatixemployeesR.repository.EmployeeRepository;
import com.example.ultimatixemployeesR.service.exceptions.NoSuchCustomerExistsException;


@Service
public class Employeeservice{
	@Autowired
	private EmployeeRepository users;
	
	public List<User> getEmployee(){
		return users.findAll();
	}

	public List<User> listAllEmployees() {
		Pageable paging = PageRequest.of(0, 6);
		return (List<User>) users.findAll(paging).toList();
	}

	public User saveEmployee(User emp) {
		return users.save(emp);
    }
    public String encodePassword(String a) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(a);
		return encodedPassword;
	}

	public User updateEmployee(User emp) {
		return users.save(emp);
	}

	public void cancel(User emp) {
		users.findAll();
	}
	
	public User getEmployee(Integer id) {
		return users.findById(id).orElseThrow(
				() -> new NoSuchCustomerExistsException("NO CUSTOMER PRESENT WITH ID = " + id));
	}

	public void deleteEmployee(Integer id) {
		users.deleteById(id);
	}

	// public List<User> searchEmployee(String firstname) {
	// 	return users.findByFirstnameContaining(firstname);
	// }

	public List<User> employeesPagination(int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		return users.findAll(paging).toList();
	}

	public User getEmployeeByUsername(String username) {
		return users.getUserByUsername(username);
	}


}