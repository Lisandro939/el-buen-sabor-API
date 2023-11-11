package com.apiREST.API.Services;

import com.apiREST.API.Models.NotaCredito;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NotaCreditoService extends BaseService<NotaCredito, Long>{
    List<NotaCredito> searchByNroDoc(int nroDocumento) throws Exception;
}
