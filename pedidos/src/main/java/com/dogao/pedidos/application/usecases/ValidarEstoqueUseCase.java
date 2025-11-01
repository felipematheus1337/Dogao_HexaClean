package com.dogao.pedidos.application.usecases;

import com.dogao.pedidos.application.gateways.ValidarEstoqueGateway;

public class ValidarEstoqueUseCase {

    private final ValidarEstoqueGateway gateway;

    public ValidarEstoqueUseCase(ValidarEstoqueGateway gateway) {
        this.gateway = gateway;
    }

    boolean validar(Long pedidoId) {
        return gateway.validar(pedidoId);
    }
}
