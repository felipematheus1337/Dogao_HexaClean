package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.gateways.ConsultarPedidoGateway;
import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.mapper.PedidoEntityMapper;
import com.dogao.pedidos.infra.persistence.PedidoJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ConsultarPedidoJpaGateway implements ConsultarPedidoGateway {

    private final PedidoJpaRepository repository;
    private final PedidoEntityMapper mapper;

    public ConsultarPedidoJpaGateway(PedidoJpaRepository repository, PedidoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Pedido> consultarPedido(Long pedidoId) {
        return repository.findById(pedidoId)
                .map(mapper::toDomain);

    }
}
