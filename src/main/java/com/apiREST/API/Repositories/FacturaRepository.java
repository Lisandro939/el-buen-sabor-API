package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
