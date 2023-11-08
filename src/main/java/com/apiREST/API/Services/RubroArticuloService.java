package com.apiREST.API.Services;

import com.apiREST.API.Models.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloService extends BaseService<RubroArticulo, Long> {

    List<RubroArticulo> search(String filtro) throws Exception;

    Page<RubroArticulo> searchPaged(String filtro, Pageable pageable) throws Exception;

}
