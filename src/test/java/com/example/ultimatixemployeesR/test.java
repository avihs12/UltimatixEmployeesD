package com.example.ultimatixemployeesR;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword ="sagar";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
	}
    
}
