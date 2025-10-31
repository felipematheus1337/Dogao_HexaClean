package com.dogao.pagamento.adapters.in;

import com.dogao.pagamento.application.domain.Pagamento;

public interface ProcessarPagamentoInputPort {

    void consumirMensagem(Pagamento pagamento);


}
