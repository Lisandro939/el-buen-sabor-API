package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankingClientesDTO {

    private String nombreCliente;

    private String apellidoCliente;

    private BigDecimal cantidadTotalComprada;

    private double importeTotalComprado;
}
