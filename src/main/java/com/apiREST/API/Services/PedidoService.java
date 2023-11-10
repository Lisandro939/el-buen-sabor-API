package com.apiREST.API.Services;

import com.apiREST.API.DTOs.HistorialPedidoDTO;
import com.apiREST.API.Enums.EstadoPedido;
import com.apiREST.API.Enums.TipoEnvio;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Pedido> search(Date fechafiltro) throws Exception;

    Page<Pedido> search(Date fechafiltro, Pageable pageable) throws Exception;

    List<Pedido> searchByState(EstadoPedido filtro) throws Exception;

    List<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio) throws Exception;

    Page<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable) throws Exception;

    List<Pedido> searchByEstadoPedido(EstadoPedido estado) throws Exception;

    //historial pedidos
    Page<Pedido> searchByEstadoPedido(EstadoPedido estado, Pageable pageable) throws Exception;

    List<Pedido> obtenerPedidosPorClienteId(Long clienteId) throws Exception;

    Pedido obtenerPedidoPorNumero(int numero) throws Exception;





}