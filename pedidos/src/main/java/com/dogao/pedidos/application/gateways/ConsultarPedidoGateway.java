package com.dogao.pedidos.application.gateways;

import com.dogao.pedidos.domain.Pedido;

import java.util.Optional;

public interface ConsultarPedidoGateway {

    Optional<Pedido> consultarPedido(Long pedidoId);
}
