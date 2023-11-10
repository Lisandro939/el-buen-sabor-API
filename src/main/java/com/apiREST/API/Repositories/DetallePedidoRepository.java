package com.apiREST.API.Repositories;

import com.apiREST.API.DTOs.HistorialPedidoDTO;
import com.apiREST.API.Models.DetallePedido;
import com.apiREST.API.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {

    @Query(value = "SELECT * FROM detallePedido WHERE cliente_id LIKE %?1%", nativeQuery = true)
    List<Pedido> obtenerSubtotal(Long clienteId);

    @Query(value = "SELECT * FROM detalle_pedido WHERE datelle_pedido_id = :numeroPedido", nativeQuery = true)
    List<HistorialPedidoDTO.HistorialDetallePedidoDTO> obtenerDetalle(@Param("numeroPedido")int numero);
}
