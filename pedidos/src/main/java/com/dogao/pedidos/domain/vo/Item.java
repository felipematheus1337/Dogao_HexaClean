package com.dogao.pedidos.domain.vo;

import java.math.BigDecimal;

public class Item {

    private final String nome;
    private final BigDecimal precoUnitario;
    private final int quantidade;


    public Item(String nome, BigDecimal precoUnitario, int quantidade) {
        if ((quantidade <= 0)) {throw new IllegalArgumentException("Quantidade deve ser positiva.");}
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
