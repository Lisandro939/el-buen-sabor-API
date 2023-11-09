package com.apiREST.API.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuevoClienteDTO {

    private String nombre;

    private String apellido;

    private String calle;

    private int numero;

    private String localidad;

    private long telefono;

    private String email;

    private String clave;

}
