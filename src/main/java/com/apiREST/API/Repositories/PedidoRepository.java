package com.apiREST.API.Repositories;

import com.apiREST.API.DTOs.MovimientosMonetariosDTO;
import com.apiREST.API.Enums.EstadoPedido;
import com.apiREST.API.Enums.TipoEnvio;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {


    @Query("SELECT p FROM Pedido p WHERE p.fecha = :fechafiltro")
    List<Pedido> search(@Param("fechafiltro") Date fechafiltro);

    @Query("SELECT p FROM Pedido p WHERE p.fecha = :fechafiltro")
    Page<Pedido> search(@Param("fechafiltro") Date fechafiltro, Pageable pageable);


    //BUSCAR TIPO ENVIO

    @Query("SELECT p FROM Pedido p WHERE p.tipoEnvio = :tipoEnvio")
    List<Pedido> searchByTipoEnvio(@Param("tipoEnvio") TipoEnvio tipoEnvio);

    @Query("SELECT p FROM Pedido p WHERE p.tipoEnvio = :tipoEnvio")
    Page<Pedido> searchByTipoEnvio(@Param("tipoEnvio") TipoEnvio tipoEnvio, Pageable pageable);

// Buscar por Estado

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<Pedido> searchByEstadoPedido(@Param("estado") EstadoPedido estado);

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    Page<Pedido> searchByEstadoPedido(@Param("estado") EstadoPedido estado, Pageable pageable);

    @Query(value = "SELECT * FROM pedido WHERE estado LIKE %?1%", nativeQuery = true)
    List<Pedido> searchByState(EstadoPedido filtro);

    //Historial pedidos
    @Query(value = "SELECT * FROM pedido WHERE cliente_id LIKE %?1%", nativeQuery = true)
    List<Pedido> findByClienteId(Long clienteId);

    @Query(value = "SELECT * FROM pedido WHERE numero LIKE %?1%", nativeQuery = true)
    Optional<Pedido> findByNumeroPedido(int numero);

    @Query(value = "SELECT p.fecha, p.numero, p.total, d.fecha AS detalle_fecha, d.numero_pedido, d.subtotal, a.tiempo_estimado_cocina, a.denominacion, a.precio_venta, a.imagen " +
            "FROM pedido p " +
            "JOIN detalle_pedido d ON p.id = d.pedido_id " +
            "LEFT JOIN articulo_manufacturado a ON d.articulo_manufacturado_id = a.id " +
            "WHERE p.numero = :numero", nativeQuery = true)
    List<Object[]> obtenerHistorialPedidoDTO(@Param("numero") int numero);

    @Query(value = "SELECT \n" +
            "    SUM(dp.cantidad * am.precio_venta) AS total_ingresos,\n" +
            "    SUM(dp.cantidad * am.precio_costo) AS costos,\n" +
            "    SUM(dp.cantidad * (am.precio_venta - am.precio_costo)) AS ganancia\n" +
            "FROM detalle_pedido dp\n" +
            "JOIN articulo_manufacturado am ON dp.articulo_manufacturado_id = am.id\n" +
            "JOIN pedido p ON dp.datelle_pedido_id = p.id\n" +
            "WHERE p.fecha BETWEEN :desde AND :hasta ;", nativeQuery = true)
    List<Object[]> obtenerMovimientosMonetarios(@Param("desde") String desde, @Param("hasta") String hasta);

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<Pedido> findByEstado(@Param("estado") EstadoPedido estado);

    @Query(value = "SELECT * FROM pedido  WHERE estado = 'Listo' AND tipo_envio = 'Delivery'", nativeQuery = true)
    List<Pedido> findByDelivery();
}
