package com.apiREST.API;

import com.apiREST.API.Models.*;
import com.apiREST.API.Repositories.ClienteRepository;
import com.apiREST.API.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;

@SpringBootApplication
public class ApiApplication {

	@Autowired
	PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("API REST corriendo en http://localhost:8080/");
	}

	@Bean
	CommandLineRunner init2(PedidoRepository pedidoRepository) {
		return args -> {

			ArticuloManufacturadoDetalle articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder()
					.cantidad(10)
					.unidadMedida("kg")
					.build();

			RubroArticulo rubroArticulo = RubroArticulo.builder()
					.denominacion("Comida")
					.build();

			RubroGeneral rubroGeneral = RubroGeneral.builder()
					.denominacion("Comida")
					.build();

			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.tiempoEstimadoCocina(20)
					.denominacion("Hamburguesa")
					.precioVenta(1000.00)
					.imagen("https://www.google.com/url?imagen=hamburguesa")
					.rubroGeneral(rubroGeneral)
					.build();

			articuloManufacturado.agregarArticuloManufacturadoDetalle(articuloManufacturadoDetalle);

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
					.denominacion("Carne")
					.precioCompra(800.00)
					.precioVenta(1000.00)
					.stockActual(100)
					.stockMinimo(10)
					.unidadMedida("kg")
					.esInsumo(true)
					.rubroArticulo(rubroArticulo)
					.build();

			articuloInsumo.agregarArticuloManufacturadoDetalle(articuloManufacturadoDetalle);

			DetalleFactura detalleFactura = DetalleFactura.builder()
					.cantidad(10)
					.subtotal(1000.00)
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumo)
					.build();

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(10)
					.subtotal(1000.00)
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumo)
					.build();


			MercadoPagoDatos mercadoPagoDatos = MercadoPagoDatos.builder()
					.identificadorPago(123456789)
					.fechaCreacion(Date.valueOf("2021-06-01"))
					.fechaAprobacion(Date.valueOf("2021-06-01"))
					.formaPago("efectivo")
					.metodoPago("efectivo")
					.nroTarjeta("123456789")
					.estado("aprobado")
					.build();

			Factura factura = Factura.builder()
					.fecha(Date.valueOf("2021-06-01"))
					.numero(1000)
					.montoDescuento(10.00)
					.formaPago("efectivo")
					.nroTarjeta("123456789")
					.totalVenta(1000.00)
					.totalCosto(800.00)
					.build();

			factura.agregarDetalleFactura(detalleFactura);

			Usuario usuario = Usuario.builder()
					.usuario("juan.perez")
					.clave("123456")
					.rol("cliente")
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Av. Siempreviva")
					.numero(742)
					.localidad("Springfield")
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Juan")
					.apellido("Perez")
					.telefono(123456789)
					.email("juan.perez@gmail.com")
					.domicilio(domicilio)
					.usuario(usuario)
					.build();

			Pedido pedido = Pedido.builder()
					.fecha(Date.valueOf("2021-06-01"))
					.numero(1000)
					.horaEstimadaFin(Time.valueOf("12:00:00"))
					.tipoEnvio(1)
					.total(1000.00)
					.mercadoPagoDatos(mercadoPagoDatos)
					.factura(factura)
					.domicilio(domicilio)
					.cliente(cliente)
					.build();

			pedido.agregarDetallePedido(detallePedido);

			pedidoRepository.save(pedido);

			Pedido pedidoRecuperado = pedidoRepository.findById(pedido.getId()).orElse(null);


		};
	};
}