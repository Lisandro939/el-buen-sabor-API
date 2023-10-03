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
@Table(name = "articuloInsumo")
public class ArticuloInsumo extends BaseEntidad {

    private String denominacion;
    private double precioCompra;
    private double precioVenta;
    private double stockActual;
    private double stockMinimo;
    private String unidadMedida;
    private boolean esInsumo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "articuloManufacturadoDetalle_id", referencedColumnName = "id")
    @Builder.Default
    private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalle = new ArrayList<>();

    public void agregarArticuloManufacturadoDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
        this.articuloManufacturadoDetalle.add(articuloManufacturadoDetalle);
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubroArticulo_id", referencedColumnName = "id")
    @Builder.Default
    private RubroArticulo rubroArticulo = new RubroArticulo();


}
