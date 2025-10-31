package com.dogao.pagamento.application.ports.out;

import com.dogao.pagamento.application.domain.Pagamento;

public interface SalvarPagamentoOutputPort {

    Pagamento salvar(Pagamento pagamento);
}
