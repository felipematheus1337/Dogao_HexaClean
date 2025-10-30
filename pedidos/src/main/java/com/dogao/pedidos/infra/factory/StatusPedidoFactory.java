package com.dogao.pedidos.infra.factory;

import com.dogao.pedidos.domain.enums.StatusPedido;
import com.dogao.pedidos.infra.amqp.event.StatusPagamentoMessage;

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
}
