package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;


public class Reserva extends DefaultEntity {
    
    private double valor;
    private ReservaQuarto reservaQuarto;
    private Pagamento pagamento;
    
    public Reserva(){
        
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public ReservaQuarto getReservaQuarto() {
        return reservaQuarto;
    }
    
    public void setReservaQuarto(ReservaQuarto reservaQuarto) {
        this.reservaQuarto = reservaQuarto;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }
    
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
}
