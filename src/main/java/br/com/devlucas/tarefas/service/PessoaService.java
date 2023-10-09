package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.ListaPessoasEMediaDeHorasDTO;
import br.com.devlucas.tarefas.dto.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.dto.mapper.PessoaMapper;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
