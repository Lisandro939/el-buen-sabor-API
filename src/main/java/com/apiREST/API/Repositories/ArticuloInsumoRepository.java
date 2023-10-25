package com.apiREST.API.Repositories;

import com.apiREST.API.Models.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    @Query(value = "SELECT * FROM articulo_insumo WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<ArticuloInsumo> search(String filtro);

    @Query(value = "SELECT * FROM articulo_insumo WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<ArticuloInsumo> searchPaged(String filtro, Pageable pageable);
}
