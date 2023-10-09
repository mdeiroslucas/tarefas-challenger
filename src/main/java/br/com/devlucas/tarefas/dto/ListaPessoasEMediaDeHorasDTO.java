package br.com.devlucas.tarefas.dto;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;

public record ListaPessoasEMediaDeHorasDTO(String nome, double mediaHora) {

    public ListaPessoasEMediaDeHorasDTO(Pessoa pessoa){
        this(pessoa.getNome(), pessoa.getTarefas().stream().mapToInt(Tarefa::getDuracao).average().orElse(0.0));
    }
}
