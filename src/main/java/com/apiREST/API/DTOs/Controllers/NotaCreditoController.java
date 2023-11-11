package com.apiREST.API.Controllers;

import com.apiREST.API.Models.NotaCredito;
import com.apiREST.API.Services.NotaCreditoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
