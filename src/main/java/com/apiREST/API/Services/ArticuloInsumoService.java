package com.apiREST.API.Services;

import com.apiREST.API.Models.ArticuloInsumo;
<<<<<<< HEAD
=======

>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    List<ArticuloInsumo> search(String filtro) throws Exception;

    Page<ArticuloInsumo> searchPaged(String filtro, Pageable pageable) throws Exception;

<<<<<<< HEAD
}
=======
}
>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
