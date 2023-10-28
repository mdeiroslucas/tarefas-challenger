package br.com.devlucas.tarefas.repository;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.model.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("""
    SELECT 
        t 
    FROM 
        Tarefa t
    JOIN FETCH
        t.departamento
    WHERE
        t.pessoa IS NULL
    ORDER BY
        t.prazo

    """)
    Page<Tarefa> findByPessoaIsNullOrderByPrazo(Pageable paginacao);
}
