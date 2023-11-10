package com.apiREST.API.Services;

import com.apiREST.API.Models.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacturaService extends BaseService<Factura, Long> {

    List<Factura> search(String filtro) throws Exception;

    Page<Factura> searchPaged(String filtro, Pageable pageable) throws Exception;

    //Historial pedidos
//    Factura obtenerFacturaPorId(Long facturaId);

}
