package com.apiREST.API.Models;

import com.apiREST.API.Enums.EstadoMercadoPago;
import com.apiREST.API.Enums.EstadoPedido;
import com.apiREST.API.Enums.FormaPago;
import com.apiREST.API.Enums.MetodoPago;
import jakarta.persistence.*;
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

    @Column(name = "forma_pago", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @Column(name = "metodo_pago", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    private String nroTarjeta;

    @Column(name = "estado", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoMercadoPago estado;
}
