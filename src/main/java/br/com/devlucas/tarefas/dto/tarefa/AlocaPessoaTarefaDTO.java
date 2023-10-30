package br.com.devlucas.tarefas.dto.tarefa;

import br.com.devlucas.tarefas.model.Tarefa;

import java.time.LocalDate;

public record AlocaPessoaTarefaDTO(
      String titulo, String descricao, LocalDate prazo, Long idDepartamento, Long idPessoa
) {
    public AlocaPessoaTarefaDTO (Tarefa tarefa){
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getDepartamento().getId(), tarefa.getPessoa().getId());
    }
}
