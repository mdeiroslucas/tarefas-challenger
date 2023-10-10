package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.ListaPessoasEMediaDeHorasDTO;
import br.com.devlucas.tarefas.dto.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.dto.mapper.PessoaMapper;
import br.com.devlucas.tarefas.infra.exception.RegistroNaoEncontrado;
import br.com.devlucas.tarefas.infra.exception.ValidacaoException;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaMapper pessoaMapper;

    public List<ListagemPessoaDTO> listarPessoas(){
        return pessoaRepository.findAll().stream().map(ListagemPessoaDTO::new).toList();
    }

    public List<ListaPessoasEMediaDeHorasDTO> listarPessoasEMediaDeHorasGastaPorTarefa(){
        return pessoaRepository.findAll().stream().map(ListaPessoasEMediaDeHorasDTO::new).toList();
    }

    public PessoaDTO create(@Valid PessoaDTO pessoaDTO){
        return pessoaMapper.toDTO(pessoaRepository.save(pessoaMapper.toModel(pessoaDTO)));
    }

    public PessoaDTO update(@NotNull @Positive Long id, @Valid PessoaDTO pessoaDTO) {
        return pessoaRepository.findById(id)
                .map((pessoaUpdate) -> {
                    pessoaUpdate.setNome(pessoaDTO.nome());
                    pessoaUpdate.setDepartamento(pessoaDTO.departamento());
                    pessoaUpdate.setTarefas(pessoaDTO.tarefas());
                    return pessoaMapper.toDTO(pessoaRepository.save(pessoaUpdate));
                }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }
}
