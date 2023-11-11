package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientosMonetariosDTO {

    private double totalIngresos;

    private double costos;

    private double ganancia;
}
