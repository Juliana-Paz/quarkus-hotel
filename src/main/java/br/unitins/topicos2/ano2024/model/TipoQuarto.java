package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;

@Entity
public class TipoQuarto extends DefaultEntity {
    
    private String nome;

    public  TipoQuarto(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
