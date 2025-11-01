package com.dogao.pedidos.config;

import com.dogao.pedidos.application.gateways.CancelarPedidoGateway;
import com.dogao.pedidos.application.gateways.ConsultarPedidoGateway;
import com.dogao.pedidos.application.gateways.CriarPedidoGateway;
import com.dogao.pedidos.application.gateways.ValidarEstoqueGateway;
import com.dogao.pedidos.application.usecases.CancelarPedidoUseCase;
import com.dogao.pedidos.application.usecases.ConsultarPedidoUseCase;
import com.dogao.pedidos.application.usecases.CriarPedidoUseCase;
import com.dogao.pedidos.application.usecases.ValidarEstoqueUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigurationBeans {

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(CriarPedidoGateway criarPedidoGateway,
                                                 ValidarEstoqueUseCase validarEstoqueUseCase) {
        return new CriarPedidoUseCase(criarPedidoGateway, validarEstoqueUseCase);
    }

    @Bean
    public CancelarPedidoUseCase cancelarPedidoUseCase(CancelarPedidoGateway cancelarPedidoGateway) {
        return new CancelarPedidoUseCase(cancelarPedidoGateway);
    }

    @Bean
    public ConsultarPedidoUseCase consultarPedidoUseCase(ConsultarPedidoGateway consultarPedidoGateway) {
        return new ConsultarPedidoUseCase(consultarPedidoGateway);
    }

    @Bean
    public ValidarEstoqueUseCase validarEstoqueUseCase(ValidarEstoqueGateway validarEstoqueGateway) {
        return new ValidarEstoqueUseCase(validarEstoqueGateway);
    }
}
