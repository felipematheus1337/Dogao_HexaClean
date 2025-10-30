package com.dogao.pedidos.infra.persistence;

import com.dogao.pedidos.infra.persistence.entity.PedidoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE PedidoEntity p SET p.status = com.dogao.pedidos.infra.persistence.entity.enums.StatusPedidoEntity.CANCELADO WHERE p.id = :id")
    void cancelarPedido(@Param("id") Long id);
}
