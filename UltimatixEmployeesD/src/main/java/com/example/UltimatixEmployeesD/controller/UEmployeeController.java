package com.example.UltimatixEmployeesD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.UltimatixEmployeesD.entity.UEmployeeE;
import com.example.UltimatixEmployeesD.service.EmployeeService;

@Controller
public class UEmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String viewUltimatixPage () {
		return "ultimatix";
	}		

	@GetMapping({"/showEmployees","/list"})
	public String viewHomepage (Model model) {
		List<UEmployeeE>list = service.listAll();
		model.addAttribute("employees", list);
		return "home";
	}		
	
	@GetMapping("/addemp")
	public String add(Model model) {
		model.addAttribute("employees", new UEmployeeE());
		return "addemp";
	}	

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("employees") UEmployeeE emp) {
		service.save(emp);
		return "redirect:/showEmployees";
	}
	

	@RequestMapping("/edit/{sno}")
	public ModelAndView showEdityEmployepage(@PathVariable("sno") Long sno){
		ModelAndView mav = new ModelAndView("addemp");
		UEmployeeE emp = service.get(sno);
		mav.addObject("employees", emp);
		System.out.println(emp);
		return mav;
	}

	@RequestMapping("/delete/{sno}")
	public String deletestudent(@PathVariable("sno") Long sno){
		service.delete(sno);
		return "redirect:/showEmployees";
	}

}
