package br.unitins.topicos2.ano2024.model;

import java.time.YearMonth;

public class CupomDesconto {
    
    private String id;
    private String codigo;
    private String descricao;
    private double valor;
    private YearMonth dataValidade;

    public  CupomDesconto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public YearMonth getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(YearMonth dataValidade) {
        this.dataValidade = dataValidade;
    }

    
}
