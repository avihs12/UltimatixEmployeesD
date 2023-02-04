package com.example.UltimatixEmployeesD.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.UltimatixEmployeesD.entity.User;
import com.example.UltimatixEmployeesD.service.EmployeeService;
// import com.example.UltimatixEmployeesD.JwtTokenUtils;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;

@Controller
public class UEmployeeController {
	@Autowired
	private EmployeeService service;
	// @Autowired
	// private JwtTokenUtils jwtTokenUtil;
	//  @Autowired
    // private AuthenticationManager authenticationManager;

	Logger logger = LoggerFactory.getLogger(UEmployeeController.class);
	public String currentUser()
    {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        return loggedInUser.getName();
    }

	@GetMapping("/")
    public String viewUltimatixPage(){
		logger.info("ULTIMATIX HOME Page Accessed");
        return "ultimatix";
    }

	@GetMapping("/login")
    public String ViewAdminPage1() {
		logger.info("LOGGGED IN----- CUSTOMLOGIN Page-  Accessed");
        return "login";
    }

	
	@GetMapping("/register")
	public String addEmployeeEx(Model model) {
		model.addAttribute("employees", new User());
		logger.info("REGISTER  Page Accessed");
		return "register";
	}

	@RequestMapping(value ="/register/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employees") User user) {
		try{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String rawPassword = user.getPassword();
			String encodedPassword = encoder.encode(rawPassword);
			user.setPassword(encodedPassword);
			service.saveEmployee(user);
			logger.info("USER SUCCESSFULLY REGISTERED");
		}
		catch(Exception e){
			System.out.print(e);
			logger.info("USER NOT SUCCESSFULLY REGISTERED");
		}
		return "redirect:/login";
    }


	
	@GetMapping("/employee/Add")
	public String addEmployee(Model model) {
		User employee = new User();
        model.addAttribute("employees",employee);
		System.out.print(employee);
		logger.info("ADD PAGE Page Accessed");
		return "addemp";
	}

	@RequestMapping({"/adminPage","/admin/EmployeeSearch"})
	public String showAdminPage(Model model, String keyword) {
		if(keyword!=null){
			List<User> list1 = service.searchEmployee(keyword);
			logger.info("ADMIN Page Accessed AND SEARCHED USER ACCESSED");
			model.addAttribute("employees", list1);
		}
		else{
			List<User> list1 = service.listAllEmployees();
			model.addAttribute("employees", list1);
			logger.info(" LIST OF EMPLOYEES TABLE Accessed");
			model.addAttribute("error", "error message");
		}	
		return "Adminpage"; 
	}

	@RequestMapping({"/showEmployees" ,"/user/EmployeeSearch"})
	public String showEmployee(Model model, String keyword) {
		if(keyword!=null){
			List<User> list = service.searchEmployee(keyword);
			model.addAttribute("employees", list);
			logger.trace("SHOWED LIST OF EMPLOYEES");
		}
		else{
			List<User> list1 = service.listAllEmployees();
			model.addAttribute("employees", list1);
			model.addAttribute("User",currentUser());
			model.addAttribute("error", "error message");
		}	
		return "home"; 
	}


	@RequestMapping(value = "/useradded/save", method = RequestMethod.POST)
	public String saveEmp(@ModelAttribute("employees") User emp) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = emp.getPassword();
		String encodedPassword = encoder.encode(rawPassword);
		emp.setPassword(encodedPassword);
		System.out.print(emp);
		service.saveEmployee(emp);
		return "redirect:/adminPage";
	}

	@RequestMapping("/editEmployee/{id}")
	public ModelAndView showEditEmployepage(@PathVariable("id") Integer id, User serviceE) {
		try{
			ModelAndView mav = new ModelAndView("addemp");
			User emp = service.getEmployee(id);
			mav.addObject("employees", emp);	
			logger.info("EDIT Page Accessed FOR ADMIN");
			return mav;
		}
		catch(Exception e){
			System.out.print(e);
			ModelAndView mav = new ModelAndView("addemp");
			mav.addObject("error", e);	
			logger.info("NOT USER NOT EXIST");
			return mav;
		}
	}

	@RequestMapping(value = "/edited/save", method = RequestMethod.POST)
	public String saveUpdatedEmployee(@ModelAttribute("employees") User serviceE) {
		User emp = service.getEmployee(serviceE.getId());
		System.out.println(serviceE.getRoles());
		emp.setEmployeeid(serviceE.getEmployeeid());
		emp.setEmployeeid(serviceE.getId());
		System.out.print(serviceE.getId());
		emp.setFirstname(serviceE.getFirstname());
		emp.setLastname(serviceE.getLastname());
		emp.setSalary(serviceE.getSalary());
		emp.setSalaryhike(serviceE.getSalaryhike());
		emp.setRoles(serviceE.getRoles());
		service.updateEmployee(emp);
		System.out.print(emp);
		logger.info("SAVED USER EDITED DETAILS FOR ADMIN");
		return "redirect:/adminPage";
    }
 
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		service.deleteEmployee(id);
		logger.info("USER DELETED SUCCESSFULLY");
		return "redirect:/adminPage";
	}
	
	@RequestMapping({ "/EmployeesByPages/{page}/{size}" })
	public String paginatedEmployees(@PathVariable("page") int page, @PathVariable("size") int size, Model model) {
		List<User> list1 = service.employeesPagination(page,size);
		model.addAttribute("employees", list1);
		model.addAttribute("page", page);
		return "home";
	}

	@RequestMapping({"/EmployeesByPagesAdmin/{page}/{size}" })
	public String paginatedEmployeesAdmin(@PathVariable("page") int page, @PathVariable("size") int size, Model model) {
		List<User> list1 = service.employeesPagination(page,size);
		model.addAttribute("employees", list1);
		model.addAttribute("page", page);
		return "adminPage";
	}

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }

	@PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody MyUserDetails authRequest) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	final String token = jwtTokenUtil.generateToken(authRequest);
		return ResponseEntity.ok(new JwtResponse(token));
	 }

}