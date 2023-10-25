package com.apiREST.API.Services;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> entities = clienteRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> entities = clienteRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
