package com.dogao.pedidos.infra.factory;

import com.dogao.pedidos.domain.enums.StatusPedido;
import com.dogao.pedidos.infra.amqp.event.StatusPagamentoMessage;
import com.dogao.pedidos.infra.persistence.entity.enums.StatusPedidoEntity;

public class StatusPedidoFactory {

    public static StatusPedido pagamentoToStatusPedido(StatusPagamentoMessage statusPedidoMessage) {

        switch (statusPedidoMessage) {
            case APROVADO ->  {
                return StatusPedido.APROVADO;
            }
            case PENDENTE -> {
                return StatusPedido.PENDENTE;
            }
            default -> {
                return StatusPedido.REJEITADO;
            }

        }

    }

    public static StatusPedidoEntity pedidoStatusToStatusEntity(StatusPedido statusPedido) {

        switch (statusPedido) {
            case APROVADO -> {
                return StatusPedidoEntity.APROVADO;
            }
            case REJEITADO -> {
                return StatusPedidoEntity.REJEITADO;
            }
            case CANCELADO ->  {
                return StatusPedidoEntity.CANCELADO;
            }

            default -> {
                return StatusPedidoEntity.PENDENTE;
            }
        }
    }


}
