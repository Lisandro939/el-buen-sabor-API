package com.apiREST.API.Repositories;

import com.apiREST.API.Models.RubroGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroGeneralRepository extends BaseRepository<RubroGeneral, Long> {

    @Query(value = "SELECT * FROM rubro_general WHERE denominacion LIKE %?1%", nativeQuery = true)
    List<RubroGeneral> search(String filtro);

    @Query(value = "SELECT * FROM rubro_general WHERE denominacion LIKE %?1%", nativeQuery = true)
    Page<RubroGeneral> searchPaged(String filtro, Pageable pageable);


}
