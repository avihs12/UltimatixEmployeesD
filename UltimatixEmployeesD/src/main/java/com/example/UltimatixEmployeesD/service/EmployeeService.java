package com.example.UltimatixEmployeesD.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.UltimatixEmployeesD.entity.User;
import com.example.UltimatixEmployeesD.repository.UserRepository;
import com.example.UltimatixEmployeesD.service.exceptions.NoSuchCustomerExistsException;
@Service
public class EmployeeService{
	@Autowired
	private UserRepository users;
	
	public List<User> listAllEmployees(){
		Pageable paging = PageRequest.of(0, 6);
		return (List<User>) users.findAll(paging).toList();
	}

	public User saveEmployee(User emp){
			return users.save(emp);
	}

	public User updateEmployee(User emp){
		return users.save(emp);
	}

	public void cancel(User emp){
		users.findAll();
	}
	public User getEmployee(Integer userid){
		return users.findById(userid).orElseThrow(
            ()-> new NoSuchCustomerExistsException("NO CUSTOMER PRESENT WITH ID = " + userid)
		);			
	}

	public String  deleteEmployee(Integer userid){
		users.deleteById(userid);
		return "deleted";
	}
	public List<User> searchEmployee(String firstname){
		return users.findByFirstnameContaining(firstname);
	   }

	   public List<User> employeesPagination(int page, int size) {
        Pageable paging = PageRequest.of(page,size);
        return users.findAll(paging).toList();
	}




	// public void cancel(UEmployeeE emp){
	// 	 Ulrepo.findAll();
	// }
	// public  UEmployeeE get(Long sno){
	// 	return Ulrepo.findById(sno).get();
	// }
	// public void  delete(Long sno){
	// 	 Ulrepo.deleteById(sno);
	// }
	// public List<UEmployeeE> search(String firstname){
	// 	return Ulrepo.findByFirstnameContaining(firstname);
	//    }
	// public List<UEmployeeE> employeesPagination(int page, int size) {
    //     Pageable paging = PageRequest.of(page, size);
    //     return Ulrepo.findAll(paging).toList();
	// }


	// public List<UEmployeeE> listAll(){
	// 	Pageable paging = PageRequest.of(0, 6);
	// 	return (List<UEmployeeE>) Ulrepo.findAll(paging).toList();
	// }
	
	// public UEmployeeE save(User emp){
	// 	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	// 	String rawPassword = emp.getPassword();
	// 	String encodedPassword = encoder.encode(rawPassword);
	// 	emp.setPassword(encodedPassword);
	// 	return User.save(user);
	// }
	// public void cancel(UEmployeeE emp){
	// 	 Ulrepo.findAll();
	// }
	// public  UEmployeeE get(Long sno){
	// 		return Ulrepo.findById(sno).get();
	// }
	// public void  delete(Long sno){
	// 	 Ulrepo.deleteById(sno);
	// }
	// public List<UEmployeeE> search(String firstname){
	// 	return Ulrepo.findByFirstnameContaining(firstname);
	//    }
	// public List<UEmployeeE> employeesPagination(int page, int size) {
    //     Pageable paging = PageRequest.of(page, size);
    //     return Ulrepo.findAll(paging).toList();
	// }
}