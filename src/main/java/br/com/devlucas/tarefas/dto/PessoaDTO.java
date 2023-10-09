package br.com.devlucas.tarefas.dto;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaDTO(
        Long id,
        @NotBlank
        String nome,
        @NotNull
        Departamento departamento
) {
}
