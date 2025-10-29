package com.dogao.pedidos.application.usecases;

import com.dogao.pedidos.application.gateways.CancelarPedidoGateway;

public class CancelarPedidoUseCase {

    private final CancelarPedidoGateway gateway;

    public CancelarPedidoUseCase(CancelarPedidoGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(Long id) {
        gateway.cancelarPedido(id);
    }
}
