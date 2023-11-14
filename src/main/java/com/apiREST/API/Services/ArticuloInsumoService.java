package com.apiREST.API.Services;

import com.apiREST.API.Models.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    List<ArticuloInsumo> search(String filtro) throws Exception;

    List<ArticuloInsumo> searchByStock() throws Exception;

    List<ArticuloInsumo> searchByEstado() throws Exception;

    Page<ArticuloInsumo> searchPaged(String filtro, Pageable pageable) throws Exception;



}
