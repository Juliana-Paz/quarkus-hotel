package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;

public class Pagamento extends DefaultEntity {
    
    private CartaoCredito cartaoCredito;

    public  Pagamento() {}
    
    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
}
