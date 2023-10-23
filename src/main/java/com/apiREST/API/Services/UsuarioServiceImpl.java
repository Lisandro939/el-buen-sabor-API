package com.apiREST.API.Services;

import com.apiREST.API.Models.Usuario;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> search(String filtro) throws Exception {
        try {
            List<Usuario> entities = usuarioRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Usuario> entities = usuarioRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}