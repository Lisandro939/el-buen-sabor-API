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
@Table(name = "articuloManufacturado")
public class ArticuloManufacturado extends BaseEntidad {

    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private String imagen;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "articuloManufacturadoDetalle_id", referencedColumnName = "id")
    @Builder.Default
    private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalle = new ArrayList<>();

    public void agregarArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
        this.articuloManufacturadoDetalle.add(articuloManufacturadoDetalle);
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubroGeneral_id", referencedColumnName = "id")
    @Builder.Default
    private RubroGeneral rubroGeneral = new RubroGeneral();

}
