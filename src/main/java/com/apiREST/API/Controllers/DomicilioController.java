package com.apiREST.API.Controllers;

import com.apiREST.API.Models.Domicilio;
import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Services.DomicilioServiceImpl;
import com.apiREST.API.Services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl> {

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
}