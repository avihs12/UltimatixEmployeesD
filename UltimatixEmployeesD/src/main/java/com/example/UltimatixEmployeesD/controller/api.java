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

// import com.example.UltimatixEmployeesD.entity.UEmployeeE;
// import com.example.UltimatixEmployeesD.service.apiservice;


// @RestController
// @RequestMapping("/api")
// public class api{
//     @Autowired
// 	private apiservice service;
//     @GetMapping("/listEmployees")
//     public List<UEmployeeE> listAll() {
//         return service.showEmployees();
//     }

//     @GetMapping("/EmployeeById/{sno}")
//     public UEmployeeE findById(@PathVariable("sno") Long sno) {
//         return service.getEmployeeById(sno);
//     }

//     @PostMapping("/save")
//     public UEmployeeE save(@RequestBody UEmployeeE emp) {
//         return service.saveEmployee(emp);
//     }

//     @DeleteMapping("/delete/{sno}")
//     public String apiDeleteEmp(@PathVariable Long sno) {
//         return service.apiDeleteEmp(sno);   
//     }

// }


