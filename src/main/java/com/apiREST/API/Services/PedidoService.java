package com.apiREST.API.Services;

import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Pedido> search(String filtro) throws Exception;

    Page<Pedido> searchPaged(String filtro, Pageable pageable) throws Exception;

}
