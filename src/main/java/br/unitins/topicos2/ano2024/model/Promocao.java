package br.unitins.topicos2.ano2024.model;

import java.time.YearMonth;

public class Promocao {
    
    private String id;
    private String nome; 
    private String  descricao;  
    private double valor;
    private YearMonth  dataInicio;

    public  Promocao() {

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public YearMonth getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(YearMonth dataInicio) {
        this.dataInicio = dataInicio;
    }

    
}
