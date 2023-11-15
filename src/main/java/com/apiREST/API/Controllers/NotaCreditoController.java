package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.NotaCreditoDTO;
import com.apiREST.API.Enums.CondicionIva;
import com.apiREST.API.Models.Factura;
import com.apiREST.API.Models.NotaCredito;
import com.apiREST.API.Services.FacturaService;
import com.apiREST.API.Services.NotaCreditoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /*
    @GetMapping("/NewNotaCredito")
    public ResponseEntity<?> newNotaCredito(@RequestParam NotaCreditoDTO notaCreditoDTO){
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

            //Traer todas las facturas realizadas
            List<Factura> facturas = FacturaService.findAll();

            //Recorremos todas las Facturas encontradas
            Factura facturaEncontrada = null;
            for (Factura factura : facturas) {
                if ((factura.getNumero())==(notaCreditoDTO.getNroComprobante())) {
                    facturaEncontrada = factura;
                    break; // Rompe el bucle cuando se encuentra la factura
                }
            }

            if (facturaEncontrada == null) {
                return ResponseEntity.status(404).body("No se encontró la factura con el número de comprobante proporcionado");
            }
            //hacemos relacion
            facturaEncontrada.setNotaCredito(notaCredito);
            //guardamos la nota de credito
            servicio.save(notaCredito);
            //Devolvemoms con exito nuestra nota de credito
            return new ResponseEntity<>("Nota de Credito creada exitosamente", HttpStatus.CREATED);

        } catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    */
}
