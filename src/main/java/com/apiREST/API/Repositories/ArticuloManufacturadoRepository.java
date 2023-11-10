package com.apiREST.API.Repositories;

import com.apiREST.API.DTOs.RankingProductosDTO;
import com.apiREST.API.Models.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<ArticuloManufacturado> search(String filtro);

    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<ArticuloManufacturado> searchPaged(String filtro, Pageable pageable);

    @Query(value = "SELECT\n" +
            "    am.id,\n" +
            "    am.denominacion AS denominacion,\n" +
            "    COALESCE(SUM(dp.cantidad), 0) AS cantidad\n" +
            "FROM\n" +
            "    articulo_manufacturado am\n" +
            "LEFT JOIN\n" +
            "    (\n" +
            "        SELECT\n" +
            "            dp.articulo_manufacturado_id,\n" +
            "            SUM(dp.cantidad) AS cantidad\n" +
            "        FROM\n" +
            "            detalle_pedido dp\n" +
            "        JOIN\n" +
            "            pedido p ON dp.datelle_pedido_id = p.id\n" +
            "        WHERE\n" +
            "            p.fecha BETWEEN %?2% AND %?3%\n" +
            "        GROUP BY\n" +
            "            dp.articulo_manufacturado_id\n" +
            "    ) dp ON am.id = dp.articulo_manufacturado_id\n" +
            "WHERE\n" +
            "    am.rubro_general_id = (SELECT id FROM rubro_general WHERE denominacion = %?1%)\n" +
            "GROUP BY\n" +
            "    am.id, am.denominacion\n" +
            "ORDER BY\n" +
            "    cantidad DESC;", nativeQuery = true)
    List<Object[]> ranking(String producto, String desde, String hasta);
}
