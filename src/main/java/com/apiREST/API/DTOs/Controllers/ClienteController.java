package com.apiREST.API.DTOs.Controllers;

import com.apiREST.API.DTOs.DatosClienteDTO;
import com.apiREST.API.DTOs.NuevoClienteDTO;
import com.apiREST.API.Enums.Rol;
import com.apiREST.API.Models.*;
import com.apiREST.API.Services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    @Autowired
    private ClienteServiceImpl servicio;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(200).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/searchpaged")
    public ResponseEntity<?> searchPaged(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(200).body(servicio.searchPaged(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> crearNuevoCliente(@RequestBody NuevoClienteDTO nuevoClienteDTO) {
        try {
            Cliente cliente = new Cliente();
            // Configura las propiedades de Cliente según el DTO
            cliente.setNombre(nuevoClienteDTO.getNombre());
            cliente.setApellido(nuevoClienteDTO.getApellido());
            cliente.setTelefono(nuevoClienteDTO.getTelefono());
            cliente.setEmail(nuevoClienteDTO.getEmail());

            Usuario usuario = new Usuario();
            // El usuario del cliente se va a formar automáticamente con el nombre y apellido
            usuario.setUsuario(nuevoClienteDTO.getNombre() + nuevoClienteDTO.getApellido());
            usuario.setClave(nuevoClienteDTO.getClave());
            // Se le asigna el rol de Cliente automaticamente
            usuario.setRol(Rol.Cliente);

            // Seteamos el usuario al cliente
            cliente.setUsuario(usuario);

            // Configura el Domicilio si está presente en el DTO
            if (nuevoClienteDTO.getCalle() != null) {
                Domicilio domicilio = new Domicilio();
                domicilio.setCalle(nuevoClienteDTO.getCalle());
                domicilio.setNumero(nuevoClienteDTO.getNumero());
                domicilio.setLocalidad(nuevoClienteDTO.getLocalidad());

                // Seteamos el domicilio al cliente
                cliente.setDomicilio(domicilio);
            }

            // Same but with email
            servicio.findAll().forEach(cliente1 -> {
                if (cliente1.getEmail().equals(cliente.getEmail())) {
                    throw new RuntimeException("El email ya existe");
                }
            });

            servicio.save(cliente);

            return new ResponseEntity<>("Cliente creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String clave) {
        try {
            return ResponseEntity.status(200).body(servicio.login(email, clave));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/datos")
    public ResponseEntity<?> datosCliente(@RequestParam String email) {
        try {
            Cliente cliente = servicio.findByEmail(email);

            DatosClienteDTO datosClienteDTO = new DatosClienteDTO();

            datosClienteDTO.setNombre(cliente.getNombre());
            datosClienteDTO.setApellido(cliente.getApellido());
            datosClienteDTO.setTelefono(cliente.getTelefono());
            datosClienteDTO.setEmail(cliente.getEmail());
            datosClienteDTO.setClave(cliente.getUsuario().getClave());
            datosClienteDTO.setFechaNacimiento(cliente.getFechaNacimiento().toString());
            datosClienteDTO.setCalle(cliente.getDomicilio().getCalle());
            datosClienteDTO.setNumero(cliente.getDomicilio().getNumero());
            datosClienteDTO.setLocalidad(cliente.getDomicilio().getLocalidad());

            return ResponseEntity.status(200).body(datosClienteDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/modificarDatosCliente")
    public ResponseEntity<?> modificarCliente(@RequestBody DatosClienteDTO modificarDatosClienteDTO) {
        try {
            Cliente cliente = servicio.findByEmail(modificarDatosClienteDTO.getEmail());

            cliente.setNombre(modificarDatosClienteDTO.getNombre());
            cliente.setApellido(modificarDatosClienteDTO.getApellido());
            cliente.setTelefono(modificarDatosClienteDTO.getTelefono());
            cliente.setEmail(modificarDatosClienteDTO.getEmail());
            cliente.getUsuario().setClave(modificarDatosClienteDTO.getClave());
            cliente.setFechaNacimiento(Date.valueOf(modificarDatosClienteDTO.getFechaNacimiento()));

            if (modificarDatosClienteDTO.getCalle() != null) {
                cliente.getDomicilio().setCalle(modificarDatosClienteDTO.getCalle());
                cliente.getDomicilio().setNumero(modificarDatosClienteDTO.getNumero());
                cliente.getDomicilio().setLocalidad(modificarDatosClienteDTO.getLocalidad());
            }

            servicio.save(cliente);

            return new ResponseEntity<>("Cliente modificado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<?> rankingClientes(@RequestParam String rubro, @RequestParam String desde, @RequestParam String hasta) {
        try {
            return ResponseEntity.status(200).body(servicio.rankingClientes(rubro, desde, hasta));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
