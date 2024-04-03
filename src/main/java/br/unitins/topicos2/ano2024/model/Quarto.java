package br.unitins.topicos2.ano2024.model;

public class Quarto {
    
    private String id;
    private String  nome;
    private double valor;
    private String descricao;
    private boolean isDisponivel;

    public Quarto (){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    
}
