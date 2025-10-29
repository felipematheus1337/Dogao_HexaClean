package com.dogao.pedidos.application.usecases;

import com.dogao.pedidos.application.gateways.CriarPedidoGateway;
import com.dogao.pedidos.domain.Pedido;

public class CriarPedidoUseCase {

    private final CriarPedidoGateway gateway;

    public CriarPedidoUseCase(CriarPedidoGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(Pedido pedido) {

        gateway.criarPedido(pedido);

    }
}
