package br.unitins.topicos2.ano2024.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Amenidade extends DefaultEntity {
    
    private String nome;
    @ManyToOne
    private Quarto quarto;

    public  Amenidade(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
