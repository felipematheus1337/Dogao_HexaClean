package com.dogao.pagamento.application.usecases;

import com.dogao.pagamento.adapters.in.ProcessarPagamentoInputPort;
import com.dogao.pagamento.application.domain.Pagamento;
import com.dogao.pagamento.application.domain.vo.Transacao;
import com.dogao.pagamento.application.facade.PagamentoFacade;
import com.dogao.pagamento.application.ports.out.EfetuarPagamentoOutputPort;

public class ProcessarPagamentoUseCase implements ProcessarPagamentoInputPort {

    private final EfetuarPagamentoOutputPort efetuarPagamentoOutputPort;
    private final PagamentoFacade facade;

    public ProcessarPagamentoUseCase(EfetuarPagamentoOutputPort efetuarPagamentoOutputPort, PagamentoFacade facade) {
        this.efetuarPagamentoOutputPort = efetuarPagamentoOutputPort;
        this.facade = facade;
    }

    @Override
    public void consumirMensagem(Pagamento pagamento) {
        pagamento.validar(pagamento.getValor());
        Transacao transacao = efetuarPagamentoOutputPort.efetuarPagamento(pagamento);
        pagamento.aprovar(transacao);

        facade.executar(pagamento);
    }
}
