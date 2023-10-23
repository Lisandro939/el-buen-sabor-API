package com.apiREST.API.Services;

import com.apiREST.API.Models.ArticuloInsumo;
import com.apiREST.API.Repositories.ArticuloInsumoRepository;
import com.apiREST.API.Repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo,Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Override
    public List<ArticuloInsumo> search(String filtro) throws Exception {
        try {
            List<ArticuloInsumo> entities = articuloInsumoRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloInsumo> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloInsumo> entities = articuloInsumoRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}