package com.apiREST.API.Models;

import com.apiREST.API.Enums.Rol;
import jakarta.persistence.*;
import lombok.*;

// YES

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class Usuario extends BaseEntidad {

    @Column(name = "usuario", length = 50, nullable = false)
    private String usuario;

    @Column(name = "clave", length = 50, nullable = false)
    private String clave;

    @Column(name = "rol", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
