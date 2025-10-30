package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.gateways.CriarPedidoGateway;
import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.mapper.PedidoEntityMapper;
import com.dogao.pedidos.infra.persistence.PedidoJpaRepository;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CriarPedidoJpaGateway implements CriarPedidoGateway {

    private final PedidoJpaRepository repository;
    private final PedidoEntityMapper mapper;
    private final CreatePedidoPublisher createPedidoPublisher;

    public CriarPedidoJpaGateway(PedidoJpaRepository repository, PedidoEntityMapper mapper, CreatePedidoPublisher createPedidoPublisher) {
        this.repository = repository;
        this.mapper = mapper;
        this.createPedidoPublisher = createPedidoPublisher;
    }

    @Transactional
    @Override
    public void criarPedido(Pedido pedido) {

        PedidoEntity entity = mapper.toEntity(pedido);
        PedidoEntity savedEntity = repository.save(entity);

        createPedidoPublisher.publish(savedEntity);

    }

}
