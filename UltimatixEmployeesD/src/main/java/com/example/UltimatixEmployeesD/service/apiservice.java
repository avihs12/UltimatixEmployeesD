package com.example.UltimatixEmployeesD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.UltimatixEmployeesD.entity.UEmployeeE;
import com.example.UltimatixEmployeesD.repository.UEmployeeR;

@Service
public class apiservice{
	@Autowired
	private UEmployeeR Ulrepo;

 	public UEmployeeE saveEmployee(UEmployeeE emp) {
         return Ulrepo.save(emp);
    }

     public List<UEmployeeE> showEmployees() {
         return Ulrepo.findAll();
     }

     public UEmployeeE getEmployeeById(Long sno) {
         return Ulrepo.findById(sno).get();
    }

    public String apiDeleteEmp(Long sno) {
        Ulrepo.deleteById(sno);
        return "Employee removed !! " + sno;
	}
    
}

//     public UEmployeeE updateEmployee(UEmployeeE emp) {
//         UEmployeeE existEmployee = Ulrepo.findById(emp.getId()).orElse(null);
//         existEmployee.setName(Ulrepo.getName());
//         existEmployee.setQuantity(Ulrepo.getQuantity());
//         existEmployee.setPrice(Ulrepo.getPrice());
//         return Ulrepo.save(existEmployee);
//     }













// }
