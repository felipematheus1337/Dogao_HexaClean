package com.dogao.pagamento.application.facade;

import com.dogao.pagamento.application.domain.Pagamento;
import com.dogao.pagamento.application.ports.out.PublicarPagamentoOutputPort;
import com.dogao.pagamento.application.ports.out.SalvarPagamentoOutputPort;

public class PagamentoFacade {

    private final PublicarPagamentoOutputPort publicarPagamentoOutputPort;
    private final SalvarPagamentoOutputPort salvarPagamentoOutputPort;


    public PagamentoFacade(PublicarPagamentoOutputPort publicarPagamentoOutputPort, SalvarPagamentoOutputPort salvarPagamentoOutputPort) {
        this.publicarPagamentoOutputPort = publicarPagamentoOutputPort;
        this.salvarPagamentoOutputPort = salvarPagamentoOutputPort;
    }

    public void executar(Pagamento pagamento) {
        this.salvarPagamentoOutputPort.salvar(pagamento);
        this.publicarPagamentoOutputPort.publicar(pagamento);
    }
}
