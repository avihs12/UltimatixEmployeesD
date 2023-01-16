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
@RequestMapping("/")
public class UEmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping
	public String viewUltimatixPage() {
		return "ultimatix";
	}

	@RequestMapping({ "/searchEmployee", "/showEmployees" , "/returnToHome"})
	public String searcEmployee(Model model, String keyword) {
		if (keyword != null) {
			List<UEmployeeE> list = service.search(keyword);
			model.addAttribute("employees", list);
		} else {
			List<UEmployeeE> list1 = service.listAll();
			model.addAttribute("employees", list1);
		}
		return "home";
	}	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employees", new UEmployeeE());
		return "addemp";
	}
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employees") UEmployeeE emp) {
		System.out.print(emp);
		service.save(emp);
		return "redirect:/showEmployees";
	}

	@RequestMapping("/editEmployee/{sno}")
	public ModelAndView showEditEmployepage(@PathVariable("sno") Long sno) {
		ModelAndView mav = new ModelAndView("addemp");
		UEmployeeE emp = service.get(sno);
		mav.addObject("employees", emp);
		System.out.println(emp);
		return mav;
	}
	@RequestMapping("/deleteEmployee/{sno}")

	public String deleteEmployee(@PathVariable("sno") Long sno) {
		service.delete(sno);
		return "redirect:/showEmployees";
	}
	@RequestMapping({ "/EmployeesByPages/{page}/{size}" })
	public String paginatedEmployees(@PathVariable("page") int page, @PathVariable("size") int size, Model model) {
		List<UEmployeeE> list1 = service.employeesPagination(page, size);
		model.addAttribute("employees", list1);
		model.addAttribute("page", page);
		return "home";
	}
}