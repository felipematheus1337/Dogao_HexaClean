package com.dogao.pedidos.infra.controller.mapper;

import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.controller.request.PedidoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoControllerMapper {

    Pedido toDomain(PedidoRequest request);
}
