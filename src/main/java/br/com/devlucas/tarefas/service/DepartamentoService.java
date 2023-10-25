package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.DepartamentoDTO;
import br.com.devlucas.tarefas.dto.mapper.DepartamentoMapper;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private DepartamentoMapper departamentoMapper;


    public List<DepartamentoDTO> listarDepartamentos() {
        return departamentoRepository.findAll().stream().map(departamentoMapper::toDTO).toList();
    }
}
