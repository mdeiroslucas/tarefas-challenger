package br.com.devlucas.tarefas.dto;

import br.com.devlucas.tarefas.model.Departamento;

public record DepartamentoDTO(
        String titulo,
        Integer quantidadePessoas,
        Integer quantidadeTarefas
        ) {

//        public DepartamentoDTO (Departamento departamento) {
//                this(departamento.getTitulo(), departamento.getPessoas().size(), departamento.getTarefas().size());
//        }
}
