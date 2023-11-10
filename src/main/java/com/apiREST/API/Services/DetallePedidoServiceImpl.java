package com.apiREST.API.Services;

import com.apiREST.API.DTOs.HistorialPedidoDTO;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.DetallePedido;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.ClienteRepository;
import com.apiREST.API.Repositories.DetallePedidoRepository;
import com.apiREST.API.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido,Long> implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetallePedido> obtenerSubtotal(int numeroPedido) {
        return null;
    }

    @Override
    public List<HistorialPedidoDTO.HistorialDetallePedidoDTO> obtenerDetalle(int numeroPedido) throws Exception {
        try {
            System.out.println("Estoy en el service");
            return detallePedidoRepository.obtenerDetalle(numeroPedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Métodos ya implementados...




}
