package br.com.devlucas.tarefas.dto.mapper;

import br.com.devlucas.tarefas.dto.RetornaListaDeTarefasVazias;
import br.com.devlucas.tarefas.dto.TarefaDTO;
import br.com.devlucas.tarefas.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {
    public TarefaDTO toDTO (Tarefa tarefa){
        if (tarefa == null) {
            return null;
        }

        return new TarefaDTO(
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrazo(),
                tarefa.getDepartamento(),
                tarefa.getDuracao(),
                tarefa.getPessoa(),
                tarefa.getFinalizado()
        );
    }
}
