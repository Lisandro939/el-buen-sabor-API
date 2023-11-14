package com.apiREST.API.DTOs;

import com.apiREST.API.Enums.Rol;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class NuevoEmpleadoDTO {
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private String claveProvisoria;
    private String calle;
    private int numero;
    private String localidad;
    private Rol rol;
}
