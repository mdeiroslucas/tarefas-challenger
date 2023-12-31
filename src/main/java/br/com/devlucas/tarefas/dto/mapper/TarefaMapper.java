package br.com.devlucas.tarefas.dto.mapper;

import br.com.devlucas.tarefas.dto.tarefa.AlocaPessoaTarefaDTO;
import br.com.devlucas.tarefas.dto.tarefa.TarefaConcluidaDTO;
import br.com.devlucas.tarefas.dto.tarefa.TarefaDTO;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {
    public TarefaDTO toDTO (Tarefa tarefa){
        if (tarefa == null) {
            return null;
        }


        if (tarefa.getPessoa() != null) {
            var pessoa = new Pessoa();
            pessoa.setId(tarefa.getPessoa().getId());
            pessoa.setNome(tarefa.getPessoa().getNome());
            tarefa.setPessoa(pessoa);
        } else {
            tarefa.setPessoa(null);
        }


        if (tarefa.getDepartamento() != null){
            var departamento = new Departamento();
            departamento.setId(tarefa.getDepartamento().getId());
            departamento.setTitulo(tarefa.getDepartamento().getTitulo());
            tarefa.setDepartamento(departamento);
        } else {
            tarefa.setDepartamento(null);
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

    public static TarefaConcluidaDTO toTarefaConcluidaDTO(Tarefa tarefa){
        return new TarefaConcluidaDTO(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getDepartamento().getTitulo(), tarefa.getPessoa().getNome(), tarefa.getFinalizado());
    }

    public AlocaPessoaTarefaDTO alocaPessoaTarefaToDTO(Tarefa tarefa) {
        return new AlocaPessoaTarefaDTO(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrazo(), tarefa.getDepartamento().getId(), tarefa.getPessoa().getId());
    }
}
