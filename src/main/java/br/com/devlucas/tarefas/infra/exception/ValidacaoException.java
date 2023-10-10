package br.com.devlucas.tarefas.infra.exception;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String mensagem){
        super(mensagem);
    }
}
