package com.apiREST.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mercadoPagoDatos")
public class MercadoPagoDatos extends BaseEntidad {

    private long identificadorPago;
    private Date fechaCreacion;
    private Date fechaAprobacion;
    private String formaPago;
    private String metodoPago;
    private String nroTarjeta;
    private String estado;
}
