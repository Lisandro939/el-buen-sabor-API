package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.NotaCreditoDTO;
import com.apiREST.API.Enums.CondicionIva;
import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.NotaCredito;
import com.apiREST.API.Services.FacturaService;
import com.apiREST.API.Services.NotaCreditoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/notaCredito")
public class NotaCreditoController extends BaseControllerImpl<NotaCredito, NotaCreditoServiceImpl>{

    @GetMapping("/searchByNroDoc")
    public ResponseEntity<?> searchByNroDoc(@RequestParam int nroDocumento){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByNroDoc(nroDocumento));

        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Tipo nroDoc no válido: " + nroDocumento + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    };

    @Autowired
    FacturaService facturaService;

    @GetMapping("/NewNotaCredito")
    public ResponseEntity<?> newNotaCredito(@RequestBody NotaCreditoDTO notaCreditoDTO){
        try {
            //Cargar Nueva nota credito
            NotaCredito notaCredito = new NotaCredito();

            //Cargamos datos a la nota de credito
            notaCredito.setFechaNotaCredito(notaCreditoDTO.getFechaNotaCredito());
            notaCredito.setCondicionIva(notaCreditoDTO.getCondicionIva());
            notaCredito.setNroDocumento(notaCreditoDTO.getNroDocumento());
            notaCredito.setTipoDocumento(notaCreditoDTO.getTipoDocumento());
            notaCredito.setNroComprobante(notaCreditoDTO.getNroComprobante());
            notaCredito.setCondicionVenta(notaCreditoDTO.getCondicionVenta());

            // Establecer la fecha y hora actuales
            LocalDateTime now = LocalDateTime.now();
            Date fechaActual = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            notaCredito.setFechaNotaCredito(fechaActual);

            //Buscar factura a traves del metodo
            Factura factura = facturaService.findByNroComprobante(notaCreditoDTO.getNroComprobante());

            //Si la factura en cuestion no existe anulamos la creacion
            if(factura == null){
                throw new RuntimeException("La facura ingresada no existe");
            }
            if((factura.getNotaCredito()) != null){
                throw new RuntimeException("La factura ingresada ya tiene otra Nota de Credito");
            }

            //asociamos la nota de credito a la factura
            factura.setNotaCredito(notaCredito);

            //Guardamos la nota de credito y la factura
            facturaService.save(factura);

            return new ResponseEntity<>("Nota de Credito creado exitosamente", HttpStatus.CREATED);

        } catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
