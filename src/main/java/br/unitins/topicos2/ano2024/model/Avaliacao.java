package br.unitins.topicos2.ano2024.model;
import jakarta.persistence.Entity;

public class Avaliacao extends DefaultEntity {

    private String titulo;
    private String descricao;
    private String rate;
    private boolean divulgacao;

    public Avaliacao() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public boolean isDivulgacao() {
        return divulgacao;
    }

    public void setDivulgacao(boolean divulgacao) {
        this.divulgacao = divulgacao;
    }

}
