package com.apiREST.API.Repositories;

import com.apiREST.API.Models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura, Long> {
}
