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
    private boolean isReservado;
    private boolean isAtivo;
    @JoinColumn(name = "id_tipoQuarto")
    @ManyToOne
    private TipoQuarto tipoQuarto;
    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Amenidade> amenidade = new ArrayList<>();

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

    public boolean isReservado() {
        return isReservado;
    }

    public void setReservado(boolean isReservado) {
        this.isReservado = isReservado;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public List<Amenidade> getAmenidade() {
        return amenidade;
    }

    public void setAmenidade(List<Amenidade> amenidade) {
        this.amenidade = amenidade;
    }

}
