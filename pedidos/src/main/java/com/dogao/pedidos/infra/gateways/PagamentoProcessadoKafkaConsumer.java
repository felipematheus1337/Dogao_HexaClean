package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.application.usecases.AtualizarPedidoStatusUseCase;
import com.dogao.pedidos.infra.amqp.event.PagamentoProcessadoMessage;
import com.dogao.pedidos.infra.amqp.exception.AMQPException;
import com.dogao.pedidos.infra.factory.StatusPedidoFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PagamentoProcessadoKafkaConsumer implements PagamentoProcessadoConsumer<PagamentoProcessadoMessage> {

    private final AtualizarPedidoStatusUseCase atualizarPedidoStatusUseCase;

    public PagamentoProcessadoKafkaConsumer(AtualizarPedidoStatusUseCase atualizarPedidoStatusUseCase) {
        this.atualizarPedidoStatusUseCase = atualizarPedidoStatusUseCase;
    }

    @KafkaListener(topics = "pagamento.processado")
    @RetryableTopic(attempts = "3", backoff = @Backoff(delay = 2000))
    @Override
    public void subscribe(@Payload PagamentoProcessadoMessage message) {

        if (message == null) throw new AMQPException("payload de status após pagamento está null.");

        Assert.notNull(message.status(),
                "Não é possivel atualizar o status do pedido sem um status de pagamento definido.");

        var status = StatusPedidoFactory.pagamentoToStatusPedido(message.status());

        atualizarPedidoStatusUseCase.atualizarPedido(message.pedidoId(), status);

    }
}
