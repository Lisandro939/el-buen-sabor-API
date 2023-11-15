package com.apiREST.API.Models;

import com.apiREST.API.Enums.EstadoArticulo;
import com.apiREST.API.Enums.NivelStock;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "articuloManufacturado")
public class ArticuloManufacturado extends BaseEntidad {


    private String denominacion;
    private double precioVenta;
    private double precioCosto;
    private int tiempoEstimadoCocina;
    private String receta;
    private String imagen;
    private int stockMinimo;
    private int stockActual;
    private String unidadMedida;
    private NivelStock nivelStock;
    private EstadoArticulo estadoArticulo;

    @Column(name = "fecha_baja", length = 50, nullable = true)
    private Date fechaBaja;

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
