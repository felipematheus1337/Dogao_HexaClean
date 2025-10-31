package com.dogao.pagamento.adapters.out.repository;

import com.dogao.pagamento.adapters.out.repository.enums.StatusPagamentoEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "pagamento")
public class PagamentoEntity {

    @Id
    private String id;

    private Long pedidoId;

    private BigDecimal valorTotal;

    private StatusPagamentoEntity status;

    private LocalDateTime dataCriacao;

    public PagamentoEntity() {
    }

    public PagamentoEntity(String id, Long pedidoId, BigDecimal valorTotal, StatusPagamentoEntity status, LocalDateTime dataCriacao) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPagamentoEntity getStatus() {
        return status;
    }

    public void setStatus(StatusPagamentoEntity status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
