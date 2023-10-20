package com.apiREST.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "articuloManufacturadoDetalle")
public class ArticuloManufacturadoDetalle extends BaseEntidad {

    private double cantidad;
    private String unidadMedida;

}
