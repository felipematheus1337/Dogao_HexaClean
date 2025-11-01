package com.dogao.pedidos.application.usecases;

import com.dogao.pedidos.application.gateways.CriarPedidoGateway;
import com.dogao.pedidos.domain.Pedido;

public class CriarPedidoUseCase {

    private final CriarPedidoGateway gateway;
    private final ValidarEstoqueUseCase validarEstoqueUseCase;

    public CriarPedidoUseCase(CriarPedidoGateway gateway, ValidarEstoqueUseCase validarEstoqueUseCase) {
        this.gateway = gateway;
        this.validarEstoqueUseCase = validarEstoqueUseCase;
    }

    public void execute(Pedido pedido) {

        gateway.criarPedido(pedido);

    }
}
