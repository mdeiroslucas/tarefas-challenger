package br.com.devlucas.tarefas.dto.mapper;

import br.com.devlucas.tarefas.dto.PessoaDTO;
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
                pessoa.getDepartamento()
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

        pessoa.setNome(pessoaDTO.nome());
        pessoa.setDepartamento(pessoaDTO.departamento());

        return pessoa;
    }
}
