package com.apiREST.API.Controllers;

import com.apiREST.API.Enums.EstadoPedido;
<<<<<<< HEAD
=======
import com.apiREST.API.Enums.TipoEnvio;
>>>>>>> 44c05cecbd3d8fb02659d5de016e249514ef8c43
import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
}
