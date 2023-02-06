// package com.example.UltimatixEmployeesD.controller;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import com.example.UltimatixEmployeesD.entity.User;
// import com.example.UltimatixEmployeesD.service.EmployeeService;
// import org.springframework.security.authentication.AuthenticationManager;
// import com.example.UltimatixEmployeesD.;




// @RestController
// @RequestMapping("/api")
// public class api{
    
//     @Autowired 
//     EmployeeService service;

//     @Autowired
//     private JwtService jwtService;

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     @GetMapping("/listEmployees")
//     public List<User> listAll() {
//         return service.showEmployees();
//     }

//     @GetMapping("/EmployeeById/{sno}")
//     public User findById(@PathVariable("sno") Long sno) {
//         return service.getEmployeeById(sno);
//     }

//     @PostMapping("/save")
//     public User save(@RequestBody User emp) {
//         return service.saveEmployee(emp);
//     }

//     @DeleteMapping("/delete/{sno}")
//     public String apiDeleteEmp(@PathVariable Long sno) {
//         return service.apiDeleteEmp(sno);   
//     }


// 	@PostMapping("/api/register")
// 	public User register(@RequestBody User emp) {
// 			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
// 			String rawPassword = emp.getPassword();
// 			String encodedPassword = encoder.encode(rawPassword);
// 			emp.setPassword(encodedPassword);
// 			System.out.print(emp);
// 			return service.saveEmployee(emp);
//     }
// }
