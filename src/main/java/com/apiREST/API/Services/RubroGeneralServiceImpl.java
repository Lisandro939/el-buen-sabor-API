package com.apiREST.API.Services;

import com.apiREST.API.Models.RubroGeneral;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.RubroGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroGeneralServiceImpl extends BaseServiceImpl<RubroGeneral,Long> implements RubroGeneralService {

    @Autowired
    private RubroGeneralRepository rubroGeneralRepository;

    public RubroGeneralServiceImpl(BaseRepository<RubroGeneral, Long> baseRepository, RubroGeneralRepository rubroGeneralRepository) {
        super(baseRepository);
        this.rubroGeneralRepository = rubroGeneralRepository;
    }

    @Override
    public List<RubroGeneral> search(String filtro) throws Exception {
        try {
            List<RubroGeneral> entities = rubroGeneralRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroGeneral> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroGeneral> entities = rubroGeneralRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
