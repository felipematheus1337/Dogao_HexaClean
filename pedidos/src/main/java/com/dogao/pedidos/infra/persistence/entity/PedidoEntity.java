package com.dogao.pedidos.infra.persistence.entity;

import com.dogao.pedidos.infra.persistence.entity.embedabbles.ClienteEmbeddable;
import com.dogao.pedidos.infra.persistence.entity.embedabbles.ItemEmbeddable;
import com.dogao.pedidos.infra.persistence.entity.enums.StatusPedidoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@TableGenerator(name = "pedido")
public class PedidoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "nome", column = @Column(name = "cliente_nome"))
    private ClienteEmbeddable cliente;

    @ElementCollection
    @CollectionTable(name = "pedido_itens", joinColumns = @JoinColumn(name = "pedido_id"))
    @AttributeOverride(name = "nome", column = @Column(name = "item_nome"))
    private List<ItemEmbeddable> itens;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEntity status;
    private LocalDateTime dataCriacao;

    public PedidoEntity() {
    }

    public PedidoEntity(Long id, ClienteEmbeddable cliente, List<ItemEmbeddable> itens, BigDecimal valorTotal, StatusPedidoEntity status, LocalDateTime dataCriacao) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEmbeddable getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEmbeddable cliente) {
        this.cliente = cliente;
    }

    public List<ItemEmbeddable> getItens() {
        return itens;
    }

    public void setItens(List<ItemEmbeddable> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedidoEntity getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEntity status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
