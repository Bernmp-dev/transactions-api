# Documentação do Projeto Transactions-API

# 1. Visão Geral

Este projeto é uma API Spring Boot desenvolvida para gerenciar transações financeiras. A API permite aos usuários criar, listar, atualizar e excluir transações, além de oferecer funcionalidades para agrupar transações por categoria e filtrar transações por datas específicas. O objetivo principal é fornecer uma solução simples e eficaz para o gerenciamento de transações financeiras, com foco em facilidade de uso e integração com outros sistemas ou interfaces de usuário.

## 2. Tecnologias e Ferramentas Utilizadas

O projeto foi desenvolvido utilizando uma variedade de tecnologias e ferramentas modernas para garantir eficiência, segurança e facilidade de manutenção:

- **Spring Boot (3.2.2)**: Framework escolhido para o desenvolvimento da aplicação, facilitando a configuração e o empacotamento da aplicação.
- **Java (versão 17)**: Linguagem de programação usada, aproveitando suas características de robustez, orientação a objeto e segurança.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional utilizado para armazenar e gerenciar os dados das transações.
- **Lombok**: Biblioteca Java que ajuda a reduzir o código boilerplate, especialmente para modelos de dados, através do uso de anotações.
- **Spring Data JPA**: Facilita a implementação de repositórios baseados em JPA para persistência de dados.
- **Spring Actuator**: Fornece recursos prontos para uso para monitoramento e gerenciamento da aplicação em tempo de execução.
- **Springdoc OpenAPI**: Usado para gerar documentação dinâmica da API REST, facilitando a visualização e o teste dos endpoints da API.
- **Swagger**: Integrado através do Springdoc OpenAPI para criar uma interface de usuário interativa que permite visualizar e interagir com a API. O Swagger é acessível pelo caminho `/swagger-ui.html`, oferecendo uma descrição detalhada dos endpoints da API, seus parâmetros e os modelos de dados.
- **Docker**: Utilizado opcionalmente para containerização da aplicação, permitindo uma implantação e execução consistentes em qualquer ambiente.
- **Maven**: Ferramenta de automação de compilação utilizada para gerenciar as dependências do projeto e construir o pacote da aplicação.

## 3. Configuração do Ambiente

### Pré-requisitos
- JDK 17
- Maven
- Docker (opcional para contêineres MySQL)

### Instalação e Execução
Clone o repositório e execute o projeto via Maven:
```bash
mvn spring-boot:run
```

## 5. API Endpoints

Os endpoints da API incluem operações para listar, criar, atualizar e excluir transações, além de endpoints para agrupamento e filtragem.

### Transações

- **Listar Todas as Transações**
    - **GET** `/transaction`
    - **Descrição**: Retorna uma lista de todas as transações.

- **Buscar Transação por ID**
    - **GET** `/transaction/{id}`
    - **Descrição**: Retorna os detalhes de uma transação específica.
    - **Parâmetros**:
        - `id`: ID da transação desejada.

- **Criar Nova Transação**
    - **POST** `/transaction`
    - **Descrição**: Insere uma nova transação no sistema.
    - **Corpo da Requisição**:
      ```
      {
        "category": "Alimentação",
        "value": 150.50,
        "date": "2024-01-15"
      }
      ```

- **Atualizar Transação**
    - **PUT** `/transaction/{id}`
    - **Descrição**: Atualiza os dados de uma transação existente.
    - **Parâmetros**:
        - `id`: ID da transação a ser atualizada.
    - **Corpo da Requisição**:
      ```
      {
        "category": "Educação",
        "value": 300.00,
        "date": "2024-02-10"
      }
      ```

- **Excluir Transação**
    - **DELETE** `/transaction/{id}`
    - **Descrição**: Remove uma transação do sistema.
    - **Parâmetros**:
        - `id`: ID da transação a ser excluída.

### Agrupamentos e Filtros

- **Agrupar Transações por Categoria**
    - **GET** `/transaction/sum`
    - **Descrição**: Retorna a soma dos valores das transações agrupadas por categoria.
- 
    - **GET** `/transaction/sum?category={category}`
    - **Descrição**: Retorna a soma dos valores das transações agrupadas por uma categoria específica.

- **Filtrar Transações por Data**
    - **GET** `/transaction?date={date}`
    - **Descrição**: Lista transações realizadas em uma data específica.
    - **Parâmetros de Consulta**:
        - `date`: Data das transações no formato `YYYY-MM-DD`.

## 6. Tratamento de Erros

O sistema utiliza `ExceptionController` para tratar exceções de forma uniforme e fornecer respostas de erro claras e informativas. Aqui estão alguns exemplos de como os erros são tratados:

- **NotFoundExceptions**: Quando uma transação específica não é encontrada, o sistema retorna um erro 404 com uma mensagem indicando que o recurso não foi encontrado.

- **ConstraintViolationException**: Erros de validação de dados são capturados e retornam uma resposta de erro 400, detalhando o que está incorreto na solicitação enviada.

- **Erro Genérico**: Para outras exceções não capturadas especificamente, o sistema pode retornar um erro 500, indicando um erro interno do servidor, juntamente com uma mensagem genérica.


## 7. Documentação da API

A documentação da API é gerada automaticamente pelo Springdoc OpenAPI, que é integrado ao projeto Spring Boot. Isso proporciona uma interface de usuário interativa para explorar todos os endpoints da API, seus parâmetros, corpos de requisição e respostas esperadas.

Para acessar a documentação da API:

1. Inicie a aplicação Spring Boot.
2. Abra um navegador e acesse a URL: `http://localhost:8080/swagger-ui.html`

Na interface do Swagger UI, você encontrará:

- Uma lista completa de todos os endpoints disponíveis na API, organizados por controlador.
- Detalhes sobre os métodos HTTP suportados (GET, POST, PUT, DELETE) e os caminhos dos endpoints.
- A capacidade de testar cada endpoint diretamente da interface, fornecendo parâmetros necessários e visualizando as respostas da API.
- Modelos de solicitação e resposta, incluindo a estrutura dos objetos JSON esperados e retornados pela API.
