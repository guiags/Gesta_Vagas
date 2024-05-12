package br.com.gestao_vagas.gestao_vagas.modules.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCandidateDTO {
    private String password;
    private String username;
}
