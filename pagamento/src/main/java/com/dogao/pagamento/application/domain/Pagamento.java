package com.dogao.pagamento.application.domain;

import com.dogao.pagamento.application.domain.enums.StatusPagamento;
import com.dogao.pagamento.application.domain.vo.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pagamento {
    private final UUID id;
    private final UUID pedidoId;
    private BigDecimal valor;
    private StatusPagamento status;
    private Transacao transacao;
    private LocalDateTime dataCriacao;

    public Pagamento(UUID pedidoId, BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.status = StatusPagamento.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
    }

    public void aprovar(Transacao transacao) {
        this.status = StatusPagamento.APROVADO;
        this.transacao = transacao;
    }

    public void rejeitar(Transacao transacao) {
        this.status = StatusPagamento.REJEITADO;
        this.transacao = transacao;
    }

    public UUID getId() {
        return id;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
