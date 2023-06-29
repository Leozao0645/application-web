package com.applicationweb.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class LoginTests {

    @Test
    public void criar() {
        Login login1 = new Login(1,"Leo","leonardo@gmail.com","11994963084","test@123",new Date());
    }

}
