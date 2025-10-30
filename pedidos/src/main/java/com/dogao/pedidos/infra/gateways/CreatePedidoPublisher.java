package com.dogao.pedidos.infra.gateways;

public interface CreatePedidoPublisher<T> {

    void publish(T o);
}
