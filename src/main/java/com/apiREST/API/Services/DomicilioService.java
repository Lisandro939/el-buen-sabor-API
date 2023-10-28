package com.apiREST.API.Services;

import com.apiREST.API.Models.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long> {

    List<Domicilio> search(String filtro) throws Exception;

    Page<Domicilio> searchPaged(String filtro, Pageable pageable) throws Exception;

}
