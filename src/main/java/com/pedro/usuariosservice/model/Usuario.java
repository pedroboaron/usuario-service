package com.pedro.usuariosservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "O email é obrigatório para o cadastro do usuario")
    private String email;

    @Column(name = "senha", nullable = false)
    @NotNull(message = "A senha é obrigatória para o cadastro do usuario")
    private String senha;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O nome é obrigatório para o cadastro do cartão")
    private String nome;

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    @NotBlank(message = "É obrigatório informar o cpf ou cnpj relacionado ao cartão")
    private String cpfCnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

}
