package com.dogao.pagamento.adapters.out.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoJpaRepository extends MongoRepository<PagamentoEntity, String> {
}
