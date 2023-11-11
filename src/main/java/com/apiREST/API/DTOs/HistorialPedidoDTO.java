package com.apiREST.API.DTOs;

import com.apiREST.API.Enums.FormaPago;
import com.apiREST.API.Enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialPedidoDTO {
    private Date fecha;
    private int numero;
    private double total;
    private TipoEnvio tipoEnvio;
    private List<HistorialDetallePedidoDTO> historialDetallePedidoDTOS;
    private HistorialFacturaDTO historialFacturaDTO;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HistorialDetallePedidoDTO {
        private int cantidad;
        private double subtotal;
        private int tiempoEstimadoCocina;
        private String denominacion;
        private double precioVenta;
        private String imagen;

    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HistorialFacturaDTO {

        private Date fecha;
        private int numero;
        private double montoDescuento;
        private FormaPago formaPago;
        private String nroTarjeta;
        private double totalVenta;
        private double totalCosto;
    }
}
