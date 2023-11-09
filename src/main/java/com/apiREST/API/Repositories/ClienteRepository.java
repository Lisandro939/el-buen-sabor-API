package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %?1%", nativeQuery = true)
    List<Cliente> search(String filtro);

    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %?1%", nativeQuery = true)
    Page<Cliente> searchPaged(String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM cliente WHERE email = %?1% AND usuario_id IN (SELECT id FROM usuario WHERE clave = %?2%);", nativeQuery = true)
    Cliente login(String email, String clave);

    @Query(value = "SELECT * FROM cliente WHERE email = %?1%", nativeQuery = true)
    Cliente findByEmail(String email);
}
