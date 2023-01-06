package com.example.UltimatixEmployeesD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UltimatixEmployeesD.entity.UEmployeeE;
import com.example.UltimatixEmployeesD.repository.UEmployeeR;

@Service
public class EmployeeService {
	@Autowired
	private UEmployeeR Ulrepo;

	public List<UEmployeeE> listAll(){
		return (List<UEmployeeE>) Ulrepo.findAll();
	}
	public void save(UEmployeeE emp){
		 Ulrepo.save(emp);
	}
	public  UEmployeeE get(Long sno){

		return Ulrepo.findById(sno).get();
	}
	public void  delete(Long sno){
		 Ulrepo.deleteById(sno);
	}
	
}
