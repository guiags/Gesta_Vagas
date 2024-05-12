package br.com.gestao_vagas.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

//Repositório CandidateRepository.java, utilizando uma interface que estende o JPARepository. Essa interface permite acessar métodos pré-definidos pelo Spring Data JPA para interagir com o banco de dados. 
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);//Verificar se um usuário ou email já existem no banco de dados. Utilizando o método findByUsernameOrEmail para fazer essa busca de forma automatizada, passando os parâmetros username e email.
}
