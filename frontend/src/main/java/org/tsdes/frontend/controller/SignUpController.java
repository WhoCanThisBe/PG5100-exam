package org.tsdes.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.tsdes.backend.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * adapted from https://github.com/arcuri82/testing_security_development_enterprise_systems/
 */
@Named
@RequestScoped
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;

    public String signUpUser() {

        boolean registered = false;
        try{
            registered = userService.createUser(username, password, name, surname, email);
        }catch(Exception e){//
        }

        if(registered){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    password,
                    userDetails.getAuthorities());

            authenticationManager.authenticate(token);

            if(token.isAuthenticated())
                SecurityContextHolder.getContext().setAuthentication(token);

            return "/index.jsf?faces-redirect=true";
        }else return "/signup.jsf?faces-redirect=true&error=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
