package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.gateways.AtualizarPedidoStatusGateway;
import com.dogao.pedidos.domain.enums.StatusPedido;
import com.dogao.pedidos.infra.exception.PedidoNaoEncontradoException;
import com.dogao.pedidos.infra.factory.StatusPedidoFactory;
import com.dogao.pedidos.infra.persistence.PedidoJpaRepository;
import com.dogao.pedidos.infra.persistence.entity.enums.StatusPedidoEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AtualizarPedidoStatusJpaGateway implements AtualizarPedidoStatusGateway {

    private final PedidoJpaRepository repository;


    public AtualizarPedidoStatusJpaGateway(PedidoJpaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void atualizarPedido(Long pedidoId, StatusPedido statusPedido) {

        var pedido = repository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado com esse ID."));

        StatusPedidoEntity statusPedidoEntity = StatusPedidoFactory.pedidoStatusToStatusEntity(statusPedido);
        pedido.setStatus(statusPedidoEntity);

        repository.save(pedido);

    }
}
