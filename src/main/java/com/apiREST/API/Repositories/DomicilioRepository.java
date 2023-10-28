package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    @Query(value = "SELECT * FROM domicilio WHERE calle LIKE %?1%", nativeQuery = true)
    List<Domicilio> search(String filtro);

    @Query(value = "SELECT * FROM domicilio WHERE calle LIKE %?1%", nativeQuery = true)
    Page<Domicilio> searchPaged(String filtro, Pageable pageable);


}
=======

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    @Query(value = "SELECT * FROM domicilio WHERE calle LIKE %?1%", nativeQuery = true)
    List<Domicilio> search(String filtro);

    @Query(value = "SELECT * FROM domicilio WHERE calle LIKE %?1%", nativeQuery = true)
    Page<Domicilio> searchPaged(String filtro, Pageable pageable);


}
>>>>>>> 61101a2426169477ed1220dcfb2b350328a9b165
