package com.monish.Spring_Security_Demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //Firstly we need to disable CSRF to customize the security authentication
        httpSecurity.csrf(obj -> obj.disable());
        //Need to add authorization
        httpSecurity.authorizeHttpRequests(request -> request
                .requestMatchers("register", "login")
                .permitAll()
                .anyRequest().authenticated());
        //Currently going for default authorization
        httpSecurity.httpBasic(Customizer.withDefaults());
        //Making session as stateless so that every url req will have a different session
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.addFilter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        //Now we need to authenticate and every req will have different session id and put post and delete req does not require CSRF token
        return httpSecurity.build();
    }

    //Now lets create a user name and password ,In application properties we can only add one user
    //currently we are hard coding the username and password
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails1= User.withDefaultPasswordEncoder()
                .username("Virat")
                .password("Anushka")
                .roles("USER")
                .build();

        UserDetails userDetails2= User.withDefaultPasswordEncoder()
                .username("Admin")
                .password("Admin@789")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }
    //Now lets create a method for authentication of the username and password in the database
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
