package com.dogao.pedidos.application.usecases;


import com.dogao.pedidos.application.gateways.AtualizarPedidoStatusGateway;
import com.dogao.pedidos.domain.enums.StatusPedido;
import org.springframework.util.Assert;

public class AtualizarPedidoStatusUseCase  {

    private final AtualizarPedidoStatusGateway atualizarPedidoStatusGateway;

    public AtualizarPedidoStatusUseCase(AtualizarPedidoStatusGateway atualizarPedidoStatusGateway) {
        this.atualizarPedidoStatusGateway = atualizarPedidoStatusGateway;
    }

    public void atualizarPedido(Long pedidoId, StatusPedido statusPedido) {

        Assert.notNull(pedidoId, "Não pode atualizar para ENTREGUE se ainda não foi PAGO.");

        atualizarPedidoStatusGateway.atualizarPedido(pedidoId, statusPedido);
    }
}
