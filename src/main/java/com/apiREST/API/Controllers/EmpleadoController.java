package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.EmpleadoDTO;
import com.apiREST.API.DTOs.NuevoEmpleadoDTO;
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
@CrossOrigin(origins = "")
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl> {

    @Autowired
    EmpleadoService empleadoService;
    //Enlistar Todos los Empleados
    @GetMapping("/listaEmpleados")
    public ResponseEntity<?> obtenerListaEmpleados() {
        try {
            List<Empleado> empleados = empleadoService.obtenerListaEmpleado();
            List<EmpleadoDTO> listaEmpleadosDTO = new ArrayList<>();

            for (Empleado empleado : empleados) {
                EmpleadoDTO listaEmpleadoDTO = new EmpleadoDTO();
                listaEmpleadoDTO.setNombre(empleado.getNombre());
                listaEmpleadoDTO.setApellido(empleado.getApellido());
                listaEmpleadoDTO.setRol(empleado.getUsuario().getRol());
                listaEmpleadoDTO.setEmail(empleado.getEmail());
                listaEmpleadoDTO.setTelefono(empleado.getTelefono());
                listaEmpleadoDTO.setCalle(empleado.getDomicilio().getCalle());
                listaEmpleadoDTO.setNumero(empleado.getDomicilio().getNumero());
                listaEmpleadoDTO.setLocalidad(empleado.getDomicilio().getLocalidad());
                // Assuming setEstado is a method in ListaEmpleadoDTO
                if (empleado.getFechaBaja() != null) {
                    listaEmpleadoDTO.setEstado("Baja");
                } else {
                    listaEmpleadoDTO.setEstado("Alta");
                }

                // Add the populated ListaEmpleadoDTO to the list
                listaEmpleadosDTO.add(listaEmpleadoDTO);
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
}