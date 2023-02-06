package com.example.UltimatixEmployeesD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.UltimatixEmployeesD.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService()
    {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/","showEmployees").hasAnyAuthority("USER","ADMIN","CREATOR","EDITOR")
        .requestMatchers("/adminPage","/employee/Add","/useradded/save","/editEmployee/","/edited/save").hasAnyAuthority( "ADMIN","CREATOR","EDITOR")
        .requestMatchers("/deleteEmployee/").hasAnyAuthority("ADMIN")
        .requestMatchers("/user/EmployeeSearch","/searchEmployee","/admin/EmployeeSearch").hasAnyAuthority( "CREATOR","ADMIN","EDITOR","USER")
        .requestMatchers("/EmployeesByPages/","/EmployeesByPagesAdmin/").hasAnyAuthority( "USER","EDITOR","CREATOR","ADMIN")
        .requestMatchers("/search").permitAll()
        .requestMatchers("/images/**").permitAll()
        .requestMatchers("/js/**").permitAll()
        .requestMatchers("/register/**").permitAll()
        .requestMatchers("/register").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()   
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()                                        
                .permitAll()
        .and()
        .logout().permitAll();


return http.build();
}
}