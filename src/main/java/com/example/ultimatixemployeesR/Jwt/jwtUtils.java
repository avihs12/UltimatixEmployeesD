package com.example.ultimatixemployeesR.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.ultimatixemployeesR.repository.*;
import com.example.ultimatixemployeesR.auth.*;
import com.example.ultimatixemployeesR.entity.*;

@Service
public class jwtUtils implements UserDetailsService {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private EmployeeRepository repo;
	
	public JwtResponse createJwtToken(AuthRequest authRequest) throws Exception {
        String userName = authRequest.getUsername();
        String userPassword = authRequest.getPassword();
        String newGeneratedToken = jwtService.generateToken(authRequest.getUsername());

        User user = repo.getUserByUsername(userName);
        return new JwtResponse(user, newGeneratedToken);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.getUserByUsername(username);
		return null;
	// }
}
}