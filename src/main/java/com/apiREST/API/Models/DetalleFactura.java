package com.apiREST.API.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "detalleFactura")
public class DetalleFactura extends BaseEntidad {

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
