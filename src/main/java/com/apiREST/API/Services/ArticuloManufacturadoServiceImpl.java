package com.apiREST.API.Services;

import com.apiREST.API.Models.ArticuloManufacturado;
import com.apiREST.API.Repositories.ArticuloManufacturadoRepository;
import com.apiREST.API.Repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }


    @Override
    public List<ArticuloManufacturado> search(String filtro) throws Exception {
        try{
            List<ArticuloManufacturado> entities = articuloManufacturadoRepository.search(filtro);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturado> entities = articuloManufacturadoRepository.search(filtro, pageable);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
