package com.apiREST.API.Controllers;

import com.apiREST.API.Enums.EstadoPago;
import com.apiREST.API.Models.*;
import com.apiREST.API.Services.FacturaService;
import com.apiREST.API.Services.FacturaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(200).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/searchpaged")
    public ResponseEntity<?> searchPaged(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(200).body(servicio.searchPaged(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PostMapping("/newFactura")
    public ResponseEntity<?> newFactura(@RequestBody Pedido pedido) {
        try {

            if (pedido.getEstadoPago().equals(EstadoPago.Pagado)) {
                Factura factura = new Factura();
                //seteamos el total
                factura.setTotalVenta(pedido.getTotal());
                //Seteamos la fecha de hoy
                LocalDateTime now = LocalDateTime.now();
                Date fechaActual = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
                factura.setFecha((java.sql.Date) fechaActual);
                //Seteamos los demas atributos
                //Buscamos las facturas
                List<Factura> facturas = servicio.findAll();
                //Buscamos la ultima factura
                int nroComprobante = 0;

                for (Factura factura1 : facturas) {
                    nroComprobante = 0;
                    nroComprobante = factura1.getNumero();
                }

                factura.setNumero(nroComprobante);

                //Seteamos total del costo
                double totalcosto = 0;
                List<DetallePedido> detallePedidos = pedido.getDetallePedido();
                for (DetallePedido detallePedido : detallePedidos) {
                    ArticuloManufacturado articuloManufacturado = detallePedido.getArticuloManufacturado();
                    totalcosto += articuloManufacturado.getPrecioCosto();
                }

                factura.setTotalCosto(totalcosto);

                servicio.save(factura);
            }

            throw new RuntimeException("El pedido esta impago");

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
            }
        }
    }

