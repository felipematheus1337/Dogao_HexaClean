package com.dogao.pagamento.adapters.out.repository.mapper;

import com.dogao.pagamento.adapters.out.repository.PagamentoEntity;
import com.dogao.pagamento.application.domain.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoEntityMapper {

    @Mapping(target = "valorTotal", source = "valor")
    PagamentoEntity toEntity(Pagamento pagamento);

    @Mapping(target = "valor", source = "valorTotal")
    Pagamento toDomain(PagamentoEntity entitySalva);
}
