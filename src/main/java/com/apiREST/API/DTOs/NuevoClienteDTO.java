package com.apiREST.API.DTOs;

import lombok.*;

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
