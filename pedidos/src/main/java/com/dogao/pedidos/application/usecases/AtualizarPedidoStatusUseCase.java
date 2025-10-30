package com.dogao.pedidos.application.usecases;


import com.dogao.pedidos.application.gateways.AtualizarPedidoStatusGateway;
import com.dogao.pedidos.domain.enums.StatusPedido;

public class AtualizarPedidoStatusUseCase  {

    private final AtualizarPedidoStatusGateway atualizarPedidoStatusGateway;

    public AtualizarPedidoStatusUseCase(AtualizarPedidoStatusGateway atualizarPedidoStatusGateway) {
        this.atualizarPedidoStatusGateway = atualizarPedidoStatusGateway;
    }

    public void atualizarPedido(Long pedidoId, StatusPedido statusPedido) {

        atualizarPedidoStatusGateway.atualizarPedido(pedidoId, statusPedido);
    }
}
