package com.example.ingressosonline;

public class Usuario {
    private String id;
    private String Nome;
    private String CPF;
    private String Senha;
    private String NumeroCartao;
    private String CodigoCartao;
    private String ValidadeCartao;
    private String id_usuario;

    public Usuario(){

    }

    public Usuario(String id,String Nome,String CPF,String Senha, String NumeroCartao,String CodigoCartao, String ValidadeCartao, String id_usuario){
        this.id = id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.Senha = Senha;
        this.NumeroCartao = NumeroCartao;
        this.CodigoCartao = CodigoCartao;
        this.ValidadeCartao = ValidadeCartao;
        this.id_usuario = id_usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNumeroCartao() {
        return NumeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        NumeroCartao = numeroCartao;
    }

    public String getCodigoCartao() {
        return CodigoCartao;
    }

    public void setCodigoCartao(String codigoCartao) {
        CodigoCartao = codigoCartao;
    }

    public String getValidadeCartao() {
        return ValidadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        ValidadeCartao = validadeCartao;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
