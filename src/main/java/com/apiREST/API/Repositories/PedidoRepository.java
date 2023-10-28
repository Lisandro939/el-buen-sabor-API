package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(value = "SELECT * FROM pedido WHERE numero LIKE %?1%", nativeQuery = true)
    List<Pedido> search(String filtro);

    @Query(value = "SELECT * FROM pedido WHERE numero LIKE %?1%", nativeQuery = true)
    Page<Pedido> searchPaged(String filtro, Pageable pageable);


}
