package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Models.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RubroArticuloRepository extends JpaRepository<RubroArticulo, Long> {

    @Query(value = "SELECT * FROM rubroArticulo WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<RubroArticulo> search(String filtro);

    @Query(value = "SELECT * FROM rubroArticulo WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<RubroArticulo> search(String filtro, Pageable pageable);

}
