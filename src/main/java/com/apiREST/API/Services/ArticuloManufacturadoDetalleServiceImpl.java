package com.apiREST.API.Services;

import com.apiREST.API.Models.ArticuloInsumo;
import com.apiREST.API.Models.ArticuloManufacturadoDetalle;
import com.apiREST.API.Repositories.ArticuloInsumoRepository;
import com.apiREST.API.Repositories.ArticuloManufacturadoDetalleRepository;
import com.apiREST.API.Repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoDetalleServiceImpl extends BaseServiceImpl<ArticuloManufacturadoDetalle,Long> implements ArticuloManufacturadoDetalleService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleServiceImpl(BaseRepository<ArticuloManufacturadoDetalle, Long> baseRepository, ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository) {
        super(baseRepository);
        this.articuloManufacturadoDetalleRepository = articuloManufacturadoDetalleRepository;
    }

    @Override
    public List<ArticuloManufacturadoDetalle> search(String filtro) throws Exception {
        try {
            List<ArticuloManufacturadoDetalle> entities = articuloManufacturadoDetalleRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturadoDetalle> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturadoDetalle> entities = articuloManufacturadoDetalleRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}