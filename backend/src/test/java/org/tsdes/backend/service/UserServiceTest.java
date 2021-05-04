package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.tsdes.backend.entity.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceTest extends ServiceTestBase {

    @Autowired
    private UserService us;

    @Test
    public void test_create_user(){
        String userName = "fooUser";

        assertTrue(us.createUser(
                 userName,
                "testpassword",
                "fooName",
                "fooSurname","foo@mail.com"));
        
       String newMail = "change@mail.test";
       String changedValue = "changed value";
       User user = us.getUser(userName);

       assertEquals(userName,user.getUsername());

       user.setEmail(newMail);
       user.setFirstname(changedValue);
       user.setSurname(changedValue);
       user.setPassword(changedValue);

       assertEquals(newMail,user.getEmail());
       assertEquals(changedValue,user.getFirstname());
       assertEquals(changedValue,user.getSurname());
       assertEquals(changedValue,user.getPassword());

    }

}