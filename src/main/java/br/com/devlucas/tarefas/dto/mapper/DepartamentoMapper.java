package br.com.devlucas.tarefas.dto.mapper;

import br.com.devlucas.tarefas.dto.departamento.DepartamentoDTO;
import br.com.devlucas.tarefas.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {
    public DepartamentoDTO toDTO(Departamento departamento) {
        if (departamento == null) {
            return null;
        }

        return new DepartamentoDTO("teste", 1 ,3);
//                departamento.getTitulo(),
//                departamento.getPessoas().size(),
//                departamento.getTarefas().size()
//        );
    }
}
