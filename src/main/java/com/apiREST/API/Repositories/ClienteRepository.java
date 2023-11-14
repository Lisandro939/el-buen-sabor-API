package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %?1%", nativeQuery = true)
    List<Cliente> search(String filtro);

    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %?1%", nativeQuery = true)
    Page<Cliente> searchPaged(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM cliente WHERE email = %?1% AND usuario_id IN (SELECT id FROM usuario WHERE clave = %?2%);", nativeQuery = true)
    Cliente login(String email, String clave);

    @Query(value = "SELECT * FROM cliente WHERE email = %?1%", nativeQuery = true)
    Cliente findByEmail(String email);

    @Query(value = "WITH ClienteProductos AS (\n" +
            "    SELECT\n" +
            "        c.id AS id_cliente,\n" +
            "        c.nombre AS nombre_cliente,\n" +
            "        c.apellido AS apellido_cliente,\n" +
            "        SUM(dp.cantidad) AS cantidad_total_comprada,\n" +
            "        SUM(dp.subtotal) AS importe_total_comprado,\n" +
            "        ROW_NUMBER() OVER (ORDER BY SUM(dp.cantidad) DESC) AS ranking\n" +
            "    FROM\n" +
            "        cliente c\n" +
            "    LEFT JOIN\n" +
            "        pedido p ON c.id = p.cliente_id\n" +
            "    LEFT JOIN\n" +
            "        detalle_pedido dp ON p.id = dp.datelle_pedido_id\n" +
            "    LEFT JOIN\n" +
            "        articulo_manufacturado am ON dp.articulo_manufacturado_id = am.id\n" +
            "    LEFT JOIN\n" +
            "        rubro_general rg ON am.rubro_general_id = rg.id\n" +
            "    WHERE\n" +
            "        rg.denominacion = %?1%\n" +
            "        AND p.fecha BETWEEN %?2% AND %?3% -- Intervalo de fechas\n" +
            "    GROUP BY\n" +
            "        c.id, c.nombre\n" +
            ")\n" +
            "SELECT\n" +
            "    nombre_cliente,\n" +
            "    apellido_cliente,\n" +
            "    cantidad_total_comprada,\n" +
            "    importe_total_comprado\n" +
            "FROM\n" +
            "    ClienteProductos\n" +
            "WHERE\n" +
            "    ranking <= 3\n" +
            "ORDER BY\n" +
            "    cantidad_total_comprada DESC;", nativeQuery = true)
    List<Object[]> rankingClientes(String rubro, String desde, String hasta);

    @Query(value = "SELECT * FROM cliente")
    List<Cliente> obtenerListaCliente();
}