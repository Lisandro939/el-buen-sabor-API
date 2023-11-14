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
    List<Cliente> search(String filtro);

    @Query(value = "SELECT * FROM empleado WHERE nombre LIKE %?1%", nativeQuery = true)
    Page<Cliente> searchPaged(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM empleado;", nativeQuery = true)
    List<Empleado> obtenerListaEmpleado();

}
