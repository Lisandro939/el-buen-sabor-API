package com.apiREST.API.Controllers;

import com.apiREST.API.DTOs.ListaEmpleadoDTO;
import com.apiREST.API.Models.Empleado;
import com.apiREST.API.Services.EmpleadoService;
import com.apiREST.API.Services.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl> {

    //Enlistar Todos los Empleados
    @Autowired
    EmpleadoService empleadoService;
    @GetMapping("/listaEmpleados")
    public ResponseEntity<?> obtenerListaEmpleados() {
        try {
            List<Empleado> empleados = empleadoService.obtenerListaEmpleado();
            List<ListaEmpleadoDTO> listaEmpleadosDTO = new ArrayList<>();

            for (Empleado empleado : empleados) {
                ListaEmpleadoDTO listaEmpleadoDTO = ListaEmpleadoDTO.builder()
                        .nombre(empleado.getNombre())
                        .apellido(empleado.getApellido())
                        .rol(empleado.getUsuario.getRol())
                        .email(empleado.getEmail())
                        .telefono(empleado.getTelefono())
                        .calle(empleado.getDomicilio.getCalle())
                        .numero(empleado.getDomicilio.getNumero())
                        .localidad(empleado.getDomicilio.getLocalidad())
                        .estado(empleado.getEstado())
                        .build();

                listaEmpleadosDTO.add(listaEmpleadoDTO);
            }

            return ResponseEntity.status(200).body(listaEmpleadosDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
