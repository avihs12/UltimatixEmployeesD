package com.example.UltimatixEmployeesD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UltimatixEmployeesD.entity.UEmployeeE;

@Repository
public interface UEmployeeR extends JpaRepository<UEmployeeE, Long> {

}
