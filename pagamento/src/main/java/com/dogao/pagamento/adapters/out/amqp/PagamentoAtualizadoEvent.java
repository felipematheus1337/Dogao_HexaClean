package com.dogao.pagamento.adapters.out.amqp;

public record PagamentoAtualizadoEvent(Long pedidoId, String status) {
}
