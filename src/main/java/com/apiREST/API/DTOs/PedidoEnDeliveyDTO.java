package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEnDeliveyDTO {
    private int numero;
    private Date fecha;
    private String nombre;
    private String apellido;
    private String calle;
    private int numeroCalle;
    private String localidad;
    private long telefono;


}


