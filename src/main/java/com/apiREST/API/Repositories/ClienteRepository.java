package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %?1%  OR apellido LIKE %?1%", nativeQuery = true)
    List<Cliente> search(String filtro);

    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %?1% OR apellido LIKE %?1%", nativeQuery = true)
    Page<Cliente> search(String filtro, Pageable pageable);
}
