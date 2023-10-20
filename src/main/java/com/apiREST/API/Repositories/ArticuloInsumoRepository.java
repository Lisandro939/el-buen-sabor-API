package com.apiREST.API.Repositories;

import com.apiREST.API.Models.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

    @Query(value = "SELECT * FROM articulo_insumo WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<ArticuloInsumo> search(String filtro);

    @Query(value = "SELECT * FROM articulo_insumo WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<ArticuloInsumo> search(String filtro, Pageable pageable);


}
