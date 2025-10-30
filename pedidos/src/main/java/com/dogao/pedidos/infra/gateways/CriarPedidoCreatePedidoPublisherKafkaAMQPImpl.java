package com.dogao.pedidos.infra.gateways;

import com.dogao.pedidos.infra.amqp.event.PedidoEvent;
import com.dogao.pedidos.infra.amqp.exception.AMQPException;
import com.dogao.pedidos.infra.amqp.mapper.PedidoEventMapper;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CriarPedidoCreatePedidoPublisherKafkaAMQPImpl implements CreatePedidoPublisher<PedidoEntity> {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final PedidoEventMapper mapper;

    public CriarPedidoCreatePedidoPublisherKafkaAMQPImpl(KafkaTemplate<String, Object> kafkaTemplate, PedidoEventMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Override
    public void publish(PedidoEntity entity) {

        if (entity == null) throw new AMQPException("Objeto vazio não pode ser enviado.");

        PedidoEvent event = mapper.toEvent(entity);

        kafkaTemplate.send("pedido.criado", event);

    }
}
