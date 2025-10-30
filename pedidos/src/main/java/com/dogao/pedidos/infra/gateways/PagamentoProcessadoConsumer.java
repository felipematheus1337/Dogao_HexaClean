package com.dogao.pedidos.infra.gateways;

public interface PagamentoProcessadoConsumer<T> {

    void subscribe (T o);
}
