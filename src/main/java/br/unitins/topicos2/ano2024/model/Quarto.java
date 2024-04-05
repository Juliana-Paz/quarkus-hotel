package br.unitins.topicos2.ano2024.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quarto extends DefaultEntity {

    private String nome;
    private double valor;
    private String descricao;
    private boolean isDisponivel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_quarto_id")
    private List<TipoQuarto> tipoQuarto = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quarto_id")
    private List<Amenidade> amenidade = new ArrayList<>();

    public Quarto() {

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

    public List<Amenidade> getAmenidade() {
        return amenidade;
    }

    public void setAmenidade(List<Amenidade> amenidade) {
        this.amenidade = amenidade;
    }

    public List<TipoQuarto> getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(List<TipoQuarto> tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

}
