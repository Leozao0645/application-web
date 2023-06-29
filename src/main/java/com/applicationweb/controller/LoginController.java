package com.applicationweb.controller;

import ch.qos.logback.classic.Logger;
import com.applicationweb.domain.Login;
import com.applicationweb.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @ResponseBody
    @GetMapping
    @RequestMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha) throws Exception {
        try {
            Login login = loginRepository.findByEmailAndSenha(email, senha);

            if (!email.isEmpty() && !senha.isEmpty()) {
                if (email.equalsIgnoreCase(login.getEmail()) && senha.equalsIgnoreCase(login.getSenha())) {
                    System.out.println("Login encontrado com sucesso.");
                    return "{\"status\": \"OK\"}";
                } else {
                    System.err.println("Email ou senha inválidos");
                    return "{\"status\": \"ERROR\"}";
                }
            } else {
                System.err.println("Email ou senha inválidos");
                return "{\"status\": \"ERROR\"}";
            }
        } catch (Exception e) {
            System.err.println("Erro ao consultar dados na base: " + e);
            return "{\"status\": \"ERROR\"}";
        }

    }

    @ResponseBody
    @GetMapping
    @RequestMapping("/listar_usuarios")
    public List<Login> listarUsuarios() throws Exception {
        List<Login> usuarios = loginRepository.findAll();
        return usuarios;
    }

    @PostMapping
    @RequestMapping("/cadastro")
    public Login inserirUsuario(@RequestBody Login dadosUsuario) {
        return loginRepository.save(dadosUsuario);

    }

    @ResponseBody
    @DeleteMapping
    @RequestMapping("/deletar_usuario")
    public String deletarUsuario(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        Login login = loginRepository.findByEmailAndSenha(email, senha);
        loginRepository.deleteById(login.getId_usuario());
        return "{\"status\": \"DELETADO\"}";

    }

}
