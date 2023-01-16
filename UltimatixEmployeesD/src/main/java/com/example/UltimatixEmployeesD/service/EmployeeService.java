package com.example.UltimatixEmployeesD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.UltimatixEmployeesD.entity.UEmployeeE;
import com.example.UltimatixEmployeesD.repository.UEmployeeR;

@Service
public class EmployeeService{
	@Autowired
	private UEmployeeR Ulrepo;

	public List<UEmployeeE> listAll(){
		Pageable paging = PageRequest.of(0, 6);
		return (List<UEmployeeE>) Ulrepo.findAll(paging).toList();
	}
	public UEmployeeE save(UEmployeeE emp){
			return Ulrepo.save(emp);
	}
	public void cancel(UEmployeeE emp){
		 Ulrepo.findAll();
	}
	public  UEmployeeE get(Long sno){
		return Ulrepo.findById(sno).get();
	}
	public void  delete(Long sno){
		 Ulrepo.deleteById(sno);
	}
	public List<UEmployeeE> search(String firstname){
		return Ulrepo.findByFirstnameContaining(firstname);
	   }
	public List<UEmployeeE> employeesPagination(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return Ulrepo.findAll(paging).toList();
	}
}