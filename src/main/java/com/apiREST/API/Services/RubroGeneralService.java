package com.apiREST.API.Services;

import com.apiREST.API.Models.RubroGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroGeneralService extends BaseService<RubroGeneral, Long> {

    List<RubroGeneral> search(String filtro) throws Exception;

    Page<RubroGeneral> search(String filtro, Pageable pageable) throws Exception;

}