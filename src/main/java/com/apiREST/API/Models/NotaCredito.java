package com.apiREST.API.Models;

import com.apiREST.API.Enums.CondicionIva;
import com.apiREST.API.Enums.FormaPago;
import com.apiREST.API.Enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notaCredito")
public class NotaCredito extends BaseEntidad{

    //Datos Nota Credito
    private Date fechaNotaCredito;
    private CondicionIva condicionIva;
    private TipoDocumento tipoDocumento;
    private int nroDocumento;


    //Datos Comprobante a anular
    private FormaPago condicionVenta;
    private int puntoVenta;
    private int nroComprobante;
    private Date fechaEmision;

}
