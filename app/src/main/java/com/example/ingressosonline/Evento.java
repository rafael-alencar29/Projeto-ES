package com.example.ingressosonline;

public class Evento {

    private String id;
    private String idUser;
    private String nome;
    private String codigoEvento;
    private String codigoApresentacao;
    private String data;
    private String horario;
    private String preco;
    private String codigoSala;
    private String cidade;
    private String Estado;

    private String classe;                 //categoria: Teatro, cinema, Show nacional,Show internacional
    private String faixa_etaria;

    public Evento(){

    }

    public Evento(String id, String idUser, String nome, String codigoEvento, String codigoApresentacao,
                  String data, String horario, String preco, String codigoSala, String cidade, String estado,
                  String classe, String faixa_etaria) {
        this.id = id;
        this.idUser = idUser;
        this.nome = nome;
        this.codigoEvento = codigoEvento;
        this.codigoApresentacao = codigoApresentacao;
        this.data = data;
        this.horario = horario;
        this.preco = preco;
        this.codigoSala = codigoSala;
        this.cidade = cidade;
        this.Estado = estado;
        this.classe = classe;
        this.faixa_etaria = faixa_etaria;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getCodigoApresentacao() {
        return codigoApresentacao;
    }

    public void setCodigoApresentacao(String codigoApresentacao) {
        this.codigoApresentacao = codigoApresentacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(String codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }
}

