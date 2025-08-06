package com.example.Spring_security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class Security_Config {
    //Handeling who has access to which url
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //Disabling CSRF token to access all the postmapping
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home","/register/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                //enabling login page to login
                .formLogin(formLogin -> formLogin
                                        //Once the login is success we are redirecting to specific url
                                        .successHandler(new AuthenticationSuccessHandler())
                                        .permitAll())
                .build();
    }

//Creating a Dynamic users and assigning roles
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails normalUser = User.builder()
//                .username("Monish")
//                //used online bcrypt encoder to encode the password (1234)
//                .password("$2a$12$rDQu0LpNHwlwi7LrkCGIse4nsNhjnzo0dZNCdex3tzJ364IHCB0Eu")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("Admin")
//                //used online bcrypt encoder to encode the password (9876)
//                .password("$2a$12$iFskBsSKk4RQB7NiLbWKOu1oT1Ihwby5ROffL18eMXr2JtmurYob6")
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin,normalUser);
//    }

    //Accessing MyUserDetailsService to access user from DB
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Bean
    public UserDetailsService userDetailsService(){
        return myUserDetailsService;
    }

    //Creating an Authentication class for myUserDetailsService class
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    //Creating a password encoder class
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
