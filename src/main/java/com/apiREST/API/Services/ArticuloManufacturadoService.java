package com.apiREST.API.Services;

import com.apiREST.API.DTOs.RankingProductosDTO;
import com.apiREST.API.Models.ArticuloInsumo;
import com.apiREST.API.Models.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {

    List<ArticuloManufacturado> search(String filtro) throws Exception;

    Page<ArticuloManufacturado> searchPaged(String filtro, Pageable pageable) throws Exception;

    List<RankingProductosDTO> ranking(String producto, String desde, String hasta) throws Exception;

    ArticuloManufacturado findByName(String denominacion) throws Exception;
}
