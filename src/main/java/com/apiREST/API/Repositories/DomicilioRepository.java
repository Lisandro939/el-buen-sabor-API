package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {

    @Query(value = "SELECT * FROM domicilio WHERE numero LIKE %?1%", nativeQuery = true)
    List<Domicilio> search(String filtro);

    @Query(value = "SELECT * FROM domicilio WHERE numero LIKE %?1%", nativeQuery = true)
    Page<Domicilio> search(String filtro, Pageable pageable);

}
