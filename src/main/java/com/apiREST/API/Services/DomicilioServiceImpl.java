package com.apiREST.API.Services;

import com.apiREST.API.Models.Domicilio;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio,Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> search(String filtro) throws Exception {
        try {
            List<Domicilio> entities = domicilioRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Domicilio> entities = domicilioRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}