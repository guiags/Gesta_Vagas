package br.com.gestao_vagas.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.gestao_vagas.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.gestao_vagas.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired//@Autowired para instanciar o CandidateRepository e acessar os métodos disponíveis. Ao salvar um candidato, o repositório se encarrega de enviar os dados para o banco de dados.
    private CreateCandidateUseCase createCandidateUseCase;
    //private CandidateRepository candidateRepository; Removida para camada de serviços do UseCase

    //POST
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){
        /*System.out.println("Candidato:");
        System.out.println(candidateEntity.getEmail());
        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserFoundException();
        });//Verifica caso em que o usuário ou email já existem. No próximo vídeo, iremos tratar essa exceção e fazer a validação na criação do usuário.
        return this.candidateRepository.save(candidateEntity);//Salva o objeto CandidateEntity no banco de dados na tabela candidate conforme definido na Anotation @Entity(name = "candidate")
        REMOVIDO PARA IMPLEMNTAÇÂO DO USECASE*/
        try {
            var result = createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    

}
