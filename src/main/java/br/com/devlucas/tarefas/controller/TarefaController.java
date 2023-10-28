package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.tarefa.TarefaDTO;
import br.com.devlucas.tarefas.dto.mapper.TarefaMapper;
import br.com.devlucas.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private TarefaMapper tarefaMapper;

    @GetMapping("/pendentes")
    @ResponseStatus(HttpStatus.OK)
    public Page<TarefaDTO> getTarefasPendentesSemPessoa(Pageable paginacao) {
        return tarefaService.getTarefasSemPessoas(paginacao);
    }

    @PutMapping("/finalizar/{id}")
    @Transactional
    public ResponseEntity<TarefaDTO> finalizarTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.finalizarTarefa(id));
    }
}
