package com.example.ultimatixemployeesR;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Component;

import com.example.ultimatixemployeesR.entity.User;
import com.example.ultimatixemployeesR.repository.EmployeeRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("could not find user");
        }
        return new MyUserDetail(user);
    }
}   