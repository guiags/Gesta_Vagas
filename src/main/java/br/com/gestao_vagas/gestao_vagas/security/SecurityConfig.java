package br.com.gestao_vagas.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf ->csrf.disable())
        .authorizeHttpRequests(auth ->{
            auth.requestMatchers("/candidate/").permitAll();
            auth.requestMatchers("/company/").permitAll();
            auth.requestMatchers("/auth/company").permitAll();
            auth.requestMatchers("/auth/candidate").permitAll();//Company e candidate devem ser permitidos sem autenticação
            auth.anyRequest().authenticated();//Job autenticado
        })       
        .addFilterBefore(securityFilter, BasicAuthenticationFilter.class)
        ;//Desabilitando a vulnerabildiade do csrf
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
