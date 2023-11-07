package com.apiREST.API.Repositories;

import com.apiREST.API.Enums.EstadoPedido;
<<<<<<< HEAD
=======
import com.apiREST.API.Enums.TipoEnvio;
import com.apiREST.API.Models.Cliente;
>>>>>>> 44c05cecbd3d8fb02659d5de016e249514ef8c43
import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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


}
