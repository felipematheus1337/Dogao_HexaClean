package com.dogao.pedidos.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "estoqueClient", url = "${feign.client.config.estoque.url}")
public interface EstoqueFeignClient {

    @GetMapping("/mock/estoque/verificar")
    boolean verificarDisponibilidade(@RequestParam Long idPedido);
}
