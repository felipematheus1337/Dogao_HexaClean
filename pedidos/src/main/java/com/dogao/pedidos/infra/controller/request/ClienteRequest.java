package com.dogao.pedidos.infra.controller.request;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(@NotBlank String nome, @NotBlank String email) {
}
