package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    @Query(value = "SELECT * FROM empleado WHERE nombre LIKE %?1%", nativeQuery = true)
    List<Empleado> search(String filtro);

    @Query(value = "SELECT * FROM empleado WHERE nombre LIKE %?1%", nativeQuery = true)
    Page<Empleado> searchPaged(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM empleado;", nativeQuery = true)
    List<Empleado> obtenerListaEmpleado();

    @Query(value = "SELECT * FROM empleado WHERE email = %?1% AND usuario_id IN (SELECT id FROM usuario WHERE clave = %?2%);", nativeQuery = true)
    Empleado login(String email, String clave);

    @Query(value = "SELECT * FROM empleado WHERE email = %?1%", nativeQuery = true)
    Empleado findByEmail(String email);
}
