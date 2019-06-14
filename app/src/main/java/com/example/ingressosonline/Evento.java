package com.example.ingressosonline;

public class Evento {

    private String nome;
    private String codigo;
    private String data;
    private String horario;
    private double preco;
    private int quant_ingressos;
    private String classe;                 //categoria: Teatro, cinema, Show nacional,Show internacional
    private String faixa_etaria;

    public Evento(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuant_ingressos() {
        return quant_ingressos;
    }

    public void setQuant_ingressos(int quant_ingressos) {
        this.quant_ingressos = quant_ingressos;
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

