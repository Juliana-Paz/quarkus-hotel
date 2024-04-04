package br.unitins.topicos2.ano2024.model;

import java.time.YearMonth;
import jakarta.persistence.Entity;

@Entity
public class Promocao extends DefaultEntity {
    
    private String nome; 
    private String descricao;  
    private double valor;
    private YearMonth dataInicio;
    private YearMonth dataFim;

    public  Promocao() {

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

    public YearMonth getDataFim() {
        return dataFim;
    }

    public void setDataFim(YearMonth dataFim) {
        this.dataFim = dataFim;
    }

    
}
