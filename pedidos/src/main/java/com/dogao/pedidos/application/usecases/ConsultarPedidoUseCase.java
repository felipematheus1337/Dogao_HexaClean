package com.dogao.pedidos.application.usecases;

import com.dogao.pedidos.application.exception.BusinessException;
import com.dogao.pedidos.application.gateways.ConsultarPedidoGateway;
import com.dogao.pedidos.domain.Pedido;

import java.util.Optional;

public class ConsultarPedidoUseCase {

    private final ConsultarPedidoGateway gateway;

    public ConsultarPedidoUseCase(ConsultarPedidoGateway gateway) {
        this.gateway = gateway;
    }

    public Pedido consultarPedido(Long id) {
        Optional<Pedido> pedido =  gateway.consultarPedido(id);
        if(pedido.isEmpty()) throw new BusinessException("Pedido não encontrado com o id: " + id);
        return pedido.get();
    }
}
