package com.apiREST.API.Repositories;

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
}
