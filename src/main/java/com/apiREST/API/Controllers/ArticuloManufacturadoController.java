package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.ProductoDTO;
import com.apiREST.API.Enums.EstadoArticulo;
import com.apiREST.API.Enums.NivelStock;
import com.apiREST.API.Models.ArticuloManufacturado;
import com.apiREST.API.Models.RubroGeneral;
import com.apiREST.API.Services.ArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articulosManufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {

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

    @GetMapping("/ranking")
    public ResponseEntity<?> ranking(@RequestParam String producto, String desde, String hasta) {
        try {
            return ResponseEntity.status(200).body(servicio.ranking(producto, desde, hasta));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/newProduct")
    public ResponseEntity<?> newProduct(@RequestBody ProductoDTO productoDTO){
        try {
            ArticuloManufacturado articulomanufacturado = new ArticuloManufacturado();

            //Cargamos los datos al nuevo articuloManufacturado
            articulomanufacturado.setDenominacion(productoDTO.getProducto());
            articulomanufacturado.setStockMinimo(productoDTO.getStockMinimo());
            articulomanufacturado.setStockActual(productoDTO.getStockActual());
            articulomanufacturado.setPrecioCosto(productoDTO.getPrecioDeCosto());
            articulomanufacturado.setPrecioVenta(productoDTO.getPrecioDeVenta());
            articulomanufacturado.setTiempoEstimadoCocina(productoDTO.getTiempoEnCocina());
            articulomanufacturado.setUnidadMedida(productoDTO.getUnidadDeMedida());
            articulomanufacturado.setReceta(productoDTO.getReceta());

            //Designamos el nivel de stock inicial
            if((articulomanufacturado.getStockActual()) > (articulomanufacturado.getStockMinimo())){
                articulomanufacturado.setNivelStock(NivelStock.Alto);
            }
            else {
                articulomanufacturado.setNivelStock(NivelStock.Bajo);
            }

            //Designamos el Estado de nuestro articulo
            articulomanufacturado.setEstadoArticulo(EstadoArticulo.Alta);

            //Cargamos el Rubro
            RubroGeneral rubroGeneral = new RubroGeneral();
            rubroGeneral.setDenominacion(productoDTO.getRubro());

            //le asociamos el rubro a el articuloManufacturado
            articulomanufacturado.setRubroGeneral(rubroGeneral);

            //Guardamos
            servicio.save(articulomanufacturado);

            return new ResponseEntity<>("articulo creado exitosamente", HttpStatus.CREATED);

        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/modifyProduct")
    public ResponseEntity<?> modifyProduct(@RequestParam ProductoDTO productoDTO){
      try{
          //Buscamos el articulo a modificar
          ArticuloManufacturado articuloManufacturado = servicio.findByName(productoDTO.getProducto());

          //Llenamos los datos
          articuloManufacturado.setDenominacion(productoDTO.getProducto());
          articuloManufacturado.setStockMinimo(productoDTO.getStockMinimo());
          articuloManufacturado.setStockActual(productoDTO.getStockActual());
          articuloManufacturado.setPrecioCosto(productoDTO.getPrecioDeCosto());
          //Creamos el rubro y lo agregamos
          RubroGeneral rubroGeneral = new RubroGeneral();
          rubroGeneral.setDenominacion(productoDTO.getRubro());
          articuloManufacturado.setRubroGeneral(rubroGeneral);
          //Guardamos Cambios
          servicio.save(articuloManufacturado);
          //Devolvemos la response
          return new ResponseEntity<>("articulo modificado exitosamente", HttpStatus.OK);



      } catch (Exception e){
          return ResponseEntity.status(500).body(e.getMessage());
      }
    }


}
