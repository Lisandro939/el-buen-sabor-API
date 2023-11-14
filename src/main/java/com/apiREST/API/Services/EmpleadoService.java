package com.apiREST.API.Services;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService extends BaseService<Empleado, Long> {

    List<Empleado> search(String filtro) throws Exception;

    Page<Empleado> searchPaged(String filtro, Pageable pageable) throws Exception;

    List<Empleado> obtenerListaEmpleado() throws Exception;

    String login(String email, String clave) throws Exception;

    Empleado findByEmail(String email) throws Exception;
}
