package com.example.UltimatixEmployeesD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@RequestMapping({ "/searchusers", "/showEmployees" })
	public String searchUsers(Model model, String keyword) {
		if (keyword != null) {
			List<UEmployeeE> list = service.search(keyword);
			model.addAttribute("employees", list);
			System.out.println(list);
		} else {
			List<UEmployeeE> list1 = service.listAll();
			model.addAttribute("employees", list1);
		}
		return "home";

	}

	@GetMapping("/addemp")
	public String add(Model model) {
		model.addAttribute("employees", new UEmployeeE());
		return "addemp";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmp(@ModelAttribute("employees") UEmployeeE emp) {
		System.out.print(emp);
		service.save(emp);
		return "redirect:/showEmployees";
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String cancelEmp(@ModelAttribute("employees") UEmployeeE emp) {
		service.listAll();
		return "redirect:/showEmployees";
	}

	@RequestMapping("/edit/{sno}")
	public ModelAndView showEdityEmployepage(@PathVariable("sno") Long sno) {
		ModelAndView mav = new ModelAndView("addemp");
		UEmployeeE emp = service.get(sno);
		mav.addObject("employees", emp);
		System.out.println(emp);
		return mav;
	}

	@RequestMapping("/delete/{sno}")
	public String deletestudent(@PathVariable("sno") Long sno) {
		service.delete(sno);
		return "redirect:/showEmployees";
	}

	@RequestMapping({ "/getPaginatedUsers/{page}/{size}" })
	public String paginatedUser(@PathVariable("page") int page, @PathVariable("size") int size, Model model) {
		List<UEmployeeE> list1 = service.employeesPagination(page, size);
		model.addAttribute("employees", list1);
		model.addAttribute("page", page);
		return "home";
	}

	// @GetMapping("/page/{pageno}")
	// public String findPaginated(@PathVariable int pageno, Model m) {
	// 	Page<UEmployeeE> emplist = service.getEMpByPaginate(pageno, 2);
	// 	m.addAttribute("employees", emplist);
	// 	m.addAttribute("currentPage", pageno);
	// 	m.addAttribute("totalPages", emplist.getTotalPages());
	// 	m.addAttribute("totalItem", emplist.getTotalElements());
	// 	return "home";
	// }


	// @GetMapping("/search")
    // public String search(String keyword, Model model) {
    //     return searchByPage(keyword, model, 1);
    // }

	// @GetMapping("/search/page/{pageNum}")	
    // public String searchByPage(String keyword, Model model,
    //                     @PathVariable(name = "pageNum") int pageNum) {
             
    //     Page<UEmployeeE> result = service.search(keyword, pageNum);
         
    //     List<UEmployeeE> listResult = result.getContent();
         
    //     model.addAttribute("totalPages", result.getTotalPages());
    //     model.addAttribute("totalItems", result.getTotalElements());
    //     model.addAttribute("currentPage", pageNum);
         
    //     long startCount = (pageNum - 1) * service.SEARCH_RESULT_PER_PAGE + 1;
    //     model.addAttribute("startCount", startCount);
         
    //     long endCount = startCount + service.SEARCH_RESULT_PER_PAGE - 1;
    //     if (endCount > result.getTotalElements()) {
    //         endCount = result.getTotalElements();
    //     }
         
    //     model.addAttribute("endCount", endCount);      
    //     model.addAttribute("listResult", listResult);
    //     model.addAttribute("keyword", keyword);    
         
    //     return "search_result";    
    // }
}
