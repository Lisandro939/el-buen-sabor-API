package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.DTOABMRubroArticulo;
import com.apiREST.API.Models.RubroArticulo;
import com.apiREST.API.Services.RubroArticuloServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubrosArticulos")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl> {

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


    @GetMapping("/searchABM")
    public ResponseEntity<?> searchABM() {
        try {
            List<RubroArticulo> rubroArticulos = servicio.findAll();
            List<DTOABMRubroArticulo> dtoabmRubroArticulos = new ArrayList<>();

            for (RubroArticulo rubroArticulo: rubroArticulos){
                DTOABMRubroArticulo dtoabmRubroArticulo = new DTOABMRubroArticulo();
                dtoabmRubroArticulo.setRubro(rubroArticulo.getDenominacion());
                dtoabmRubroArticulo.setRubroPadre(rubroArticulo.getDenominacion());
                dtoabmRubroArticulo.setEstado(rubroArticulo.getEstado());
                dtoabmRubroArticulos.add(dtoabmRubroArticulo);
            }
            return ResponseEntity.status(200).body(dtoabmRubroArticulos);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
