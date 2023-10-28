<<<<<<< HEAD
package com.apiREST.API.Controllers;

import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Models.RubroArticulo;
import com.apiREST.API.Models.RubroGeneral;
import com.apiREST.API.Services.PedidoServiceImpl;
import com.apiREST.API.Services.RubroArticuloServiceImpl;
import com.apiREST.API.Services.RubroGeneralServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubrosGenerales")
public class RubroGeneralController extends BaseControllerImpl<RubroGeneral, RubroGeneralServiceImpl> {

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
=======
package com.apiREST.API.Controllers;

import com.apiREST.API.Models.Pedido;
import com.apiREST.API.Models.RubroArticulo;
import com.apiREST.API.Models.RubroGeneral;
import com.apiREST.API.Services.PedidoServiceImpl;
import com.apiREST.API.Services.RubroArticuloServiceImpl;
import com.apiREST.API.Services.RubroGeneralServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubrosGenerales")
public class RubroGeneralController extends BaseControllerImpl<RubroGeneral, RubroGeneralServiceImpl> {

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
>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
