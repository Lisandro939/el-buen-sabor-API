package com.apiREST.API.Services;

import com.apiREST.API.DTOs.RankingClientesDTO;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {

    List<Cliente> search(String filtro) throws Exception;

    Page<Cliente> searchPaged(String filtro, Pageable pageable) throws Exception;

    String login(String email, String clave) throws Exception;

    Cliente findByEmail(String email) throws Exception;

    List<RankingClientesDTO> rankingClientes(String rubro, String desde, String hasta) throws Exception;

    //Enlistar los Todos los Clientes
    List<Cliente> obtenerListaCliente() throws Exception;
}
