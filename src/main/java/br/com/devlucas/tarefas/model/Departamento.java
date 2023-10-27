package br.com.devlucas.tarefas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Departamento")
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

//    @OneToMany(mappedBy = "departamento")
//    private List<Pessoa> pessoas;
//
//    @OneToMany(mappedBy = "departamento")
//    private List<Tarefa> tarefas;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idPessoa")
//    private List<Pessoa> pessoas;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idTarefa")
//    private List<Tarefa> tarefas;

    public Departamento() {
    }

    public Departamento(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

//    public List<Tarefa> getTarefas() {
//        return tarefas;
//    }
//
//    public void setTarefas(List<Tarefa> tarefas) {
//        this.tarefas = tarefas;
//    }
//
//    public List<Pessoa> getPessoas() {
//        return pessoas;
//    }
//
//    public void setPessoas(List<Pessoa> pessoas) {
//        this.pessoas = pessoas;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitulo(), that.getTitulo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo());
    }


    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Departamento that)) return false;
//        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitulo(), that.getTitulo()) && Objects.equals(getPessoas(), that.getPessoas()) && Objects.equals(getTarefas(), that.getTarefas());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getTitulo(), getPessoas(), getTarefas());
//    }
}
