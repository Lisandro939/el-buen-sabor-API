package com.apiREST.API.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosClienteDTO {

    private String nombre;

    private String apellido;

    private long telefono;

    private String email;

    private String clave;

    private String fechaNacimiento;

    private String calle;

    private int numero;

    private String localidad;

}
