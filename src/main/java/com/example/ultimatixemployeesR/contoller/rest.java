package com.example.ultimatixemployeesR.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ultimatixemployeesR.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.example.ultimatixemployeesR.service.Employeeservice;
import com.example.ultimatixemployeesR.Jwt.JwtResponse;
import com.example.ultimatixemployeesR.Jwt.JwtService;
import com.example.ultimatixemployeesR.auth.*;
import com.example.ultimatixemployeesR.Jwt.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
public class rest{

    @Autowired
	private Employeeservice service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtUtils jwtutils;

    @GetMapping("/employee")
    
    public ResponseEntity<List<User>> getemployee(){
		List<User> emp = service.getEmployee();
		return new ResponseEntity<>(emp,HttpStatus.OK);  
    }
	
	
	@GetMapping("/employee/{id}")
    public ResponseEntity<User> getemp(@PathVariable("id") Integer id){
		User emp = service.getEmployee(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
    }

	
	@PostMapping("/addEmp")
	public ResponseEntity<User> addEmp(@RequestBody User e){
        e.setPassword(service.encodePassword(e.getPassword()));
		User emp = service.saveEmployee(e);
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}	


	@PutMapping("/editEmp")
	public ResponseEntity<User> update(@RequestBody User e){
		User emp = service.saveEmployee(e);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}

	@DeleteMapping("/delEmp/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception{
        Authentication authentication = authenticationManager.authenticate
		(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
        	
        	JwtResponse resp = jwtutils.createJwtToken(authRequest);
        	//return jwtUt.createJwtToken(authRequest);
        	return new ResponseEntity<>(resp,HttpStatus.OK);
            //return jwtService.generateToken(authRequest.getUsername());
        } else {
        	throw new UsernameNotFoundException("User not found");
        }

    }
}



    // @GetMapping("/listEmployees")
    // public ResponseEntity<List<User>> listAll() {
    //         List <User>  employees = service.listAllEmployees();
    //         System.out.print("fghjkdfvgbhgvbhn"+employees);
    //         // return service.listAllEmployees();
    //         return new ResponseEntity<>(employees,HttpStatus.OK);
    // }

    // @DeleteMapping("/delete/{id}")
    // public  ResponseEntity<?> apiDeleteEmp(@PathVariable("id") Integer id) {
    //      service.deleteEmployee(id);   
    //      return new ResponseEntity<>(HttpStatus.OK);
    // }

    // @GetMapping("/EmployeeById/{id}")
    // public ResponseEntity <User>findById(@PathVariable("id") Integer id) {
    //     User  employee = service.getEmployee(id);
    //     return new ResponseEntity<>(employee,HttpStatus.OK);
    // }


    // @PostMapping("/authenticate")
    // public ResponseEntity<JwtResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception  {
    //      Authentication authentication = authenticationManager.authenticate(new 
    //         UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    //         if (authentication.isAuthenticated()) {
    //             JwtResponse response = jwtutils.createJwtToken(authRequest);
    //             return new ResponseEntity<>(response, HttpStatus.OK);
    //         } 
    //         else {
    //             throw new UsernameNotFoundException("none");
    //         }
    // }

            
    // @PutMapping("/update")
	// public ResponseEntity<User> update(@RequestBody User user){
	// 	User emp = service.saveEmployee(user);
	// 	return new ResponseEntity<>(emp,HttpStatus.OK);
	// }

    // //change
    // @PostMapping("/save")
    // public ResponseEntity<User> add(@RequestBody User emp, AuthRequest authRequest) {
    // 	emp.setPassword(service.encodePassword(emp.getPassword()));
    //     User updateEmployee = service.saveEmployee(emp);
    //     System.out.print(emp);
    //     return new ResponseEntity<>(updateEmployee,HttpStatus.OK);  
    // }
// }