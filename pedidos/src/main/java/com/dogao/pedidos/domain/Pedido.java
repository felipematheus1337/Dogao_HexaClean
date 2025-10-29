package com.dogao.pedidos.domain;

import com.dogao.pedidos.domain.enums.StatusPedido;
import com.dogao.pedidos.domain.vo.Cliente;
import com.dogao.pedidos.domain.vo.Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private Long id;
    private final Cliente cliente;
    private final List<Item> itens;
    private BigDecimal valorTotal;
    private StatusPedido status;
    private LocalDateTime dataCriacao;


    public Pedido(Long id, Cliente cliente, List<Item> itens) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = calcularValorTotal();
        this.status = StatusPedido.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
    }

    private BigDecimal calcularValorTotal() {
        return itens.stream()
                .map(Item::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void aprovar() {
        if (this.status != StatusPedido.PENDENTE)
            throw new IllegalStateException("Pedido não pode ser aprovado neste estado.");
        this.status = StatusPedido.APROVADO;
    }

    public void rejeitar() {
        if (this.status != StatusPedido.PENDENTE)
            throw new IllegalStateException("Pedido não pode ser rejeitado neste estado.");
        this.status = StatusPedido.REJEITADO;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
