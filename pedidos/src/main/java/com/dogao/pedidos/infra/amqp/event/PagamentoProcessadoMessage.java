package com.dogao.pedidos.infra.amqp.event;

public record PagamentoProcessadoMessage(Long pedidoId, StatusPagamentoMessage status) {
}
