package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.TarefaDTO;
import br.com.devlucas.tarefas.dto.mapper.TarefaMapper;
import br.com.devlucas.tarefas.model.Tarefa;
import br.com.devlucas.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private TarefaMapper tarefaMapper;

    @GetMapping("/pendentes")
    @ResponseStatus(HttpStatus.OK)
    public Page<Tarefa> getTarefasPendentesSemPessoa(@PageableDefault(size = 1)Pageable paginacao) {
        return tarefaService.getTarefasSemPessoas(paginacao);
    }
}
