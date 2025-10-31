package com.dogao.pagamento.application.domain;

import com.dogao.pagamento.application.domain.enums.StatusPagamento;
import com.dogao.pagamento.application.domain.vo.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pagamento {
    private final UUID id;
    private final Long pedidoId;
    private BigDecimal valor;
    private StatusPagamento status;
    private Transacao transacao;
    private LocalDateTime dataCriacao;

    public Pagamento(Long pedidoId, BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.status = StatusPagamento.PENDENTE;
        this.dataCriacao = LocalDateTime.now();

    }

    public void aprovar(Transacao transacao) {
        if (transacao == null) throw new RuntimeException("Transação não aprovada");
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

    public Long getPedidoId() {
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

    private void validarValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) throw new RuntimeException("Valor não pode ser menor ou igual a zero.");
    }

    public void validar(BigDecimal valor) {
        validarValor(valor);
        if (status == StatusPagamento.REJEITADO) throw new RuntimeException("Pagamento REJEITADO.");

    }
}
