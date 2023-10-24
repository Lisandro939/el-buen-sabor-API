package com.apiREST.API.Services;

import com.apiREST.API.Models.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface FacturaService extends BaseService<Factura, Long> {

    List<Factura> search(int numero) throws Exception;

    Page<Factura> search(int numero, Pageable pageable) throws Exception;

}