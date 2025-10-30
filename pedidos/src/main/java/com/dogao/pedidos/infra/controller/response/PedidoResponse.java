package com.dogao.pedidos.infra.controller.response;

import java.util.List;

public record PedidoResponse(ClienteResponse cliente, List<ItemResponse> itens, StatusResponse status) {
}
