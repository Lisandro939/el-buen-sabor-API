package com.apiREST.API.Services;

import com.apiREST.API.Models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long> {

    List<Usuario> search(String filtro) throws Exception;

    Page<Usuario> search(String filtro, Pageable pageable) throws Exception;

}
