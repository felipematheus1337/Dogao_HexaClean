package com.dogao.pagamento.application.ports.out;

import com.dogao.pagamento.application.domain.Pagamento;
import com.dogao.pagamento.application.domain.vo.Transacao;

public interface EfetuarPagamentoOutputPort {

    Transacao efetuarPagamento(Pagamento pagamento);
}
