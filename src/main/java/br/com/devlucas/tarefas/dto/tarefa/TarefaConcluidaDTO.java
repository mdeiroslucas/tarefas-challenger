package br.com.devlucas.tarefas.dto.tarefa;

import br.com.devlucas.tarefas.model.Tarefa;

import java.time.LocalDate;

public record TarefaConcluidaDTO(
        String titulo, String descricao, LocalDate prazo, String nomeDepartamento, String nomePessoa, boolean finalizada
) {
    public TarefaConcluidaDTO (Tarefa tarefa){
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getDepartamento().getTitulo(), tarefa.getPessoa().getNome(), tarefa.getFinalizado());
    }

}
