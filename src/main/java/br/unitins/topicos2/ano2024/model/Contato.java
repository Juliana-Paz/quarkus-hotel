package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Contato extends DefaultEntity {

    private String telefone;
    @ManyToOne
    private Usuario usuario;

    public Contato() {

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
