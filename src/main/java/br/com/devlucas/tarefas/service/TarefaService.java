package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.TarefaDTO;
import br.com.devlucas.tarefas.dto.mapper.TarefaMapper;
import br.com.devlucas.tarefas.repository.TarefaRepository;
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

    public Page<TarefaDTO> getTarefasSemPessoas(Pageable paginacao){
        return tarefaRepository.findByPessoaIsNullOrderByPrazo(paginacao).map(tarefaMapper::toDTO);
    }
}
