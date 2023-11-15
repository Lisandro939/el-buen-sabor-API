package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOEntregaDelivery {
    private int numeroPedido;
    private Date fecha;
    private String cliente;
    private String calle;
    private int numeroDom;
    private String localidad;
    List<DTODetalleEntregaDelivery> detalleEntregaDeliveries;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DTODetalleEntregaDelivery{
        private String producto;
        private int cantidad;
        private double precio;
        private double subtotal;

    }

}
