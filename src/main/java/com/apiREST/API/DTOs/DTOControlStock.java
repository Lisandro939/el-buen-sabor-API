package com.apiREST.API.DTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOControlStock {
    private String nombre;
    private String rubro;
    private double precioCosto;
    private double stockMinimo;
    private double stockActual;
    private String unidadMedida;
    private String estado;
}
