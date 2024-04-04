package br.unitins.topicos2.ano2024.model;

import java.time.YearMonth;
import jakarta.persistence.Entity;


public class CartaoCredito extends DefaultEntity {
    
    private String  titular;
    private YearMonth validade;
    private String numeroCartao;
    private String codigoVerificacao;

    public CartaoCredito(){

    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public YearMonth getValidade() {
        return validade;
    }

    public void setValidade(YearMonth validade) {
        this.validade = validade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public void setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
    }

    
}
