package com.example.UltimatixEmployeesD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.UltimatixEmployeesD.entity.UEmployeeE;
import com.example.UltimatixEmployeesD.repository.UEmployeeR;

@Controller
public class UEmployeeController {
	
	@Autowired
	private UEmployeeR UlRepo;
	@GetMapping({"/showEmployees","/","list"})
	public ModelAndView showEmployees() {
		ModelAndView mnv = new ModelAndView("ultimatixEdata");
		List<UEmployeeE>list = UlRepo.findAll();
		mnv.addObject("employees",list);
		return mnv;
	}
	
}
