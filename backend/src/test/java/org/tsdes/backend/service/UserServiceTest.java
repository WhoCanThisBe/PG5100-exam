package org.tsdes.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceTest extends ServiceTestBase {

    @Autowired
    private UserService userService;

    @Test
    public void test_create_user(){
        assertTrue(userService.createUser(
                "fooUser",
                "testpassword",
                "fooName",
                "fooSurname",
                "foo@mail.com"));
    }

}