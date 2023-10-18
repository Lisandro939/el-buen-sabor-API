package com.apiREST.API.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "detallePedido")
public class DetallePedido extends BaseEntidad {

    private int cantidad;
    private double subtotal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "articuloManufacturado_id", referencedColumnName = "id")
    @Builder.Default
    private ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "articuloInsumo_id", referencedColumnName = "id")
    @Builder.Default
    private ArticuloInsumo articuloInsumo = new ArticuloInsumo();

}
