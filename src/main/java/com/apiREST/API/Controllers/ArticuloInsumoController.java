package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.DTOCompraIngrediente;
import com.apiREST.API.DTOs.DTOControlStock;
import com.apiREST.API.Models.ArticuloInsumo;
import com.apiREST.API.Services.ArticuloInsumoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulosInsumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(200).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/searchByStock")
    public ResponseEntity<?> searchByStock(){
        try {
           List<ArticuloInsumo> articulosInsumo = servicio.searchByStock();
           List<DTOControlStock> dtoControlStocks = new ArrayList<>();

           for (ArticuloInsumo articuloInsumo: articulosInsumo){
               DTOControlStock dtoControlStock = new DTOControlStock();
               dtoControlStock.setNombre(articuloInsumo.getDenominacion());
               dtoControlStock.setRubro(articuloInsumo.getRubroArticulo().getDenominacion());
               dtoControlStock.setPrecioCosto(articuloInsumo.getPrecioCompra());
               dtoControlStock.setStockMinimo(articuloInsumo.getStockMinimo());
               dtoControlStock.setStockActual(articuloInsumo.getStockActual());
               dtoControlStock.setEstado(articuloInsumo.getEstado());
               dtoControlStock.setUnidadMedida(articuloInsumo.getUnidadMedida());
               dtoControlStocks.add(dtoControlStock);
           }
           return ResponseEntity.status(200).body(dtoControlStocks);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/searchByEstado")
    public ResponseEntity<?> searchByEstado(){
        try {
             List<ArticuloInsumo> articulosInsumo = servicio.searchByEstado();
             List<DTOCompraIngrediente> dtoCompraIngredientes = new ArrayList<>();

             for (ArticuloInsumo articuloInsumo: articulosInsumo){
                 DTOCompraIngrediente dtoCompraIngrediente = new DTOCompraIngrediente();
                 dtoCompraIngrediente.setNombre(articuloInsumo.getDenominacion());
                 dtoCompraIngredientes.add(dtoCompraIngrediente);
             }

            return ResponseEntity.status(200).body(dtoCompraIngredientes);


        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde.\"}");
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
