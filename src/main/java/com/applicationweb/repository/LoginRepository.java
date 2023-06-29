package com.applicationweb.repository;

import com.applicationweb.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    Login findByEmailAndSenha(String email, String senha);

}
