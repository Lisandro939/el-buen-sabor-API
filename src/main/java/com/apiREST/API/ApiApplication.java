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

			if (pedidoRecuperado != null) {
				System.out.println("Pedido Recuperado:");
				System.out.println("ID: " + pedidoRecuperado.getId());
				System.out.println("Fecha: " + pedidoRecuperado.getFecha());
				System.out.println("Número: " + pedidoRecuperado.getNumero());
				System.out.println("Hora Estimada Fin: " + pedidoRecuperado.getHoraEstimadaFin());
				System.out.println("Tipo Envío: " + pedidoRecuperado.getTipoEnvio());
				System.out.println("Total: " + pedidoRecuperado.getTotal());

				MercadoPagoDatos mercadoPagoDatosRecuperado = pedidoRecuperado.getMercadoPagoDatos();
				if (mercadoPagoDatos != null) {
					System.out.println("MercadoPagoDatos:");
					System.out.println("Identificador Pago: " + mercadoPagoDatosRecuperado.getIdentificadorPago());
					System.out.println("Fecha Creación: " + mercadoPagoDatosRecuperado.getFechaCreacion());
					System.out.println("Fecha Aprobación: " + mercadoPagoDatosRecuperado.getFechaAprobacion());
					System.out.println("Forma Pago: " + mercadoPagoDatosRecuperado.getFormaPago());
					System.out.println("Método Pago: " + mercadoPagoDatosRecuperado.getMetodoPago());
					System.out.println("Número de Tarjeta: " + mercadoPagoDatosRecuperado.getNroTarjeta());
					System.out.println("Estado: " + mercadoPagoDatosRecuperado.getEstado());
				}

				Factura facturaRecuperada = pedidoRecuperado.getFactura();
				if (factura != null) {
					System.out.println("Factura:");
					System.out.println("Fecha: " + facturaRecuperada.getFecha());
					System.out.println("Número: " + facturaRecuperada.getNumero());
					System.out.println("Monto Descuento: " + facturaRecuperada.getMontoDescuento());
					System.out.println("Forma Pago: " + facturaRecuperada.getFormaPago());
					System.out.println("Número de Tarjeta: " + facturaRecuperada.getNroTarjeta());
					System.out.println("Total Venta: " + facturaRecuperada.getTotalVenta());
					System.out.println("Total Costo: " + facturaRecuperada.getTotalCosto());
				}

				Domicilio domicilioRecuperado = pedidoRecuperado.getDomicilio();
				if (domicilio != null) {
					System.out.println("Domicilio:");
					System.out.println("Calle: " + domicilioRecuperado.getCalle());
					System.out.println("Número: " + domicilioRecuperado.getNumero());
					System.out.println("Localidad: " + domicilioRecuperado.getLocalidad());
				}

				Cliente clienteRecuperado = pedidoRecuperado.getCliente();
				if (cliente != null) {
					System.out.println("Cliente:");
					System.out.println("Nombre: " + clienteRecuperado.getNombre());
					System.out.println("Apellido: " + clienteRecuperado.getApellido());
					System.out.println("Teléfono: " + clienteRecuperado.getTelefono());
					System.out.println("Email: " + clienteRecuperado.getEmail());
				}

				System.out.println("Detalle Pedido:");
				DetallePedido detallePedidoRecuperado = pedidoRecuperado.getDetallePedido().get(0); // Assuming there's at least one
				System.out.println("Cantidad: " + detallePedidoRecuperado.getCantidad());
				System.out.println("Subtotal: " + detallePedidoRecuperado.getSubtotal());

				ArticuloManufacturado articuloManufacturadoRecuperado = detallePedidoRecuperado.getArticuloManufacturado();
				if (articuloManufacturado != null) {
					System.out.println("Articulo Manufacturado:");
					System.out.println("Tiempo Estimado Cocina: " + articuloManufacturadoRecuperado.getTiempoEstimadoCocina());
					System.out.println("Denominación: " + articuloManufacturadoRecuperado.getDenominacion());
					System.out.println("Precio Venta: " + articuloManufacturadoRecuperado.getPrecioVenta());
					System.out.println("Imagen: " + articuloManufacturadoRecuperado.getImagen());
				}

				ArticuloInsumo articuloInsumoRecuperado = detallePedidoRecuperado.getArticuloInsumo();
				if (articuloInsumo != null) {
					System.out.println("Articulo Insumo:");
					System.out.println("Denominación: " + articuloInsumoRecuperado.getDenominacion());
					System.out.println("Precio Compra: " + articuloInsumoRecuperado.getPrecioCompra());
					System.out.println("Precio Venta: " + articuloInsumoRecuperado.getPrecioVenta());
					System.out.println("Stock Actual: " + articuloInsumoRecuperado.getStockActual());
					System.out.println("Stock Mínimo: " + articuloInsumoRecuperado.getStockMinimo());
					System.out.println("Unidad Medida: " + articuloInsumoRecuperado.getUnidadMedida());
					System.out.println("Es Insumo: " + articuloInsumoRecuperado.isEsInsumo());
				}
			}

		};
	};
}
