package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.gateways.ValidarEstoqueGateway;
import com.dogao.pedidos.infra.client.EstoqueFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

@Component
public class ValidarEstoqueFeignGateway implements ValidarEstoqueGateway {

    private final EstoqueFeignClient client;

    public ValidarEstoqueFeignGateway(EstoqueFeignClient client) {
        this.client = client;
    }

    @CircuitBreaker(name = "estoqueService", fallbackMethod = "fallbackEstoque")
    @Override
    public boolean validar(Long pedidoId) {
        return client.verificarDisponibilidade(pedidoId);
    }

    public boolean fallbackEstoque(Long pedidoId, Throwable t) {
        return false;
    }
}
