package br.com.gestao_vagas.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException() {
        super("O Usuário inserido já está sendo utilizado por outra pessoa.");
    }
}
