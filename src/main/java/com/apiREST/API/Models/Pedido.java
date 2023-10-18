package com.apiREST.API.Models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedido")
public class Pedido extends BaseEntidad {

    @Column(name = "fecha", length = 50, nullable = false)
    private Date fecha;

    @Column(name = "numero", length = 50, nullable = false)
    private int numero;

    @Column(name = "hora_estimada_fin", length = 50, nullable = false)
    private Time horaEstimadaFin;

    @Column(name = "tipo_envio", length = 50, nullable = false)
    private int tipoEnvio;

    @Column(name = "total", length = 50, nullable = false)
    private double total;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "mercadoPagoDatos_id", referencedColumnName = "id")
    @Builder.Default
    private MercadoPagoDatos mercadoPagoDatos = new MercadoPagoDatos();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    @Builder.Default
    private Factura factura = new Factura();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    @Builder.Default
    private Domicilio domicilio = new Domicilio();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "datellePedido_id", referencedColumnName = "id")
    @Builder.Default
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido detallePedido) {
        this.detallePedido.add(detallePedido);
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @Builder.Default
    private Cliente cliente = new Cliente();

}
