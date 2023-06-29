package com.applicationweb.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Instalar Lombok no Intellij
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Login {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_usuario;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String telefone;

  @Column(nullable = false, unique = true)
  private String senha;

  @Column
  private Date dataCadastro;

}
