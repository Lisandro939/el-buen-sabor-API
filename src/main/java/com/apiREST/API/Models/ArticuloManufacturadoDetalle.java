package com.apiREST.API.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "articuloManufacturadoDetalle")
public class ArticuloManufacturadoDetalle extends BaseEntidad {

    private double cantidad;
    private String unidadMedida;

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "articuloManufacturadoDetalle_id", referencedColumnName = "id")
    @Builder.Default
    private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalle = new ArrayList<>();*/

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "articuloInsumo_id", referencedColumnName = "id")
    @Builder.Default
    private ArticuloInsumo articuloInsumo = new ArticuloInsumo();

}
