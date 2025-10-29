package com.dogao.pedidos.infra.controller;

import com.dogao.pedidos.application.usecases.CriarPedidoUseCase;
import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.controller.mapper.PedidoControllerMapper;
import com.dogao.pedidos.infra.controller.request.PedidoRequest;
import com.dogao.pedidos.infra.persistence.PedidoJpaRepository;
import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BusinessController {

    private final CriarPedidoUseCase criarPedidoUseCase;
    private final PedidoControllerMapper mapper;
    private final PedidoJpaRepository repository;

    public BusinessController(CriarPedidoUseCase criarPedidoUseCase, PedidoControllerMapper mapper, PedidoJpaRepository repository) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.mapper = mapper;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> criarUmPedido(@RequestBody PedidoRequest pedidoRequest) {
        Pedido domain = mapper.toDomain(pedidoRequest);
        criarPedidoUseCase.execute(domain);
        return ResponseEntity.noContent().build();
    }

}
