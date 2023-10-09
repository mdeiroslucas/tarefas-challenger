package br.com.devlucas.tarefas.dto;

import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;

public record ListagemPessoaDTO(String nome, String nomeDepartamento, Integer HorasGastaNasTarefas) {

    public ListagemPessoaDTO(Pessoa pessoa) {
        this(pessoa.getNome(), pessoa.getDepartamento().getTitulo(), pessoa.getTarefas().stream().mapToInt(Tarefa::getDuracao).sum());
    }

}
