package com.apiREST.API.Repositories;

import com.apiREST.API.Models.RubroArticulo;
import com.apiREST.API.Models.RubroGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RubroGeneralRepository extends JpaRepository<RubroGeneral, Long> {

    @Query(value = "SELECT * FROM rubroGeneral WHERE filtro = :filtro", nativeQuery = true)
    List<RubroGeneral> search(String filtro);

    @Query(value = "SELECT * FROM rubroGeneral WHERE filtro = :filtro", nativeQuery = true)
    Page<RubroGeneral> search(String filtro, Pageable pageable);

}
