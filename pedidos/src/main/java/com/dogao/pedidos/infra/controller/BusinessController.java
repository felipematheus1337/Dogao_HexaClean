package com.dogao.pedidos.infra.controller;

import com.dogao.pedidos.application.usecases.CancelarPedidoUseCase;
import com.dogao.pedidos.application.usecases.ConsultarPedidoUseCase;
import com.dogao.pedidos.application.usecases.CriarPedidoUseCase;
import com.dogao.pedidos.domain.Pedido;
import com.dogao.pedidos.infra.controller.mapper.PedidoControllerMapper;
import com.dogao.pedidos.infra.controller.request.PedidoRequest;
import com.dogao.pedidos.infra.controller.response.PedidoResponse;
import com.dogao.pedidos.infra.persistence.PedidoJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class BusinessController {

    private final CriarPedidoUseCase criarPedidoUseCase;
    private final CancelarPedidoUseCase cancelarPedidoUseCase;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;
    private final PedidoControllerMapper mapper;
    private final PedidoJpaRepository repository;

    public BusinessController(CriarPedidoUseCase criarPedidoUseCase, CancelarPedidoUseCase cancelarPedidoUseCase, ConsultarPedidoUseCase consultarPedidoUseCase, PedidoControllerMapper mapper, PedidoJpaRepository repository) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.cancelarPedidoUseCase = cancelarPedidoUseCase;
        this.consultarPedidoUseCase = consultarPedidoUseCase;
        this.mapper = mapper;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> criarUmPedido(@RequestBody PedidoRequest pedidoRequest) {
        Pedido domain = mapper.toDomain(pedidoRequest);
        criarPedidoUseCase.execute(domain);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> cancelarPedido(@PathVariable("id") Long id) {
        cancelarPedidoUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> consultarPedido(@PathVariable("id") Long id) {
       Pedido pedido = consultarPedidoUseCase.consultarPedido(id);
       var response = mapper.toResponse(pedido);
       return ResponseEntity.ok(response);
    }

}
