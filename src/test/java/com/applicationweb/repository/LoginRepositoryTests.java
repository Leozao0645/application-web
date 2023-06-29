package com.applicationweb.repository;

import com.applicationweb.domain.Login;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class LoginRepositoryTests {

    @Autowired
    private LoginRepository loginRepository;

    @Test
    public void inserir() {
        Login login1 = new Login(null,"teste","teste@gmail.com","11912543264","test@123",new Date());

        loginRepository.save(login1);

    }

    @Test
    public void buscar() {
        Login login = loginRepository.findByEmailAndSenha("leonardodesouza0645@gmail.com", "58163614l");

        System.out.println(login.toString());

    }

}
