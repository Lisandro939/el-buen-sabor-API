package com.apiREST.API.Services;

import com.apiREST.API.DTOs.RankingProductosDTO;
import com.apiREST.API.Models.ArticuloManufacturado;
import com.apiREST.API.Repositories.ArticuloManufacturadoRepository;
import com.apiREST.API.Repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    @Override
    public List<ArticuloManufacturado> search(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> entities = articuloManufacturadoRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturado> entities = articuloManufacturadoRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloManufacturado findByName(String denominacion) throws Exception{
        try{

            ArticuloManufacturado articuloManufacturado= articuloManufacturadoRepository.findByName(denominacion);
            return articuloManufacturado;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<RankingProductosDTO> ranking(String producto, String desde, String hasta) throws Exception {
        try {
            List<Object[]> entities = articuloManufacturadoRepository.ranking(producto, desde, hasta);
            List<RankingProductosDTO> dtos = new ArrayList<>();

            for (Object[] entity : entities) {
                RankingProductosDTO dto = new RankingProductosDTO(
                        (Long) entity[0],
                        (String) entity[1],
                        (BigDecimal) entity[2]
                );

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
