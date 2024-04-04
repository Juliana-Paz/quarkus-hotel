package br.unitins.topicos2.ano2024.model;
import jakarta.persistence.Entity;

@Entity
public class Contato extends DefaultEntity {
    
    private String telefone;
    
    public Contato() {

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
