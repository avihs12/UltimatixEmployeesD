package com.example.UltimatixEmployeesD;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
        .requestMatchers("/","/searchEmployee","/searchEmployeeAdmin").hasAnyAuthority("USER","ADMIN","CREATOR")
        .requestMatchers("/showEmployees").hasAnyAuthority("USER","ADMIN","CREATOR")
        .requestMatchers("/adminPage","/addEmployee","/searchEmployee").hasAnyAuthority( "CREATOR","ADMIN")
        .requestMatchers("/edited/save").hasAnyAuthority( "ADMIN")
        .requestMatchers("/showEmployees").hasAnyAuthority( "USER")
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











        
    //     http

    //     .csrf()
    //     .disable()
    //     .authorizeHttpRequests()
    //     .requestMatchers("/showEmployees/addEmployee/deleteEmployee/**").hasAnyAuthority("ADMIN")
    //     .requestMatchers("/employees/edit/**").hasAnyAuthority("ADMIN", "USER")
    //     .requestMatchers("/search").permitAll()
    //     .anyRequest().authenticated()
    //     .and()
    //     .logout().permitAll()
    //     .and()
    //     .formLogin()   
    //             .loginPage("/login")
    //             .permitAll()
    //             .and()
    //             .logout()                                        
    //             .permitAll();

    //     return http.build();
    // }
}