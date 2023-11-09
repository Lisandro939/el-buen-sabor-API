package com.apiREST.API.Services;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService extends BaseService<Empleado, Long> {

    List<Cliente> search(String filtro) throws Exception;

    Page<Cliente> searchPaged(String filtro, Pageable pageable) throws Exception;

}
