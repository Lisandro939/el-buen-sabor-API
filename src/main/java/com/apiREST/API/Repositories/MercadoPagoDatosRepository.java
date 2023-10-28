<<<<<<< HEAD
package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Domicilio;
import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.MercadoPagoDatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MercadoPagoDatosRepository extends BaseRepository<MercadoPagoDatos, Long> {

    @Query(value = "SELECT * FROM mercado_pago_datos WHERE identificador_pago LIKE %?1%", nativeQuery = true)
    List<MercadoPagoDatos> search(String filtro);

    @Query(value = "SELECT * FROM mercado_pago_datos WHERE identificador_pago LIKE %?1%", nativeQuery = true)
    Page<MercadoPagoDatos> searchPaged(String filtro, Pageable pageable);


}
=======
package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Domicilio;
import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.MercadoPagoDatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MercadoPagoDatosRepository extends BaseRepository<MercadoPagoDatos, Long> {

    @Query(value = "SELECT * FROM mercado_pago_datos WHERE identificador_pago LIKE %?1%", nativeQuery = true)
    List<MercadoPagoDatos> search(String filtro);

    @Query(value = "SELECT * FROM mercado_pago_datos WHERE identificador_pago LIKE %?1%", nativeQuery = true)
    Page<MercadoPagoDatos> searchPaged(String filtro, Pageable pageable);


}
>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
