package br.com.devlucas.tarefas.service;

import br.com.devlucas.tarefas.dto.tarefa.AlocaPessoaTarefaDTO;
import br.com.devlucas.tarefas.dto.tarefa.TarefaConcluidaDTO;
import br.com.devlucas.tarefas.dto.tarefa.TarefaDTO;
import br.com.devlucas.tarefas.dto.mapper.TarefaMapper;
import br.com.devlucas.tarefas.infra.exception.ValidacaoException;
import br.com.devlucas.tarefas.model.Tarefa;
import br.com.devlucas.tarefas.repository.DepartamentoRepository;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import br.com.devlucas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<TarefaDTO> getTarefasSemPessoas(Pageable paginacao){

        Page<Tarefa> tarefasSemPessoasPage = tarefaRepository.findByPessoaIsNullOrderByPrazo(paginacao);
        return tarefasSemPessoasPage.map(tarefaMapper::toDTO);
    }

    public TarefaConcluidaDTO finalizarTarefa(Long id) {
        var tarefa = tarefaRepository.getReferenceById(id);
        tarefaRepository.setFinalizarTarefaTrue(tarefa.getId());
        return TarefaMapper.toTarefaConcluidaDTO(tarefa);
    }

    public TarefaDTO alocaPessoaNaTarefa(Long id, AlocaPessoaTarefaDTO alocaPessoaTarefaDTO) {
        if (!tarefaRepository.existsById(id)) {
            throw new ValidacaoException("Id da tarefa informada não existe!");
        }

        if (!pessoaRepository.existsById(alocaPessoaTarefaDTO.idPessoa())) {
            throw new ValidacaoException("Id da pessoa informada não existe!");
        }

        var pessoa = pessoaRepository.findById(alocaPessoaTarefaDTO.idPessoa()).get();
        var tarefa = tarefaRepository.findById(id).get();

        if (pessoa.getDepartamento().getId() != tarefa.getDepartamento().getId()){
            throw new ValidacaoException("O departamento da tarefa, não é o mesmo departamento da pessoa selecionada!");
        }

        tarefa.setPessoa(pessoa);

        return tarefaMapper.toDTO(tarefaRepository.save(tarefa));
    }
}
