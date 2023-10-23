package com.apiREST.API.Services;

import com.apiREST.API.Models.MercadoPagoDatos;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.MercadoPagoDatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoPagoDatosServiceImpl extends BaseServiceImpl<MercadoPagoDatos,Long> implements MercadoPagoDatosService {

    @Autowired
    private MercadoPagoDatosRepository mercadoPagoDatosRepository;

    public MercadoPagoDatosServiceImpl(BaseRepository<MercadoPagoDatos, Long> baseRepository, MercadoPagoDatosRepository mercadoPagoDatosRepository) {
        super(baseRepository);
        this.mercadoPagoDatosRepository = mercadoPagoDatosRepository;
    }

    @Override
    public List<MercadoPagoDatos> search(String filtro) throws Exception {
        try {
            List<MercadoPagoDatos> entities = mercadoPagoDatosRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<MercadoPagoDatos> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<MercadoPagoDatos> entities = mercadoPagoDatosRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}