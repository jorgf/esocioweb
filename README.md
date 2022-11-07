# Projeto de gerenciamento de sócios e dependentes
---
Projeto web (front e back)


## Tecnologias/Linguagens utilizadas
---
- Java 11
- SpringBoot
- Spring MVC
- Hibernate
- Thymeleaf
- Bootstrap
- PostgreSQL
- Maven

## Rotas 
GET
- / -> index
- /socios -> listar todos os sócios
- /socios/cadastro -> retorna form de cadastro
- /socios/{id}/edit -> retorna pág com formulário de atualização de cadastro
- /socios/{id}/delete -> deleter o sócio

POST
- /socios -> cadastrar de novo sócio
- /socios/id -> Atualizar cadastro

A mesma estrutura se aplica para os 'dependentes', sendo suficiente alterar o nome 'socios' por 'dependentes' nas rotas.

## Para testar
Para testar essa aplicação, importe o projeto Maven e configure o arquivo: 'application.properties' com as informações do seu banco de dados.

## Implementar
- Testes unitários
- Reaproveitamento de template com fragmentos do Thymeleaf
- Tratamento de exceções
- APlicar relacionamento OneToMany 
- Apresentar mensagens de erro/avisos na tela do usuário
