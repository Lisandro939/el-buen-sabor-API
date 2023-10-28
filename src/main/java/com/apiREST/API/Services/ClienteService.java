package com.apiREST.API.Services;

import com.apiREST.API.Models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {

    List<Cliente> search(String filtro) throws Exception;

    Page<Cliente> searchPaged(String filtro, Pageable pageable) throws Exception;

}
