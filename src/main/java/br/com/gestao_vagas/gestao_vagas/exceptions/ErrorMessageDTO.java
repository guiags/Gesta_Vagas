package br.com.gestao_vagas.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

//Classe que ira receber os erros da requisição
@Data //Getters e Setters
@AllArgsConstructor //Construtor com os argumentos
public class ErrorMessageDTO {
    private String message;
    private String field;
}
