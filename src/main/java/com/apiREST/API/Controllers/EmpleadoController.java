package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.DTOEmpleado;
import com.apiREST.API.DTOs.DatosClienteDTO;
import com.apiREST.API.DTOs.NuevoEmpleadoDTO;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Domicilio;
import com.apiREST.API.Models.Empleado;
import com.apiREST.API.Models.Usuario;
import com.apiREST.API.Services.EmpleadoService;
import com.apiREST.API.Services.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl> {

    @Autowired
    EmpleadoService empleadoService;
    
    //Enlistar Todos los Empleados
    @GetMapping("/listaEmpleados")
    public ResponseEntity<?> obtenerListaEmpleados() {
        try {
            List<Empleado> empleados = empleadoService.obtenerListaEmpleado();
            List<DTOEmpleado> listaEmpleadosDTO = new ArrayList<>();

            for (Empleado empleado : empleados) {
                DTOEmpleado listaDTOEmpleado = new DTOEmpleado();
                listaDTOEmpleado.setId(empleado.getId());
                listaDTOEmpleado.setNombre(empleado.getNombre());
                listaDTOEmpleado.setApellido(empleado.getApellido());
                listaDTOEmpleado.setRol(empleado.getUsuario().getRol());
                listaDTOEmpleado.setEmail(empleado.getEmail());
                listaDTOEmpleado.setTelefono(empleado.getTelefono());
                listaDTOEmpleado.setCalle(empleado.getDomicilio().getCalle());
                listaDTOEmpleado.setNumero(empleado.getDomicilio().getNumero());
                listaDTOEmpleado.setLocalidad(empleado.getDomicilio().getLocalidad());
                if (empleado.getFechaBaja() != null) {
                    listaDTOEmpleado.setEstado("Baja");
                } else {
                    listaDTOEmpleado.setEstado("Alta");
                }
                listaEmpleadosDTO.add(listaDTOEmpleado);
            }

            return ResponseEntity.status(200).body(listaEmpleadosDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/registerEmpleado")
    public ResponseEntity<?> crearNuevoEmpleado(@RequestBody NuevoEmpleadoDTO nuevoEmpleadoDTO) {
        try {
            Empleado empleado = new Empleado();
            // Configura las propiedades de Cliente según el DTO
            empleado.setNombre(nuevoEmpleadoDTO.getNombre());
            empleado.setApellido(nuevoEmpleadoDTO.getApellido());
            empleado.setTelefono(nuevoEmpleadoDTO.getTelefono());
            empleado.setEmail(nuevoEmpleadoDTO.getEmail());
            empleado.setFechaBaja(null);

            Usuario usuario = new Usuario();
            // El usuario del cliente se va a formar automáticamente con el nombre y apellido
            usuario.setUsuario(nuevoEmpleadoDTO.getNombre() + nuevoEmpleadoDTO.getApellido());
            usuario.setClave(nuevoEmpleadoDTO.getClaveProvisoria());
            usuario.setRol(nuevoEmpleadoDTO.getRol());

            // Seteamos el usuario al cliente
            empleado.setUsuario(usuario);

            // Configura el Domicilio si está presente en el DTO
            if (nuevoEmpleadoDTO.getCalle() != null) {
                Domicilio domicilio = new Domicilio();
                domicilio.setCalle(nuevoEmpleadoDTO.getCalle());
                domicilio.setNumero(nuevoEmpleadoDTO.getNumero());
                domicilio.setLocalidad(nuevoEmpleadoDTO.getLocalidad());

                // Seteamos el domicilio al cliente
                empleado.setDomicilio(domicilio);
            }

            // Same but with email
            servicio.findAll().forEach(empleado1 -> {
                if (empleado1.getEmail().equals(empleado.getEmail())) {
                    throw new RuntimeException("El email ya existe");
                }
            });

            servicio.save(empleado);

            return new ResponseEntity<>("Empleado creado exitosamente", HttpStatus.CREATED);
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
    public ResponseEntity<?> datosEmpleado(@RequestParam String email) {
        try {
            Empleado empleado = servicio.findByEmail(email);

            DTOEmpleado dtoEmpleado = new DTOEmpleado();

            dtoEmpleado.setNombre(empleado.getNombre());
            dtoEmpleado.setApellido(empleado.getApellido());
            dtoEmpleado.setTelefono(empleado.getTelefono());
            dtoEmpleado.setEmail(empleado.getEmail());
            dtoEmpleado.setCalle(empleado.getDomicilio().getCalle());
            dtoEmpleado.setNumero(empleado.getDomicilio().getNumero());
            dtoEmpleado.setLocalidad(empleado.getDomicilio().getLocalidad());
            dtoEmpleado.setRol(dtoEmpleado.getRol());
            dtoEmpleado.setEstado(dtoEmpleado.getEstado());

            return ResponseEntity.status(200).body(dtoEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
