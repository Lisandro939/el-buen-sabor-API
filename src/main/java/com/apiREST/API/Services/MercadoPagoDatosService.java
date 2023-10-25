package com.apiREST.API.Services;

import com.apiREST.API.Models.MercadoPagoDatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MercadoPagoDatosService extends BaseService<MercadoPagoDatos, Long> {

    List<MercadoPagoDatos> search(String filtro) throws Exception;

    Page<MercadoPagoDatos> search(String filtro, Pageable pageable) throws Exception;
}
