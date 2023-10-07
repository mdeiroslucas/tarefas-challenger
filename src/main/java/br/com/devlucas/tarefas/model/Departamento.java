package br.com.devlucas.tarefas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "departamento")
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

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

    public Long getId() {
        return id;
    }
        public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
