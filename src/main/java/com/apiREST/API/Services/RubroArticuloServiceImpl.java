package com.apiREST.API.Services;

import com.apiREST.API.Models.RubroArticulo;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo,Long> implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository, RubroArticuloRepository rubroArticuloRepository) {
        super(baseRepository);
        this.rubroArticuloRepository = rubroArticuloRepository;
    }

    @Override
    public List<RubroArticulo> search(String filtro) throws Exception {
        try {
            List<RubroArticulo> entities = rubroArticuloRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroArticulo> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroArticulo> entities = rubroArticuloRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
