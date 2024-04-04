package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;

@Entity
public class Quarto extends DefaultEntity {
    
    private String nome;
    private double valor;
    private String descricao;
    private boolean isDisponivel;
    private TipoQuarto tipoQuarto;
    private Amenidade amenidade;

    public Quarto (){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Amenidade getAmenidade() {
        return amenidade;
    }

    public void setAmenidade(Amenidade amenidade) {
        this.amenidade = amenidade;
    }

}
