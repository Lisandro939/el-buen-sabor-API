package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.DTOABMRubroArticulo;
import com.apiREST.API.DTOs.DTOABMRubroGeneral;
import com.apiREST.API.Models.RubroArticulo;
import com.apiREST.API.Models.RubroGeneral;
import com.apiREST.API.Services.RubroGeneralServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping("/searchABM")
    public ResponseEntity<?> searchABM() {
        try {
            List<RubroGeneral> rubroGenerals = servicio.findAll();
            List<DTOABMRubroArticulo> dtoabmRubroGeneral = new ArrayList<>();

            for (RubroGeneral rubroGeneral: rubroGenerals){
                DTOABMRubroGeneral dtoabmRubroGeneral1 = new DTOABMRubroGeneral();
                dtoabmRubroGeneral.setRubro(rubroGeneral.getDenominacion());
                dtoabmRubroGeneral.setRubroPadre(rubroGeneral.getDenominacion());
                dtoabmRubroGeneral.setEstado(rubroGeneral.getEstado());
                dtoabmRubroGeneral.add(dtoabmRubroGeneral);
            }
            return ResponseEntity.status(200).body(dtoabmRubroGeneral);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
