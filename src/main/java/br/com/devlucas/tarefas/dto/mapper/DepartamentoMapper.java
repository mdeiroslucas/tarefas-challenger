package br.com.devlucas.tarefas.dto.mapper;

import br.com.devlucas.tarefas.dto.DepartamentoDTO;
import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {
    public DepartamentoDTO toDTO(Departamento departamento) {
        if (departamento == null) {
            return null;
        }

        return new DepartamentoDTO(
                departamento.getTitulo(),
                departamento.getPessoas().size(),
                departamento.getTarefas().size()
        );
    }
}
