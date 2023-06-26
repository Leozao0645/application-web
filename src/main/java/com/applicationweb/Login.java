package com.applicationweb.domain;

@Data //Instalar Lombok no Intellij
@NoArgsConstructor
@AllArgsConstructor
public class Login {

  private String nome;

  private String email;

  private String telefone;

  private String senha;
}
