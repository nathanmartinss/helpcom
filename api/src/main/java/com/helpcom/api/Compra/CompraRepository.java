package com.helpcom.api.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByIdItem(Long idItem);
    List<Compra> findAllByIdItemOrderByDataCompraAsc(Long idItem);
    @Query("SELECT c FROM Compra c WHERE c.idItem = :idItem ORDER BY c.dataCompra ASC LIMIT 1")
    Compra findFirstCompraInfo(@Param("idItem") Long idItem);

    @Modifying
    @Transactional
    @Query("UPDATE Compra c SET c.qtdItem = :quantidade WHERE c.idItem = :idItem AND c.qtdItem > 0")
    void updateQuantidadeItem(@Param("idItem") Long idItem, @Param("quantidade") int quantidade);
}
