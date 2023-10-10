package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.ListaPessoasEMediaDeHorasDTO;
import br.com.devlucas.tarefas.dto.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.PessoaDTO;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import br.com.devlucas.tarefas.service.PessoaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<ListagemPessoaDTO>> listarPessoas() {
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping("/gastos")
    public ResponseEntity<List<ListaPessoasEMediaDeHorasDTO>> listarPessoasEMediaDeHorasGastaPorTarefa() {
        return ResponseEntity.ok(pessoaService.listarPessoasEMediaDeHorasGastaPorTarefa());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO, UriComponentsBuilder uriBuilder){
        var pessoa =  pessoaService.create(pessoaDTO);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.id()).toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PessoaDTO> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaService.update(id, pessoaDTO));
    }


}
