package org.tsdes.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
/**
 * Primarily adapted from https://github.com/arcuri82/testing_security_development_enterprise_systems/
 *
 * https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/validation.html
 */
@Entity
@Table(name="USERS")
public class User {
    @Id
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 1, max = 64)
    private String name;

    @NotBlank
    @Size(min = 1, max = 64)
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    @NotNull
    private Boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
