package br.com.devlucas.tarefas.model;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "pessoa")
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Tarefa> tarefas = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
    }

//    public Pessoa(Long id, String nome, Departamento departamento, List<Tarefa> tarefas) {
//        this.id = id;
//        this.nome = nome;
//        this.departamento = departamento;
//        this.tarefas = tarefas;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
