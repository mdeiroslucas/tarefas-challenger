package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.dto.mapper.PessoaMapper;
import br.com.devlucas.tarefas.repository.PessoaRepository;
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

    public List<PessoaDTO> listarPessoas(){
        return pessoaRepository.findAll().stream().map(pessoaMapper::toDTO).toList();
    }
}
