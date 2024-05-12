# Projeto Spring Boot Gestão de Vagas

Este é um projeto Spring Boot que utiliza as seguintes tecnologias:

## Tecnologias Utilizadas

- **Maven**: Ferramenta de automação de compilação utilizada principalmente para projetos Java.
- **Java 17**: A versão mais recente do Java, trazendo novos recursos e melhorias de desempenho.
- **Spring 3.1.11**: Framework para desenvolvimento de aplicações Java baseado em inversão de controle e injeção de dependência.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional de código aberto.
- **Docker**: Plataforma de código aberto que facilita a criação, implantação e execução de aplicativos em contêineres.

## Dependências

- **Lombok**: Biblioteca que automatiza a geração de código boilerplate em classes Java, como getters e setters.
- **Spring Web**: Módulo do Spring Framework para criar aplicativos da web.
- **Spring Dev Tools**: Conjunto de ferramentas para facilitar o desenvolvimento de aplicações Spring.
- **Spring Boot Starter Validation**: Starter do Spring Boot para validação de dados.
- **Spring Data JPA**: Parte do Spring Data para facilitar a implementação de repositórios baseados em JPA.
- **Jakarta**: Conjunto de especificações e APIs para desenvolvimento de software corporativo em Java.
- **Hibernate**: Framework de mapeamento objeto-relacional para Java.
- **Spring Security**: Estrutura de segurança para aplicações Java.

## Entidades

O projeto possui as seguintes entidades:

### Candidate

Representa um candidato em um processo de recrutamento.

### Job

Representa uma vaga de emprego oferecida pela empresa.

### Company

Representa uma empresa que oferece vagas de emprego.

## Como Executar

Para executar este projeto localmente, certifique-se de ter o Docker instalado. Em seguida, siga estas etapas:

1. Clone este repositório:
   ```
   git clone https://github.com/guiags/Gestao_Vagas.git
   ```

2. Navegue até o diretório do projeto:
   ```
   cd Gestao_Vagas
   ```

3. Execute o contêiner Docker:
   ```
   docker-compose up
   ```

4. O aplicativo estará acessível em [http://localhost:8080](http://localhost:8080).

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autor

Este projeto foi desenvolvido por Guilherme Augusto Guerra Santos(https://github.com/guiags).

```