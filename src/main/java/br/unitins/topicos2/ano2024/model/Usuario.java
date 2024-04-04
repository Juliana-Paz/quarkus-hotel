package br.unitins.topicos2.ano2024.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity {

    private String nome;
    private String sobrenome;
    private String senha;
    private LocalDate dataNascimento;
    private String endereco;
    private String cpf;
    private Mensagem mensagem;    
    private Avaliacao avaliacao;
    private CartaoCredito cartaoCredito;
    private Reserva reserva;
    private Contato contato;
    private Perfil perfil;
    
    
    public Usuario() {
        
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
    
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }
    
    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
    public Reserva getReserva() {
        return reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    public Contato getContato() {
        return contato;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public Perfil getPerfil() {
        return perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public Mensagem getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

}
