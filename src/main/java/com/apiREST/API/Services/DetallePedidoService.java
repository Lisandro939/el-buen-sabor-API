package com.apiREST.API.Services;

import com.apiREST.API.DTOs.HistorialPedidoDTO;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.DetallePedido;

import java.util.List;

public interface DetallePedidoService extends BaseService<DetallePedido, Long>{

    List<DetallePedido> obtenerSubtotal(int numeroPedido);
    List<HistorialPedidoDTO.HistorialDetallePedidoDTO> obtenerDetalle(int numeroPedido) throws Exception;

}
