package com.apiREST.API.Repositories;

import com.apiREST.API.Models.NotaCredito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotaCreditoRepository extends BaseRepository<NotaCredito, Long> {

    @Query("SELECT nc FROM NotaCredito nc WHERE nc.nroDocumento LIKE :nroDocumento")
    List<NotaCredito> searchByNroDoc(@Param("nroDocumento") int nroDocumento);
}
