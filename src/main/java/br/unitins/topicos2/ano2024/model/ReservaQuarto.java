package br.unitins.topicos2.ano2024.model;

import java.time.LocalDate;

public class ReservaQuarto {
    
    private Quarto quarto;
    private String id;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private int qtdAdultos;
    private int qtdCriancas;

    public ReservaQuarto(){


    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getQtdAdultos() {
        return qtdAdultos;
    }

    public void setQtdAdultos(int qtdAdultos) {
        this.qtdAdultos = qtdAdultos;
    }

    public int getQtdCriancas() {
        return qtdCriancas;
    }

    public void setQtdCriancas(int qtdCriancas) {
        this.qtdCriancas = qtdCriancas;
    }

    
}
