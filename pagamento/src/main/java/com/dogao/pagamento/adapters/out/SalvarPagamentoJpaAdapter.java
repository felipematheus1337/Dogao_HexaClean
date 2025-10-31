package com.dogao.pagamento.adapters.out;

import com.dogao.pagamento.adapters.out.repository.PagamentoEntity;
import com.dogao.pagamento.adapters.out.repository.PagamentoJpaRepository;
import com.dogao.pagamento.adapters.out.repository.mapper.PagamentoEntityMapper;
import com.dogao.pagamento.application.domain.Pagamento;
import com.dogao.pagamento.application.ports.out.SalvarPagamentoOutputPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SalvarPagamentoJpaAdapter implements SalvarPagamentoOutputPort {

    private final PagamentoJpaRepository repository;
    private final PagamentoEntityMapper mapper;

    public SalvarPagamentoJpaAdapter(PagamentoJpaRepository repository, PagamentoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public Pagamento salvar(Pagamento pagamento) {

        PagamentoEntity entity = mapper.toEntity(pagamento);

        PagamentoEntity entitySalva = repository.save(entity);

        return mapper.toDomain(entitySalva);
    }
}
