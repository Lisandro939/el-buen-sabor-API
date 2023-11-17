package com.apiREST.API.Services;

import com.apiREST.API.DTOs.RankingClientesDTO;
import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Empleado;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> entities = clienteRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> entities = clienteRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String login(String email, String clave) throws Exception {
        try {
            Cliente cliente = clienteRepository.login(email, clave);
            if (cliente == null) {
                String jsonResponseFalse = "{\"login\": false}";
                return jsonResponseFalse;
            } else if (cliente.getFechaBaja() != null) {
                String jsonResponseFechaBaja = "{\"login\": cliente dado de baja}";
                return jsonResponseFechaBaja;
            } else {
                String jsonResponseTrue = "{\"login\": true}";
                return jsonResponseTrue;
            }
        } catch (Exception e) {
            throw new Exception("{ \"response\": \"" + e.getMessage() + "\" }");
        }
    }

    @Override
    public Cliente findByEmail(String email) throws Exception {
        try {
            Cliente cliente = clienteRepository.findByEmail(email);
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<RankingClientesDTO> rankingClientes(String rubro, String desde, String hasta) throws Exception {
        try {
            List<Object[]> entities = clienteRepository.rankingClientes(rubro, desde, hasta);
            List<RankingClientesDTO> dtos = new ArrayList<>();
            System.out.println(entities);
            for (Object[] entity : entities) {
                RankingClientesDTO dto = new RankingClientesDTO(
                        (String) entity[0],
                        (String) entity[1],
                        (BigDecimal) entity[2],
                        (double) entity[3]
                );
                dtos.add(dto);
            }
            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Cliente> obtenerListaCliente() throws Exception{
        try{
            List<Cliente> entities = clienteRepository.obtenerListaCliente();
            return  entities;
        } catch (Exception e){
            throw new Exception("Error al obtener los Cliente: " + e.getMessage());
        }
    }
}
