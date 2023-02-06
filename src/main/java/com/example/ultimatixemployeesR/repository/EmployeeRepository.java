package com.example.ultimatixemployeesR.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
import com.example.ultimatixemployeesR.entity.User;

public interface EmployeeRepository extends JpaRepository<User, Integer> {
    
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);


    // List<User> findByFirstnameContaining(String firstname);
}
