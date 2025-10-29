package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.gateways.CancelarPedidoGateway;
import com.dogao.pedidos.infra.persistence.PedidoJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CancelarPedidoJpaGateway implements CancelarPedidoGateway {

    private final PedidoJpaRepository repository;

    public CancelarPedidoJpaGateway(PedidoJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void cancelarPedido(Long id) {
        repository.cancelarPedido(id);
    }
}
