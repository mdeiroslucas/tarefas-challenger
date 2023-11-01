package br.com.devlucas.tarefas.repository;

import br.com.devlucas.tarefas.dto.tarefa.TarefaDTO;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TarefaRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Test
    @DisplayName("Deve retornar tarefas em que nao tem pessoas alocadas e ordena por prazo")
    void findByPessoaIsNullOrderByPrazo() {
        var departamento = cadastrarDepartamento("Desenvolvimento");
        var pessoa = cadastrarPessoa(1L, "Lucas", departamento);
        var tarefaSemPessoa = cadastrarTarefa("test1", "Tarefa sem pessoa", LocalDate.parse("27/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 7, null, false);
        var tarefaComPessoa = cadastrarTarefa("test1", "Tarefa sem pessoa", LocalDate.parse("27/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 2, pessoa, false);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("prazo").ascending());
        Page<Tarefa> tarefasPage = tarefaRepository.findByPessoaIsNullOrderByPrazo(pageable);

        List<Tarefa> tarefas = tarefasPage.getContent();

        for (Tarefa tarefa : tarefas) {
            assertNull(tarefa.getPessoa(), "A tarefa não deve ter uma pessoa alocada");
        }
    }

    @Test
    @DisplayName("Status finalizado da tarefa deve retornar true")
    void setFinalizarTarefaTrue() {
        var tarefa = tarefaRepository.findById(4L).get();

        assertFalse(tarefa.getFinalizado());

        tarefaRepository.setFinalizarTarefaTrue(4L);

        var tarefa2 = tarefaRepository.findById(4L).get();

        assertTrue(tarefa2.getFinalizado());
    }

    private Tarefa cadastrarTarefa(String titulo, String descricao, LocalDate prazo, Departamento departamento, Integer duracao, Pessoa pessoa, Boolean finalizado) {
        var tarefa = new Tarefa(dadosTarefa(titulo, descricao, prazo, departamento, duracao, pessoa, finalizado));
        em.persist(tarefa);
        return tarefa;
    }

    private TarefaDTO dadosTarefa(String titulo, String descricao, LocalDate prazo, Departamento departamento, Integer duracao, Pessoa pessoa, Boolean finalizado) {
        return new TarefaDTO(
                titulo, descricao, prazo, departamento, duracao, pessoa, finalizado
        );
    }

    private Departamento cadastrarDepartamento(String titulo){
        return new Departamento(1L, titulo);
    }

    private Pessoa cadastrarPessoa(Long id, String nome, Departamento departamento) {return new Pessoa (id, nome, departamento);}
}