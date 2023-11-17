package com.apiREST.API.Models;

import com.apiREST.API.Enums.FormaPago;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factura")
public class Factura extends BaseEntidad {

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private int numero;
    private double montoDescuento;

    @Column(name = "forma_pago", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    private String nroTarjeta;
    private double totalVenta;
    private double totalCosto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "detalleFactura_id", referencedColumnName = "id")
    @Builder.Default
    private List<DetalleFactura> detalleFactura = new ArrayList<>();

    @OneToOne(cascade= CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
    @JoinColumn(name = "notaCredito_id", referencedColumnName = "id", nullable = true)
    @Builder.Default
    private NotaCredito notaCredito = new NotaCredito();

    public void agregarDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura.add(detalleFactura);
    }

}
