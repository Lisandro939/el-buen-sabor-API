package com.apiREST.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "domicilio")
public class Domicilio extends BaseEntidad {

    private String calle;
    private int numero;
    private String localidad;

}
