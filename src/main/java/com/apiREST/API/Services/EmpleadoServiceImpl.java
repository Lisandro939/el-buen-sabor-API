package com.apiREST.API.Services;

import com.apiREST.API.Models.Cliente;
import com.apiREST.API.Models.Empleado;
import com.apiREST.API.Repositories.BaseRepository;
import com.apiREST.API.Repositories.ClienteRepository;
import com.apiREST.API.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado,Long> implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository, EmpleadoRepository empleadoRepository) {
        super(baseRepository);
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            List<Cliente> entities = empleadoRepository.search(filtro);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> searchPaged(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> entities = empleadoRepository.searchPaged(filtro, pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Empleado> obtenerListaEmpleado() throws Exception {
        try {
            List<Empleado> entities = empleadoRepository.obtenerListaEmpleado();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
