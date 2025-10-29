package com.dogao.pedidos.infra.persistence.entity.embedabbles;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class ItemEmbeddable {

    private String nome;
    private BigDecimal precoUnitario;
    private int quantidade;

    public ItemEmbeddable() {
    }

    public ItemEmbeddable(String nome, BigDecimal precoUnitario, int quantidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

