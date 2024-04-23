package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class TipoQuarto extends DefaultEntity {

    private String nome;
    @ManyToOne
    private Promocao promocao;
    @ManyToOne
    private CupomDesconto cupomDesconto;

    public TipoQuarto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
