package com.example.ultimatixemployeesR.contoller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ultimatixemployeesR.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.example.ultimatixemployeesR.service.Employeeservice;
import com.example.ultimatixemployeesR.Jwt.JwtService;
import com.example.ultimatixemployeesR.auth.AuthRequest;



@RestController
public class EmployeeController{

    @Autowired
	private Employeeservice service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/listEmployees")
    public List<User> listAll() {
        try{
            List <User>  emp = service.listAllEmployees();
            System.out.print("fghjkdfvgbhgvbhn"+emp);
            return service.listAllEmployees();

        }
        catch(Exception e){
            List <User>  emp = service.listAllEmployees();
            System.out.print(emp);
            System.out.print(e);
            return service.listAllEmployees();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String apiDeleteEmp(@PathVariable("id") Integer id) {
        return service.deleteEmployee(id);   
    }

    @GetMapping("/EmployeeById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return service.getEmployee(id);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
         Authentication authentication = authenticationManager.authenticate(new 
            UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                return "No User found in DataBase";
            }
        }
            
    @PostMapping("/save")
    public String add(@RequestBody User emp, AuthRequest authRequest) {
    	emp.setPassword(service.encodePassword(emp.getPassword()));
        System.out.print(emp);
        System.out.print("dfghgytrdftvgyhu"+authRequest.getPassword());
        System.out.print("dfghgytrdftvgyhu"+authRequest.getUsername());
        return service.saveEmployee(emp);
    }
}