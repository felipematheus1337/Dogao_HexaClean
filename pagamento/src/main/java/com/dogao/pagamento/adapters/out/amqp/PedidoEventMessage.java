package com.dogao.pagamento.adapters.out.amqp;

import java.math.BigDecimal;

public record PedidoEventMessage(Long pedidoId, BigDecimal valor) {
}
