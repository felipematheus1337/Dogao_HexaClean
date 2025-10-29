package com.dogao.pedidos.infra.controller.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PedidoRequest(@NotBlank ClienteRequest cliente, @NotBlank List<ItemRequest> itens) {
}
