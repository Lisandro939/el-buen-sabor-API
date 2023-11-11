package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoAPrepararDTO {
    private int numero;
    private Date fecha;
    private Time horaEstimadaFin;
    List<DetallePedidoAPrepararDTO> detallePedidosAPreparar;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetallePedidoAPrepararDTO {
        private int cantidad;
        private String denominacion;
        private String receta;
        private int tiempoEstimadoCocina;
    }

}
