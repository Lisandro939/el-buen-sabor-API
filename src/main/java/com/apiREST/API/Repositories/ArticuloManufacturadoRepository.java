package com.apiREST.API.Repositories;

import com.apiREST.API.Models.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    @Query(value = "SELECT * FROM articuloManufacturado WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<ArticuloManufacturado> search(String filtro);

    @Query(value = "SELECT * FROM articuloManufacturado WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<ArticuloManufacturado> search(String filtro, Pageable pageable);


}
