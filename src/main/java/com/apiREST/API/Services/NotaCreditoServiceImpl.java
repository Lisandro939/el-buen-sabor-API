package com.apiREST.API.Services;

import com.apiREST.API.Models.NotaCredito;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.NotaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito, Long> implements NotaCreditoService {

    @Autowired
    NotaCreditoRepository notaCreditoRepository;

    public NotaCreditoServiceImpl(BaseRepository<NotaCredito, Long> baseRepository, NotaCreditoRepository notaCreditoRepository) {
        super(baseRepository);
        this.notaCreditoRepository = notaCreditoRepository;
    }

    @Override
    public List<NotaCredito> searchByNroDoc(int nroDocumento) throws Exception {
        try{
            List<NotaCredito> entities = notaCreditoRepository.searchByNroDoc(nroDocumento);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
