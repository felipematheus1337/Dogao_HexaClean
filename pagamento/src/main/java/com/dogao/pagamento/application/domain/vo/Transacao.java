package com.dogao.pagamento.application.domain.vo;

import java.time.LocalDateTime;

public class Transacao {
    private final String codigoAutorizacao;
    private final LocalDateTime data;
    private final String metodo; // PIX, CARTAO, etc.

    public Transacao(String codigoAutorizacao, LocalDateTime data, String metodo) {
        this.codigoAutorizacao = codigoAutorizacao;
        this.data = data;
        this.metodo = metodo;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getMetodo() {
        return metodo;
    }
}

