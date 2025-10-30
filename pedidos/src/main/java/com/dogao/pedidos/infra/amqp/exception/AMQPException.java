package com.dogao.pedidos.infra.amqp.exception;


public class AMQPException extends RuntimeException {

    public AMQPException(String message) {
        super(message);
    }
}
