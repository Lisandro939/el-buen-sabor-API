package com.apiREST.API.Controllers;

import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos")

public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam int numero) {
        try {
            return ResponseEntity.status(200).body(servicio.search(numero));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/searchpaged")
    public ResponseEntity<?> search(@RequestParam int numero, Pageable pageable) {
        try {
            return ResponseEntity.status(200).body(servicio.search(numero, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
