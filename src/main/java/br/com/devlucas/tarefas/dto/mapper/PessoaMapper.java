package br.com.devlucas.tarefas.dto.mapper;

import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {
    public PessoaDTO toDTO(Pessoa pessoa){
        if (pessoa == null){
            return null;
        }
        return new PessoaDTO(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getDepartamento(),
                pessoa.getTarefas()
        );
    }

    public Pessoa toModel(PessoaDTO pessoaDTO){
        if (pessoaDTO == null){
            return null;
        }

        Pessoa pessoa = new Pessoa();

        if (pessoaDTO.id() != null){
            pessoa.setId(pessoaDTO.id());
        }

        if (pessoaDTO.tarefas() != null) {
            pessoa.setTarefas(pessoaDTO.tarefas());
        }

        pessoa.setNome(pessoaDTO.nome());

        var departamento = new Departamento();
        departamento.setId(pessoaDTO.departamento().getId());

        pessoa.setDepartamento(departamento);

        return pessoa;
    }
}
