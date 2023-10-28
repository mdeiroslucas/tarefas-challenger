package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.TarefaDTO;
import br.com.devlucas.tarefas.dto.mapper.TarefaMapper;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;
import br.com.devlucas.tarefas.repository.DepartamentoRepository;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import br.com.devlucas.tarefas.repository.TarefaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<TarefaDTO> getTarefasSemPessoas(Pageable paginacao){

        Page<Tarefa> tarefasSemPessoasPage = tarefaRepository.findByPessoaIsNullOrderByPrazo(paginacao);
        return tarefasSemPessoasPage.map(TarefaMapper::toDTO);
    }
}
