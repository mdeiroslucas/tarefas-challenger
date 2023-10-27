package br.com.devlucas.tarefas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Pessoa")
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    @OneToMany(mappedBy = "pessoa")
    private List<Tarefa> tarefas;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getDepartamento(), pessoa.getDepartamento()) && Objects.equals(getTarefas(), pessoa.getTarefas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDepartamento(), getTarefas());
    }
}
