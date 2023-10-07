package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import br.com.devlucas.tarefas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PessoaDTO> listarPessoas() {
        return pessoaService.listarPessoas();
    }
}
