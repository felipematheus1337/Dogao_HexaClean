package com.dogao.pedidos.infra.mapper;

import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",  unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoEntityMapper {

    PedidoEntity toEntity(Pedido pedido);

    Pedido toDomain(PedidoEntity pedidoEntity);
}
