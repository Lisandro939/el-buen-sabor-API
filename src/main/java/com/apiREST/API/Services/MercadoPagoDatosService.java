<<<<<<< HEAD
package com.apiREST.API.Services;

import com.apiREST.API.Models.MercadoPagoDatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MercadoPagoDatosService extends BaseService<MercadoPagoDatos, Long> {

    List<MercadoPagoDatos> search(String filtro) throws Exception;

    Page<MercadoPagoDatos> searchPaged(String filtro, Pageable pageable) throws Exception;

}
=======
package com.apiREST.API.Services;

import com.apiREST.API.Models.MercadoPagoDatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MercadoPagoDatosService extends BaseService<MercadoPagoDatos, Long> {

    List<MercadoPagoDatos> search(String filtro) throws Exception;

    Page<MercadoPagoDatos> searchPaged(String filtro, Pageable pageable) throws Exception;

}
>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
