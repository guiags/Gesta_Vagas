package br.com.gestao_vagas.gestao_vagas.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.gestao_vagas.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.gestao_vagas.gestao_vagas.modules.candidate.dto.AuthCandidateDTO;
import br.com.gestao_vagas.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;

@Service
public class AuthCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateDTO authCandidateDTO) throws AuthenticationException{
        var candidate= this.candidateRepository.findByUsername(authCandidateDTO.getUsername()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("User not found");
            }
        );
        //Compara as senhas se elas são iguais
        var passwordMatches = this.passwordEncoder.matches(authCandidateDTO.getPassword(), candidate.getPassword());
        
        //Se for diferente
        if(!passwordMatches){
            throw new AuthenticationException();
        }
        //Se for igual -> Gerar Token 
        Algorithm algorithm = Algorithm.HMAC256("JAVAGAS_@123#");
        var expires_in = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create().withIssuer("jamvagas")
            .withClaim("roles", Arrays.asList("candidate"))
            .withExpiresAt(expires_in)
            .withSubject(candidate.getId().toString())
            .sign(algorithm);

        var authCandidateResponseDTO = AuthCandidateResponseDTO.builder()
            .access_token(token)
            .expires_in(expires_in.toEpochMilli())
            .build();

        return authCandidateResponseDTO;
    }
    
}