package com.dogao.pedidos.infra.amqp.event;

import java.math.BigDecimal;

public record PedidoEvent(Long pedidoId, BigDecimal valor) {
}
