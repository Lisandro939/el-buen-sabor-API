package com.apiREST.API.Services;

import com.apiREST.API.Models.ArticuloManufacturadoDetalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoDetalleService extends BaseService<ArticuloManufacturadoDetalle, Long> {

    List<ArticuloManufacturadoDetalle> search(String filtro) throws Exception;

    Page<ArticuloManufacturadoDetalle> searchPaged(String filtro, Pageable pageable) throws Exception;

}