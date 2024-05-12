package br.com.gestao_vagas.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data //Cria os Getters e Setters com op Lombok 
@Entity(name = "candidate")//Atribui status de entidade a classe criando uma representação dela em uma tabela no db
public class CandidateEntity {
    @Id//Identifica o ID da tabela
    @GeneratedValue(strategy = GenerationType.UUID)//Gera o Id automaticamente ao inserir um novo registro
    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 8, max = 100, message = "O campo [password] deve conter entre 8 e 20 caracteres")
    private String password;
    private String description;
    private String curriculum;
    
    @CreationTimestamp//Anotation do hibernate para definir o memoneto de inserção do registro no banco de dados
    private LocalDateTime createdAt;
    
}