package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.dto.pessoa.ListagemPessoaDTO;
import br.com.devlucas.tarefas.dto.pessoa.PessoaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

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

    @Test
    void listarPessoas() throws Exception {
    }

    @Test
    void buscarPessoaPorNome() {
    }

    @Test
    void create() throws Exception {
        var response = mvc.perform(
                post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content()
        ).andReturn().getResponse();
    }

    @Test
    void update() {
    }

    @Test
    void deletar() {
    }
}