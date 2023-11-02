package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.pessoa.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.pessoa.PessoaDTO;
import br.com.devlucas.tarefas.dto.tarefa.TarefaDTO;
import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class PessoasControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<PessoaDTO> dadosDeCriacaoPessoa;

    @Autowired
    private JacksonTester<PessoaDTO> dadosRetornoDecriacaoPessoa;

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void listarPessoas() throws Exception {
    }

    @Test
    void buscarPessoaPorNome() {
    }

    @Test
    void create() throws Exception {
    }

    @Test
    void update() {
    }

    @Test
    void deletar() {
    }

    @BeforeEach
    void setUp(){
        var departamento = cadastrarDepartamento("Desenvolvimento");
        var pessoa = cadastrarPessoa(1L, "Lucas", departamento);
        var tarefaSemPessoa = cadastrarTarefa("test1", "Tarefa sem pessoa", LocalDate.parse("27/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 7, null, false);
        var tarefaComPessoa = cadastrarTarefa("test1", "Tarefa sem pessoa", LocalDate.parse("27/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 2, pessoa, false);


    }

    private Tarefa cadastrarTarefa(String titulo, String descricao, LocalDate prazo, Departamento departamento, Integer duracao, Pessoa
            pessoa, Boolean finalizado) {
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