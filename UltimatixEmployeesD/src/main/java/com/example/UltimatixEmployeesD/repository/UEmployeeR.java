package com.example.UltimatixEmployeesD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UltimatixEmployeesD.entity.UEmployeeE;

@Repository
public interface UEmployeeR extends JpaRepository<UEmployeeE, Long> {  
List<UEmployeeE> findByFirstnameContaining(String firstname);
}


