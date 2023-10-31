package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.pessoa.ListaPessoasEMediaDeHorasDTO;
import br.com.devlucas.tarefas.dto.pessoa.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.pessoa.PessoaDTO;
import br.com.devlucas.tarefas.dto.mapper.PessoaMapper;
import br.com.devlucas.tarefas.infra.exception.RegistroNaoEncontrado;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import br.com.devlucas.tarefas.model.Tarefa;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public Page<ListagemPessoaDTO> listarPessoasPorPaginacao(Pageable paginacao){
        return pessoaRepository.findAll(paginacao).map(ListagemPessoaDTO::new);
    }

    public List<ListaPessoasEMediaDeHorasDTO> findMediaHorasGastasPorPessoaNoIntervalo(String nome, LocalDate dataInicial, LocalDate dataFinal) {

        return pessoaRepository.findByNome(nome).stream()
                .map(pessoa ->
                {
                    double mediaHorasGastas = pessoa.getTarefas().stream()
                            .filter(tarefa -> tarefa.getPrazo().isAfter(dataInicial) && tarefa.getPrazo().isBefore(dataFinal))
                            .mapToInt(Tarefa::getDuracao)
                            .average()
                            .orElse(0.0);

                    return new ListaPessoasEMediaDeHorasDTO(pessoa.getNome(), mediaHorasGastas);
                }
                )
                .collect(Collectors.toList());
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

    public void delete (@NotNull @Positive Long id){
        pessoaRepository.delete(pessoaRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

//    public List<ListagemPessoaDTO> listaPessoasPorDepartamento(PessoaDTO pessoaDTO) {
//        return pessoaRepository.countByDepartamento(pessoaDTO.departamento());
//    }
}
