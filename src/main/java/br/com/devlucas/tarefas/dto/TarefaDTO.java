package br.com.devlucas.tarefas.dto;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import java.time.LocalDate;

public record TarefaDTO(
        @NotBlank(message = "Titulo da tarefa não pode ser vazio!")
        String titulo,
        @NotBlank(message = "Descrição da tarefa não pode ser vazio!")
        String descricao,

        @NotNull(message = "Prazo da tarefa não pode ser vazio!")
        LocalDate prazo,

        @NotNull(message = "Deve designar um departamento para a tarefa!")
        Departamento departamento,


        @NotNull(message = "A duração da tarefa não pode ser vazia!")
        Integer duracao,
        Pessoa pessoa,
        Boolean finalizado


    ) {

    }
