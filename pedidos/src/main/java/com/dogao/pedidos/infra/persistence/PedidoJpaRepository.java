package com.dogao.pedidos.infra.persistence;

import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    @Modifying
    @Query("UPDATE PedidoEntity p SET p.status = 'CANCELADO' WHERE p.id = :id")
    void cancelarPedido(@Param("id") Long id);
}
