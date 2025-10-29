package com.dogao.pedidos.infra.controller.request;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ItemRequest(@NotBlank String nome, BigDecimal precoUnitario, int quantidade) {
}
