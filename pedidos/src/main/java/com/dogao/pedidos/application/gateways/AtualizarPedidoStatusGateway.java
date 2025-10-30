package com.dogao.pedidos.application.gateways;

import com.dogao.pedidos.domain.enums.StatusPedido;

public interface AtualizarPedidoStatusGateway {

    void atualizarPedido(Long pedidoId, StatusPedido statusPedido);


}
