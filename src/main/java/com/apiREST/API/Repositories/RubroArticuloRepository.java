package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Models.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo, Long> {

    @Query(value = "SELECT * FROM rubro_articulo WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<RubroArticulo> search(String filtro);

    @Query(value = "SELECT * FROM rubro_articulo WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<RubroArticulo> searchPaged(String filtro, Pageable pageable);


}