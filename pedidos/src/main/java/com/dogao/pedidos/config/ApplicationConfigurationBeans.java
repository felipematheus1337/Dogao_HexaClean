package com.dogao.pedidos.config;

import com.dogao.pedidos.application.gateways.CriarPedidoGateway;
import com.dogao.pedidos.application.usecases.CriarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurationBeans {

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(CriarPedidoGateway criarPedidoGateway) {
        return new CriarPedidoUseCase(criarPedidoGateway);
    }
}
