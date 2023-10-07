package br.com.devlucas.tarefas;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import br.com.devlucas.tarefas.model.Tarefa;
import br.com.devlucas.tarefas.repository.DepartamentoRepository;
import br.com.devlucas.tarefas.repository.PessoaRepository;
import br.com.devlucas.tarefas.repository.TarefaRepository;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(TarefaRepository tarefaRepository, DepartamentoRepository departamentoRepository, PessoaRepository pessoaRepository){
		return args -> {

			departamentoRepository.deleteAll();
			tarefaRepository.deleteAll();
			pessoaRepository.deleteAll();

			Departamento d = new Departamento();
			Departamento d2 = new Departamento();
			Departamento d3 = new Departamento();
			d.setTitulo("Financeiro");
			d2.setTitulo("Comercial");
			d3.setTitulo("Desenvolvimento");

			departamentoRepository.save(d);
			departamentoRepository.save(d2);
			departamentoRepository.save(d3);

//			var departamento = departamentoRepository.getReferenceById(1L);
			var departamento = departamentoRepository.findById(1L).get();

			Pessoa pessoa = new Pessoa(null, "Camila", departamento);
			pessoaRepository.save(pessoa);

			Tarefa t = new Tarefa();
			t.setTitulo("Correção 1");
			t.setDescricao("Corrigir bug do Hibernate");
			t.setDuracao(3);
			t.setDepartamento(departamento);
			t.setPessoa(pessoa);
			t.setPrazo(LocalDate.parse("20/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			tarefaRepository.save(t);

		};
	}

}
