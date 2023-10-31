package br.com.devlucas.tarefas.repository;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);

    @Query("SELECT AVG(t.duracao) FROM Tarefa t WHERE t.pessoa = :pessoa AND t.prazo >= :dataInicial AND t.prazo <= :dataFinal")
    Double findMediaHorasGastasPorPessoaNoIntervalo(
            @Param("pessoa") Pessoa pessoa,
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal
    );

    Page<Pessoa> findAll(Pageable paginacao);

//    @Query("Select p.nome from pessoa p inner join tarefa t on t.pessoaid = p.id where tarefa.datainicial is between  ")
//    List<Pessoa> findByNomeAnddataInicialBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
//    @Param("dataInicial")
//     @Param("dataFinal")

//    @Query("SELECT COUNT(p) FROM Pessoa p WHERE p.departamento = :departamento")
//    long countByDepartamento(@Param("departamento") Departamento departamento);
}
