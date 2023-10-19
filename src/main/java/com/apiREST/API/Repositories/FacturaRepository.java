package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(value = "SELECT * FROM domicilio WHERE calle LIKE %?1%", nativeQuery = true)
    List<Factura> search(String filtro);

    @Query(value = "SELECT * FROM domicilio WHERE calle LIKE %?1%", nativeQuery = true)
    Page<Factura> search(String filtro, Pageable pageable);


}
