package br.com.devlucas.tarefas.dto;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PessoaDTO(
        Long id,
        @NotBlank
        String nome,
        @NotNull
        Departamento departamento,
        List<Tarefa> tarefas
) {
}
