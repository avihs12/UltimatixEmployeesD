// package com.example.ultimatixemployeesR.contoller;


// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.ultimatixemployeesR.entity.User;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.ui.Model;
// import com.example.ultimatixemployeesR.service.Employeeservice;
// import com.example.ultimatixemployeesR.Jwt.JwtService;
// import com.example.ultimatixemployeesR.auth.AuthRequest;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;





// @RestController 
// @RequestMapping("/employee")
// public class EmployeeController{

//     @Autowired
// 	private Employeeservice service;

//     @Autowired
//     private JwtService jwtService;

//     @Autowired
//     private AuthenticationManager authenticationManager;


//     @GetMapping("/all")
//     public ResponseEntity<List<User>> listAll() {
//             List <User>  employees = service.listAllEmployees();
//             System.out.print("fghjkdfvgbhgvbhn"+employees);
//             return new ResponseEntity<>(employees,HttpStatus.OK);
//     }


//     // @PostMapping("/employee/{id}")
// 	// public  User showEditEmployepage(@PathVariable("id") Integer id, User user) {
//     //     try{
//     //         User existingUser = service.getEmployee(user.getId());
//     //         existingUser.setUsername(user.getUsername());
//     //         System.out.print("cfvgbfgvbhvgbhjnbhnjkm"+user);
//     //         existingUser.setFirstname(user.getFirstname());
//     //         existingUser.setLastname(user.getLastname());
//     //         existingUser.setPassword(user.getPassword());
//     //         existingUser.setEmployeeid(user.getEmployeeid());
//     //         existingUser.setRole(user.getRole());
//     //         existingUser.setSalary(user.getSalary());
//     //         existingUser.setSalaryhike(user.getSalaryhike());
//     //         User updatedUser = service.updateEmployee(existingUser);
//     //         return updatedUser;
//     //     }
//     //     catch(Exception e){
//     //        System.out.println(e);
//     //        User existingUser = service.getEmployee(user.getId());
//     //        existingUser.setUsername(user.getUsername());
//     //        existingUser.setFirstname(user.getFirstname());
//     //        existingUser.setLastname(user.getLastname());
//     //        existingUser.setPassword(user.getPassword());
//     //        existingUser.setRole(user.getRole());
//     //        existingUser.setSalary(user.getSalary());
//     //        existingUser.setSalaryhike(user.getSalaryhike());
//     //        User updatedUser = service.updateEmployee(existingUser);
//     //        return updatedUser;
//     //     }
      
//     // }

//     // @DeleteMapping("/employee/{id}")
//     // public String apiDeleteEmp(@PathVariable("id") Integer id) {
//     //     return service.deleteEmployee(id);   
//     // }

//     // @GetMapping("/employee/{id}")
//     // public User findById(@PathVariable("id") Integer id) {
//     //     return service.getEmployee(id);
//     // }

//     @PostMapping("/authenticate")
//     public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//          Authentication authentication = authenticationManager.authenticate(new 
//             UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//             if (authentication.isAuthenticated()) {
//                 String a =  "{" + "token"+":"  +jwtService.generateToken(authRequest.getUsername())+  "}";
//                 return a;
//             }
//               else {
//                 return "No User found in DataBase";
//             }
//     }
            
//     @PutMapping("/update")
//     public ResponseEntity<User> updateEmployee(@RequestBody User employee, AuthRequest authRequest) {
//         try{
//         User updateEmployee = service.saveEmployee(employee);
//         System.out.print("swdfdedeegew"+updateEmployee);
//     	employee.setPassword(service.encodePassword(employee.getPassword())); 
//         service.saveEmployee(employee);
//         return new ResponseEntity<>(updateEmployee,HttpStatus.OK);  
//         }
//         catch(Exception e){
//             System.out.print(e);
//             User updateEmployee = service.saveEmployee(employee);
//             System.out.print("swdfdedeegew"+updateEmployee);
//             employee.setPassword(service.encodePassword(employee.getPassword())); 
//             service.saveEmployee(employee);
//             return new ResponseEntity<>(updateEmployee,HttpStatus.OK);  
//         }
        
//     }

// } 