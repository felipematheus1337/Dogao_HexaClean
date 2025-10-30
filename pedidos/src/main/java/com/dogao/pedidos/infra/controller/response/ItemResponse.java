package com.dogao.pedidos.infra.controller.response;

import java.math.BigDecimal;

public record ItemResponse(String nome, BigDecimal precoUnitario, int quantidade) {
}
