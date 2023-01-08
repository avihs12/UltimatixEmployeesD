package com.example.UltimatixEmployeesD.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.UltimatixEmployeesD.entity.UEmployeeE;

@Repository
public interface UEmployeeR extends CrudRepository<UEmployeeE, Long> {
}


