package br.com.devlucas.tarefas.infra.exception;

public class RegistroNaoEncontrado extends RuntimeException{

    public RegistroNaoEncontrado(Long id){
        super("Registro não encontrado com id: " + id);
    }
}
