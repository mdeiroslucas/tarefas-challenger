package br.com.devlucas.tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "tarefa")
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Título da tarefa não pode ser vazio!")
    private String titulo;
    @NotBlank(message = "Descricao da tarefa não pode ser vazio!")
    private String descricao;

    @NotNull(message = "Prazo da tarefa não pode ser vazio!")
    private LocalDate prazo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDepartamento", nullable = false)
    @NotNull(message = "Departamento da tarefa não pode ser vazio!")
    private Departamento departamento;

    @NotNull(message = "Duração da tarefa não pode ser vazia!")
    @Min(value = 1, message = "A duração mínima é 1")
    @Max(value = 365, message = "A duração máxima é 365")
    private Integer duracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    private Boolean finalizado = false;



    public Tarefa() {}

    public Tarefa(Long id, String titulo, String descricao, LocalDate prazo, Departamento departamento, Integer duracao, Pessoa pessoa, Boolean finalizado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.departamento = departamento;
        this.duracao = duracao;
        this.pessoa = pessoa;
        this.finalizado = finalizado;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prazo=" + prazo +
                ", departamento=" + departamento +
                ", duracao=" + duracao +
                ", pessoa=" + pessoa +
                ", finalizado=" + finalizado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getId(), tarefa.getId()) && Objects.equals(getTitulo(), tarefa.getTitulo()) && Objects.equals(getDescricao(), tarefa.getDescricao()) && Objects.equals(getPrazo(), tarefa.getPrazo()) && Objects.equals(getDepartamento(), tarefa.getDepartamento()) && Objects.equals(getDuracao(), tarefa.getDuracao()) && Objects.equals(getPessoa(), tarefa.getPessoa()) && Objects.equals(getFinalizado(), tarefa.getFinalizado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getDescricao(), getPrazo(), getDepartamento(), getDuracao(), getPessoa(), getFinalizado());
    }
}