package br.unitins.topicos2.ano2024.model;

import java.time.YearMonth;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class CupomDesconto extends DefaultEntity {
    
    private String codigo;
    private String descricao;
    private double valor;
    private YearMonth dataValidade;
    @OneToMany
    private TipoQuarto tipoQuarto;

    public  CupomDesconto() {

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
