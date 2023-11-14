package com.apiREST.API.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "empleado")
public class Empleado extends BaseEntidad {

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "telefono", length = 20, nullable = false)
    private long telefono;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "fecha_baja", length = 50, nullable = true)
    private Date fechaBaja;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    @Builder.Default
    private Domicilio domicilio = new Domicilio();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @Builder.Default
    private Usuario usuario = new Usuario();
}
