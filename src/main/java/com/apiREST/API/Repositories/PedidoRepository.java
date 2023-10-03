package com.apiREST.API.Repositories;

import com.apiREST.API.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
