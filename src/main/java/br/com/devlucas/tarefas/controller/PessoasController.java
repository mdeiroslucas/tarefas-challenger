package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.ListaPessoasEMediaDeHorasDTO;
import br.com.devlucas.tarefas.dto.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import br.com.devlucas.tarefas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ListagemPessoaDTO> listarPessoas() {
        return pessoaService.listarPessoas();
    }



    @GetMapping("/gastos")
    public List<ListaPessoasEMediaDeHorasDTO> listarPessoasEMediaDeHorasGastaPorTarefa() {
        return pessoaService.listarPessoasEMediaDeHorasGastaPorTarefa();
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO, UriComponentsBuilder uriBuilder){
        System.out.println(pessoaDTO);
        return null;
//        var pessoa =  pessoaService.create(pessoaDTO);
//        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.id()).toUri();
//
//        return ResponseEntity.created(uri).body(pessoa);
    }


}
