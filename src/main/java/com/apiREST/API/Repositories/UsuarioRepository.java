package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario WHERE usuario LIKE %?1%", nativeQuery = true)
    List<Usuario> search(String filtro);

    @Query(value = "SELECT * FROM usuario WHERE usuario LIKE %?1%", nativeQuery = true)
    Page<Usuario> searchPaged(String filtro, Pageable pageable);

}
