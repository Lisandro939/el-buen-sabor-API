package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(value = "SELECT * FROM factura WHERE numero LIKE %?1%", nativeQuery = true)
    List<Factura> search(String filtro);

    @Query(value = "SELECT * FROM factura WHERE numero LIKE %?1%", nativeQuery = true)
    Page<Factura> searchPaged(String filtro, Pageable pageable);

    //historial pedidos
//    @Query("SELECT f FROM Factura f WHERE f.pedido = :pedido")
//    Factura obtenerFacturaPorPedido(@Param("pedido") Pedido pedido);

    // Consulta personalizada para obtener una factura por su ID
//    @Query("SELECT f FROM Factura f WHERE f.id = :facturaId")
//    Factura obtenerFacturaPorId(@Param("facturaId") Long facturaId);


}
