package org.tsdes.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tsdes.backend.entity.User;

import javax.persistence.EntityManager;
import java.util.Collections;
/**
 * Adapted from https://github.com/arcuri82/testing_security_development_enterprise_systems/
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createUser(String userName, String password, String firstName,String SurName, String email) {
        String hashedPassword = passwordEncoder.encode(password);
        if (em.find(User.class, userName) != null)
            return false;
        User user = new User();
        user.setUsername(userName);
        user.setFirstname(firstName);
        user.setSurname(SurName);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRoles(Collections.singleton("USER"));
        user.setEnabled(true);
        em.persist(user);
        return true;
    }

    public User getUser(String userName){ return em.find(User.class, userName); }

}
