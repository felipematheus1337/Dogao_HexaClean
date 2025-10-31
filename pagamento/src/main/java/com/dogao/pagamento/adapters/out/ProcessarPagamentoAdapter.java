package com.dogao.pagamento.adapters.out;

import com.dogao.pagamento.adapters.in.ProcessarPagamentoInputPort;
import com.dogao.pagamento.application.domain.Pagamento;
import com.dogao.pagamento.application.domain.vo.Transacao;
import com.dogao.pagamento.application.ports.out.EfetuarPagamentoOutputPort;
import org.bson.assertions.Assertions;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProcessarPagamentoAdapter implements EfetuarPagamentoOutputPort {


    @Override
    public Transacao efetuarPagamento(Pagamento pagamento) {

        Assertions.assertNotNull(pagamento);

        // LOGICA SIMULADA DE PAGAMENTO, ETC
        return new Transacao(UUID.randomUUID().toString().substring(0, 6),
                LocalDateTime.now(), "PIX");
    }
}
