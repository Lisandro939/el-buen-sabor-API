package com.apiREST.API.Services;

import com.apiREST.API.Enums.EstadoPedido;
import com.apiREST.API.Enums.TipoEnvio;
import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Pedido> search(Date fechafiltro) throws Exception;

    Page<Pedido> search(Date fechafiltro, Pageable pageable) throws Exception;

    List<Pedido> searchByState(EstadoPedido filtro) throws Exception;

    List<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio) throws Exception;

    Page<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable) throws Exception;

    List<Pedido> searchByEstadoPedido(EstadoPedido estado) throws Exception;

    Page<Pedido> searchByEstadoPedido(EstadoPedido estado, Pageable pageable) throws Exception;

}
