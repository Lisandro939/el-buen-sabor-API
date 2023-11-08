package com.apiREST.API.Repositories;

import com.apiREST.API.Models.ArticuloManufacturadoDetalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloManufacturadoDetalleRepository extends BaseRepository<ArticuloManufacturadoDetalle, Long> {

    @Query(value = "SELECT * FROM articulo_manufacturado_detalle WHERE id LIKE %?1%", nativeQuery = true)
    List<ArticuloManufacturadoDetalle> search(String filtro);

    @Query(value = "SELECT * FROM articulo_manufacturado_detalle WHERE id LIKE %?1%", nativeQuery = true)
    Page<ArticuloManufacturadoDetalle> searchPaged(String filtro, Pageable pageable);
}
