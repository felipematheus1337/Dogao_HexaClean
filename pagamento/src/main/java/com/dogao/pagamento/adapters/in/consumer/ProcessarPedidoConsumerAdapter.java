package com.dogao.pagamento.adapters.in.consumer;

import com.dogao.pagamento.adapters.in.ProcessarPagamentoInputPort;
import com.dogao.pagamento.adapters.out.amqp.PagamentoAtualizadoEvent;
import com.dogao.pagamento.adapters.out.amqp.PedidoEventMessage;
import com.dogao.pagamento.application.domain.Pagamento;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ProcessarPedidoConsumerAdapter {

    private final ProcessarPagamentoInputPort processarPagamentoInputPort;

    public ProcessarPedidoConsumerAdapter(ProcessarPagamentoInputPort processarPagamentoInputPort) {
        this.processarPagamentoInputPort = processarPagamentoInputPort;
    }


    @KafkaListener(topics = "pedido.criado")
    public void consume(@Payload PedidoEventMessage pedidoEventMessage) {

        Pagamento pagamento = new Pagamento(pedidoEventMessage.pedidoId(), pedidoEventMessage.valor());

        processarPagamentoInputPort.consumirMensagem(pagamento);

    }
}
