package com.dogao.pedidos.infra.amqp.mapper;

import com.dogao.pedidos.infra.amqp.event.PedidoEvent;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoEventMapper {

    @Mapping(target = "pedidoId", source = "id")
    @Mapping(target = "valor", source = "valorTotal")
    PedidoEvent toEvent(PedidoEntity entity);
}
