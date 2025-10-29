package com.dogao.pedidos.infra.mapper;

import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {

    PedidoEntity toEntity(Pedido pedido);
}
