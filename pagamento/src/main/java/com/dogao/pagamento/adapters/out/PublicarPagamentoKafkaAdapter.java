package com.dogao.pagamento.adapters.out;

import com.dogao.pagamento.adapters.out.amqp.PagamentoAtualizadoEvent;
import com.dogao.pagamento.adapters.utils.AdapterUtils;
import com.dogao.pagamento.application.domain.Pagamento;
import com.dogao.pagamento.application.ports.out.PublicarPagamentoOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublicarPagamentoKafkaAdapter implements PublicarPagamentoOutputPort {

    private static final Logger log = LoggerFactory.getLogger(PublicarPagamentoKafkaAdapter.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PublicarPagamentoKafkaAdapter(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publicar(Pagamento pagamento) {

        PagamentoAtualizadoEvent event = new PagamentoAtualizadoEvent(pagamento.getPedidoId(),
                pagamento.getStatus().toString());

        kafkaTemplate.send(AdapterUtils.KAFKA_PAGAMENTO_TOPIC, event)
                .whenComplete((result, e) -> {
                    if (result == null) {
                        log.error("Erro ao enviar mensagem de atualização.", e);
                    } else {
                        log.info("Sucesso ao enviar mensagem de atualização.");
                    }
                });

    }
}
