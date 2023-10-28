<<<<<<< HEAD
package com.apiREST.API.Services;

import com.apiREST.API.Models.RubroGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroGeneralService extends BaseService<RubroGeneral, Long> {

    List<RubroGeneral> search(String filtro) throws Exception;

    Page<RubroGeneral> searchPaged(String filtro, Pageable pageable) throws Exception;

}
=======
package com.apiREST.API.Services;

import com.apiREST.API.Models.RubroGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroGeneralService extends BaseService<RubroGeneral, Long> {

    List<RubroGeneral> search(String filtro) throws Exception;

    Page<RubroGeneral> searchPaged(String filtro, Pageable pageable) throws Exception;

}
>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
