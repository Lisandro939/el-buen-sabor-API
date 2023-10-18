package com.apiREST.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

// YES

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class Usuario extends BaseEntidad {

    private String usuario;
    private String clave;
    private String rol;

}
