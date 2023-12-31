package com.apiREST.API.Controllers;


import com.apiREST.API.DTOs.DTOEntregaDelivery;
import com.apiREST.API.DTOs.HistorialPedidoDTO;
import com.apiREST.API.DTOs.MovimientosMonetariosDTO;
import com.apiREST.API.DTOs.PedidoAPrepararDTO;
import com.apiREST.API.Enums.EstadoPedido;
import com.apiREST.API.Enums.TipoEnvio;
import com.apiREST.API.Models.*;
import com.apiREST.API.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Date fechafiltro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(fechafiltro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam Date fechafiltro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(fechafiltro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    // Tipo Envio
    @GetMapping("/searchByTipoEnvio")
    public ResponseEntity<?> searchByTipoEnvio(@RequestParam TipoEnvio tipoEnvio) {
        try {
//            TipoEnvio tipoEnvio = TipoEnvio.valueOf(tipoenvio);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipoEnvio(tipoEnvio));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Tipo Envio no válido: " + tipoEnvio + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByTipoEnvioPaged")
    public ResponseEntity<?> searchByTipoEnvio(@RequestParam TipoEnvio tipoEnvio, Pageable pageable) {
        try {
//            TipoEnvio tipoEnvio = TipoEnvio.valueOf(tipoEnvio);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByTipoEnvio(tipoEnvio, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Tipo Envio no válido: " + tipoEnvio + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //Estado pedido
    @GetMapping("/searchByEstado")
    public ResponseEntity<?> searchByEstadoPedido(@RequestParam EstadoPedido estado) {
        try {
//            EstadoPedido estado = EstadoPedido.valueOf(Estado);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstadoPedido(estado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estado no válido: " + estado + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchByEstadoPaged")
    public ResponseEntity<?> searchByEstadoPedido(@RequestParam EstadoPedido estado, Pageable pageable) {
        try {
//            EstadoPedido estado = EstadoPedido.valueOf(Estado);
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByEstadoPedido(estado, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estado no válido: " + estado + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchbystate")
    public ResponseEntity<?> searchByState(@RequestParam EstadoPedido filtro) {
        try {
            return ResponseEntity.status(200).body(servicio.searchByState(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    //Historial pedidos
    @Autowired
    PedidoService pedidoService;
    @Autowired
    DetallePedidoService detallePedidoService;

    // Buscar historial de pedidos de un cliente
    @GetMapping("/searchHistorial")
    public ResponseEntity<?> obtenerPedidosPorClienteId(@RequestParam Long clienteId) {
        try{
            List<Pedido> pedidos = pedidoService.obtenerPedidosPorClienteId(clienteId);

            List<HistorialPedidoDTO> historialPedidosDTO = new ArrayList<>();

            for(Pedido pedido : pedidos){
                HistorialPedidoDTO historialPedidoDTO = new HistorialPedidoDTO();
                historialPedidoDTO.setFecha(pedido.getFecha());
                historialPedidoDTO.setNumero(pedido.getNumero());
                historialPedidoDTO.setTotal(pedido.getTotal());
                historialPedidosDTO.add(historialPedidoDTO);
            }

            return ResponseEntity.status(200).body(historialPedidosDTO);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    //Obtener los detalles del pedido
    @GetMapping("/detail")
    public ResponseEntity<?> detallePedido(@RequestParam int numero){
        try {
            // Obtener el pedido por su número de pedido
            Pedido pedido = (Pedido) pedidoService.obtenerPedidoPorNumero(numero);

            // Crear DTO para el detalle del pedido
            HistorialPedidoDTO historialPedidoDTO = new HistorialPedidoDTO();
            historialPedidoDTO.setFecha(pedido.getFecha());
            historialPedidoDTO.setNumero(pedido.getNumero());
            historialPedidoDTO.setTotal(pedido.getTotal());
            historialPedidoDTO.setTipoEnvio(pedido.getTipoEnvio());

            // Obtener detalles de ítems pedidos
            List<DetallePedido> detallesPedido = pedido.getDetallePedido();
            List<HistorialPedidoDTO.HistorialDetallePedidoDTO> historialDetallePedidoDTOS = new ArrayList<>();

            for (DetallePedido detalle : detallesPedido) {
                HistorialPedidoDTO.HistorialDetallePedidoDTO historialDetallePedidoDTO = new HistorialPedidoDTO.HistorialDetallePedidoDTO();

                    ArticuloManufacturado articuloManufacturado = detalle.getArticuloManufacturado();

                    // Acceder a los atributos del artículo manufacturado
                    historialDetallePedidoDTO.setCantidad(detalle.getCantidad());
                    historialDetallePedidoDTO.setSubtotal(detalle.getSubtotal());
                    historialDetallePedidoDTO.setDenominacion(articuloManufacturado.getDenominacion());
                    historialDetallePedidoDTO.setTiempoEstimadoCocina(articuloManufacturado.getTiempoEstimadoCocina());
                    historialDetallePedidoDTO.setPrecioVenta(articuloManufacturado.getPrecioVenta());
                    historialDetallePedidoDTO.setImagen(articuloManufacturado.getImagen());

                    // Agregar el DTO a la lista
                    historialDetallePedidoDTOS.add(historialDetallePedidoDTO);
            }

            historialPedidoDTO.setHistorialDetallePedidoDTOS(historialDetallePedidoDTOS);

            return ResponseEntity.status(200).body(historialPedidoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/searchFactura")
    public ResponseEntity<?> obtenerFactura(@RequestParam int numero){
        try {
            // Obtener el pedido por su número de pedido
            Pedido pedido = (Pedido) pedidoService.obtenerPedidoPorNumero(numero);

            // Crear DTO para la factura
            HistorialPedidoDTO historialPedidoDTO = new HistorialPedidoDTO();
            historialPedidoDTO.setFecha(pedido.getFecha());
            historialPedidoDTO.setNumero(pedido.getNumero());
            historialPedidoDTO.setTotal(pedido.getTotal());
            historialPedidoDTO.setTipoEnvio(pedido.getTipoEnvio());

            HistorialPedidoDTO.HistorialFacturaDTO historialFacturaDTO = new HistorialPedidoDTO.HistorialFacturaDTO();

            Factura factura = pedido.getFactura();

            historialFacturaDTO.setNumero(factura.getNumero());
            historialFacturaDTO.setFecha(factura.getFecha());
            historialFacturaDTO.setTotalCosto(factura.getTotalCosto());
            historialFacturaDTO.setTotalVenta(factura.getTotalVenta());
            historialFacturaDTO.setFormaPago(factura.getFormaPago());
            historialFacturaDTO.setNroTarjeta(factura.getNroTarjeta());

            historialPedidoDTO.setHistorialFacturaDTO(historialFacturaDTO);

            return ResponseEntity.status(200).body(historialPedidoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/searchMovimientosMonetarios")
    public ResponseEntity<?> obtenerMovimientosMonetarios(@RequestParam String desde, @RequestParam String hasta){
        try {
            List<Object[]> movimientosMonetarios = pedidoService.obtenerMovimientosMonetarios(desde, hasta);

            MovimientosMonetariosDTO movimientosMonetariosDTO = new MovimientosMonetariosDTO();
            System.out.println(movimientosMonetarios);
            movimientosMonetariosDTO.setTotalIngresos((Double) movimientosMonetarios.get(0)[0]);
            movimientosMonetariosDTO.setCostos((Double) movimientosMonetarios.get(0)[1]);
            movimientosMonetariosDTO.setGanancia((Double) movimientosMonetarios.get(0)[2]);

            return ResponseEntity.status(200).body(movimientosMonetariosDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    //Vista de pedidos en cocina (cocinero)
    @GetMapping("/searchVistaPedido")
    public ResponseEntity<?> obtenerVistaPedido(){
        try {
            EstadoPedido estado = EstadoPedido.EnCocina;

            List<Pedido> pedidosEnCocina = pedidoService.obtenerPedidosPorEstado(estado);
            List<PedidoAPrepararDTO> pedidoAPrepararDTOS = new ArrayList<>();

            for(Pedido pedido : pedidosEnCocina) {
                // Crear DTO para los pedidos
                PedidoAPrepararDTO pedidoAPrepararDTO = new PedidoAPrepararDTO();
                pedidoAPrepararDTO.setNumero(pedido.getNumero());
                pedidoAPrepararDTO.setFecha(pedido.getFecha());
                pedidoAPrepararDTO.setHoraEstimadaFin(pedido.getHoraEstimadaFin());

                pedidoAPrepararDTOS.add(pedidoAPrepararDTO);
            }
            return ResponseEntity.status(200).body(pedidoAPrepararDTOS);

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/detailCook")
    public ResponseEntity<?> detallePedidoEnCocina() {
        try {
            EstadoPedido estado = EstadoPedido.EnCocina;
            List<Pedido> pedidosEnCocina = pedidoService.obtenerPedidosPorEstado(estado);

            List<PedidoAPrepararDTO> pedidoAPrepararDTOS = new ArrayList<>();

            for (Pedido pedido : pedidosEnCocina) {
                // Crear DTO para los pedidos
                PedidoAPrepararDTO pedidoAPrepararDTO = new PedidoAPrepararDTO();
                pedidoAPrepararDTO.setNumero(pedido.getNumero());
                pedidoAPrepararDTO.setFecha(pedido.getFecha());
                pedidoAPrepararDTO.setHoraEstimadaFin(pedido.getHoraEstimadaFin());

                List<DetallePedido> detallesPedido = pedido.getDetallePedido();
                List<PedidoAPrepararDTO.DetallePedidoAPrepararDTO> detallePedidosAPreparar = new ArrayList<>();

                for (DetallePedido detalle : detallesPedido) {
                    PedidoAPrepararDTO.DetallePedidoAPrepararDTO detallePedidoAPrepararDTO = new PedidoAPrepararDTO.DetallePedidoAPrepararDTO();
                    detallePedidoAPrepararDTO.setCantidad(detalle.getCantidad());
                    ArticuloManufacturado articuloManufacturado = detalle.getArticuloManufacturado();
                    detallePedidoAPrepararDTO.setDenominacion(articuloManufacturado.getDenominacion());
                    detallePedidoAPrepararDTO.setReceta(articuloManufacturado.getReceta());
                    detallePedidoAPrepararDTO.setTiempoEstimadoCocina(articuloManufacturado.getTiempoEstimadoCocina());

                    detallePedidosAPreparar.add(detallePedidoAPrepararDTO);
                }

                pedidoAPrepararDTO.setDetallePedidosAPreparar(detallePedidosAPreparar);
                pedidoAPrepararDTOS.add(pedidoAPrepararDTO);
            }

            return ResponseEntity.status(200).body(pedidoAPrepararDTOS);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/findByDelivery")
    public ResponseEntity<?> findByDelivery() {
        try {
            List<Pedido> pedidos = servicio.findByDelivery();
            List<DTOEntregaDelivery> dtoEntregaDeliveries = new ArrayList<>();

            for (Pedido pedido: pedidos){
                DTOEntregaDelivery dtoEntregaDelivery = new DTOEntregaDelivery();
                dtoEntregaDelivery.setNumeroPedido(pedido.getNumero());
                dtoEntregaDelivery.setFecha(pedido.getFecha());
                dtoEntregaDelivery.setCliente(pedido.getCliente().getNombre());
                dtoEntregaDelivery.setCalle(pedido.getDomicilio().getCalle());
                dtoEntregaDelivery.setLocalidad(pedido.getDomicilio().getLocalidad());
                dtoEntregaDelivery.setNumeroDom(pedido.getDomicilio().getNumero());


                List<DetallePedido> detallesPedido = pedido.getDetallePedido();
                List<DTOEntregaDelivery.DTODetalleEntregaDelivery> detalleEntregaDeliveries = new ArrayList<>();

                for (DetallePedido detalle: detallesPedido){
                    DTOEntregaDelivery.DTODetalleEntregaDelivery dtoDetalleEntregaDelivery = new DTOEntregaDelivery.DTODetalleEntregaDelivery();
                    dtoDetalleEntregaDelivery.setProducto(detalle.getArticuloManufacturado().getDenominacion());
                    dtoDetalleEntregaDelivery.setCantidad(detalle.getCantidad());
                    dtoDetalleEntregaDelivery.setPrecio(detalle.getArticuloManufacturado().getPrecioVenta());
                    dtoDetalleEntregaDelivery.setSubtotal(detalle.getSubtotal());
                    detalleEntregaDeliveries.add(dtoDetalleEntregaDelivery);


                }
                dtoEntregaDelivery.setDetalleEntregaDeliveries(detalleEntregaDeliveries);
                dtoEntregaDeliveries.add(dtoEntregaDelivery);
            }

            return ResponseEntity.status(200).body(dtoEntregaDeliveries);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

}