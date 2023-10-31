package br.com.devlucas.tarefas.dto.pessoa;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;

public record ListaPessoasEMediaDeHorasDTO(String nome, double mediaHora) {

    public ListaPessoasEMediaDeHorasDTO(Pessoa pessoa, double mediaHora){
        this(pessoa.getNome(), mediaHora);
    }
}
