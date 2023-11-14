package com.apiREST.API.DTOs;

import com.apiREST.API.Enums.Rol;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ListaEmpleadoDTO {
    private String nombre;
    private String apellido;
    private Rol rol;
    private String email;
    private long telefono;
    private String calle;
    private int numero;
    private String localidad;
    private String estado;
}
