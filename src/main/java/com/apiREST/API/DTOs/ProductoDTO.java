package com.apiREST.API.DTOs;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ProductoDTO {

    private String producto;
    private String rubro;
    private int precioDeCosto;
    private int precioDeVenta;
    private int tiempoEnCocina;
    private int stockMinimo;
    private int stockActual;
    private String receta;
    private String unidadDeMedida;
    private String nivelDeStock;
    private String estado;

}
