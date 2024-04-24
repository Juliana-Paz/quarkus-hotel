package br.unitins.topicos2.ano2024.model;

import java.time.YearMonth;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Promocao extends DefaultEntity {

    private String nome;
    private String descricao;
    private double valor;
    private YearMonth dataInicio;
    private YearMonth dataFim;
    @JoinColumn(name = "id_tipoQuarto")
    @ManyToOne
    private TipoQuarto tipoQuarto;

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

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

}
