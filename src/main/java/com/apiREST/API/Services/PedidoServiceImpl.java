package com.apiREST.API.Services;

import com.apiREST.API.Enums.EstadoPedido;
import com.apiREST.API.Enums.TipoEnvio;
import com.apiREST.API.Models.ArticuloInsumo;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.ClienteRepository;
import com.apiREST.API.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> search(Date fechafiltro) throws Exception {
        try {
            return pedidoRepository.search(fechafiltro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(Date fechafiltro, Pageable pageable) throws Exception {
        try {
            return pedidoRepository.search(fechafiltro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    // Método para filtrar por tipo de envío
    @Override
    public List<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio) throws Exception {
        try {
            return pedidoRepository.searchByTipoEnvio(tipoEnvio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> searchByTipoEnvio(TipoEnvio tipoEnvio, Pageable pageable) throws Exception {
        try {
            return pedidoRepository.searchByTipoEnvio(tipoEnvio, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Método para filtrar por estado del pedido
    @Override
    public List<Pedido> searchByEstadoPedido(EstadoPedido estado) throws Exception {
        try {
            return pedidoRepository.searchByEstadoPedido(estado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> searchByState(EstadoPedido filtro) throws Exception {
        try {
            List<Pedido> entities = pedidoRepository.searchByState(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> searchByEstadoPedido(EstadoPedido estado, Pageable pageable) throws Exception {
        try {
            return pedidoRepository.searchByEstadoPedido(estado, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> obtenerPedidosPorClienteId(Long clienteId) throws Exception {
        try {
            List<Pedido> entities = pedidoRepository.findByClienteId(clienteId);
            return pedidoRepository.findByClienteId(clienteId);
        } catch (Exception e) {
            throw new Exception("Error al obtener pedidos por clienteId: " + e.getMessage());
        }
    }

    @Override
    public Pedido obtenerPedidoPorNumero(int numero) throws Exception {
        try {

            return pedidoRepository.findByNumeroPedido(numero)
                    .orElseThrow(() -> new NoSuchElementException("Pedido no encontrado"));
        } catch (Exception e) {
            throw new Exception("Error al obtener pedido por número: " + e.getMessage());
        }
    }

    @Override
    public List<Object[]> obtenerMovimientosMonetarios(String desde, String hasta) throws Exception {
        try {
            return pedidoRepository.obtenerMovimientosMonetarios(desde, hasta);
        } catch (Exception e) {
            throw new Exception("Error al obtener movimientos monetarios: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> obtenerPedidosPorEstado(EstadoPedido estado) throws Exception {
        try {

            return pedidoRepository.findByEstado(estado);
        } catch (Exception e) {
            throw new Exception("Error al obtener pedidos por estado: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> findByDelivery() throws Exception{
        try {
            return pedidoRepository.findByDelivery();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
