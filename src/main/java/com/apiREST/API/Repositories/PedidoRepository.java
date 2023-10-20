package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM pedido WHERE numero = :numero", nativeQuery = true)
    List<Pedido> search(int numero);

    @Query(value = "SELECT * FROM pedido WHERE numero = :numero", nativeQuery = true)
    Page<Pedido> search(int numero, Pageable pageable);
}

