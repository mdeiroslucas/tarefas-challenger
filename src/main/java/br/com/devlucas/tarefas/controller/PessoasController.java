package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.pessoa.ListaPessoasEMediaDeHorasDTO;
import br.com.devlucas.tarefas.dto.pessoa.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.pessoa.PessoaDTO;
import br.com.devlucas.tarefas.service.PessoaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ListagemPessoaDTO>> listarPessoas() {
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    @GetMapping("/outras")
    @ResponseStatus(HttpStatus.OK)
    public Page<ListagemPessoaDTO> listarPessoasPorNome(@PageableDefault(size = 1) Pageable paginacao) {
        return pessoaService.listarPessoasPorPaginacao(paginacao);
    }

    @GetMapping("/gastos")
    public ResponseEntity<List<ListaPessoasEMediaDeHorasDTO>> buscarPessoaPorNome(
            @RequestParam String nome,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicial,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFinal
    ) {
        return ResponseEntity.ok(pessoaService.findMediaHorasGastasPorPessoaNoIntervalo(nome, dataInicial, dataFinal));
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

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable @Positive @NotNull Long id){
        pessoaService.delete(id);
    }




}
