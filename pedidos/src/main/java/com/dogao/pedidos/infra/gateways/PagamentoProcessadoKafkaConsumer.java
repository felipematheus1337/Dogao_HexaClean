package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.usecases.AtualizarPedidoStatusUseCase;
import com.dogao.pedidos.infra.amqp.event.PagamentoProcessadoMessage;
import com.dogao.pedidos.infra.factory.StatusPedidoFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoProcessadoKafkaConsumer implements PagamentoProcessadoConsumer<PagamentoProcessadoMessage> {

    private final AtualizarPedidoStatusUseCase atualizarPedidoStatusUseCase;

    public PagamentoProcessadoKafkaConsumer(AtualizarPedidoStatusUseCase atualizarPedidoStatusUseCase) {
        this.atualizarPedidoStatusUseCase = atualizarPedidoStatusUseCase;
    }

    @KafkaListener(topics = "pagamento.processado")
    @Override
    public void subscribe(@Payload PagamentoProcessadoMessage message) {

        var status = StatusPedidoFactory.pagamentoToStatusPedido(message.status());

        atualizarPedidoStatusUseCase.atualizarPedido(message.pedidoId(), status);

    }
}
