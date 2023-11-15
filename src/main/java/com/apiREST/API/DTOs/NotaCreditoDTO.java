package com.apiREST.API.DTOs;


import com.apiREST.API.Enums.CondicionIva;
import com.apiREST.API.Enums.FormaPago;
import com.apiREST.API.Enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaCreditoDTO {
    
    private Date fechaNotaCredito;
    private CondicionIva condicionIva;
    private TipoDocumento tipoDocumento;
    private int nroDocumento;
    private FormaPago condicionVenta;
    private int puntoVenta;
    private int nroComprobante;
    private Date fechaEmision;
}
