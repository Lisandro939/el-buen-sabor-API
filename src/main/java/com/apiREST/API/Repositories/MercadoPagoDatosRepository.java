package com.apiREST.API.Repositories;

import com.apiREST.API.Models.MercadoPagoDatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MercadoPagoDatosRepository extends BaseRepository<MercadoPagoDatos, Long> {

    @Query(value = "SELECT * FROM mercadoPagoDatos WHERE identificador_pago LIKE %?1%", nativeQuery = true)
    List<MercadoPagoDatos> search(String filtro);

    @Query(value = "SELECT * FROM mercadoPagoDatos WHERE identificador_pago LIKE %?1%", nativeQuery = true)
    Page<MercadoPagoDatos> search(String filtro, Pageable pageable);
}
