package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.infra.amqp.event.PedidoEvent;
import com.dogao.pedidos.infra.amqp.exception.AMQPException;
import com.dogao.pedidos.infra.amqp.mapper.PedidoEventMapper;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CriarPedidoCreatePedidoPublisherKafkaAMQPImpl implements CreatePedidoPublisher<PedidoEntity> {

    private static final Logger log = LoggerFactory.getLogger(CriarPedidoCreatePedidoPublisherKafkaAMQPImpl.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final PedidoEventMapper mapper;

    public CriarPedidoCreatePedidoPublisherKafkaAMQPImpl(KafkaTemplate<String, Object> kafkaTemplate, PedidoEventMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Retry(name = "pedidoPublisher", fallbackMethod = "fallbackPublish")
    @Override
    public void publish(PedidoEntity entity) {

        if (entity == null) throw new AMQPException("Objeto vazio não pode ser enviado.");

        try {
            PedidoEvent event = mapper.toEvent(entity);
            kafkaTemplate.send("pedido.criado", event)
                    .get(3,
                            TimeUnit.SECONDS);
            log.info("Pedido publicado com sucesso: {}", event.pedidoId());;
        } catch(Exception e) {
           log.error("Erro ao publicar evento de pedido.criado", e);
           throw new AMQPException("Falha ao publicar evento no Kafka");
        }

    }


    private void fallbackPublish(PedidoEntity entity) {
        log.error("Falha ao processar pedido para a fila de pedido criado.");
        // TO DO SCHEDULED PARA PEGAR ESSES PEDIDOS PENDENTES, E ENVIAR NOVAMENTE PARA A FILA.
    }
}
