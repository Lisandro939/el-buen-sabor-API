package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListaClienteDTO {
    private String nombre;
    private String apellido;
    private String email;
    private long telefono;
    private String calle;
    private int numero;
    private String localidad;
    //Estado Cliente

}
