package com.dogao.pedidos.infra.persistence.entity.embedabbles;

import jakarta.persistence.Embeddable;

@Embeddable
public class ClienteEmbeddable {

    private String nome;
    private String email;

    public ClienteEmbeddable() {
    }

    public ClienteEmbeddable(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
