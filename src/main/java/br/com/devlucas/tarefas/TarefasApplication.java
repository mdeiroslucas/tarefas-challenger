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

			//Departamento
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
			var departamentoDesenvolvimento = departamentoRepository.findById(3L).get();

			//Pessoas
			Pessoa pessoa = new Pessoa(null, "Camila", departamento);
			Pessoa pessoa2 = new Pessoa(null, "Lucas", departamentoDesenvolvimento);
			pessoaRepository.save(pessoa);
			pessoaRepository.save(pessoa2);

			//Tarefas
			Tarefa t1 = new Tarefa(null, "Tarefa 1", "Testando tarefa 1", LocalDate.parse("27/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamentoDesenvolvimento, 4, pessoa2, false);
			Tarefa t2 = new Tarefa(null, "Tarefa 2", "Testando tarefa 2", LocalDate.parse("20/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 5, pessoa, false);
			Tarefa t3 = new Tarefa(null, "Tarefa 3", "Testando tarefa 3", LocalDate.parse("11/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamentoDesenvolvimento, 5, pessoa, false);			Tarefa t4 = new Tarefa(null, "Tarefa com prazo mais antigo", "Testando tarefa 4", LocalDate.parse("10/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 5, null, false);
			Tarefa t5 = new Tarefa(null, "Tarefa com prazo mais antigo", "Testando tarefa 5", LocalDate.parse("11/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamentoDesenvolvimento, 5, null, false);
			Tarefa t6 = new Tarefa(null, "Tarefa com prazo mais antigo", "Testando tarefa 6", LocalDate.parse("12/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")), departamento, 5, null, false);


			tarefaRepository.save(t1);
			tarefaRepository.save(t2);
			tarefaRepository.save(t3);
			tarefaRepository.save(t4);
			tarefaRepository.save(t5);
			tarefaRepository.save(t6);

		};
	}

}
