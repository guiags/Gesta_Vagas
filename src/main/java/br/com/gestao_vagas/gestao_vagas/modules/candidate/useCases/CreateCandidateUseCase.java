package br.com.gestao_vagas.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao_vagas.gestao_vagas.exceptions.UserFoundException;
import br.com.gestao_vagas.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.gestao_vagas.gestao_vagas.modules.candidate.CandidateRepository;


@Service // Define que a classe é uma camada de serviços
public class CreateCandidateUseCase {

    @Autowired//@Autowired para instanciar o CandidateRepository e acessar os métodos disponíveis. Ao salvar um candidato, o repositório se encarrega de enviar os dados para o banco de dados.
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){

        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserFoundException();
        });//Verifica caso em que o usuário ou email já existem. No próximo vídeo, iremos tratar essa exceção e fazer a validação na criação do usuário.


        return this.candidateRepository.save(candidateEntity);//Salva o objeto CandidateEntity no banco de dados na tabela candidate conforme definido na Anotation @Entity(name = "candidate")
    }
}
