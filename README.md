<div align="center">

![](https://img.shields.io/badge/Status-%20Concluído-green)
</div>

<div align="center">

# POC Kafka com Arquitetura Hexagonal ou Ports & Adapters Architecture

![](https://img.shields.io/badge/Autor-Francis%20Leandro%20-brightgreen)
![](https://img.shields.io/badge/Language-java-brightgreen)
![](https://img.shields.io/badge/Framework-springboot-brightgreen)
![](https://img.shields.io/badge/Mensageria-Kafka-brightgreen)
![](https://img.shields.io/badge/Arquitetura-Hexagonal-brightgreen)

</div> 

<div align="center">

## Arquitetura
![image](https://user-images.githubusercontent.com/30552983/209452432-e87027e9-7802-4275-b3b3-cfd2c5d38b1e.png)

![image](https://user-images.githubusercontent.com/30552983/209452250-a3f673fd-b61a-407d-90db-420156c3178f.png)
</div>

## Fundamentos teóricos

> Ports & Adapters Architecture ou Arquitetura Hexagonal: A arquitetura hexagonal, ou arquitetura de portas e adaptadores, é um padrão arquitetural usado no design de software. O objetivo é criar componentes de aplicativos fracamente acoplados que possam ser facilmente conectados ao ambiente de software por meio de portas e adaptadores.


> **Vantagens😆🧘👍🌈🌞**
```
 - Facilidade de plugar/desplugar frameworks, tecnologias e bancos de dados externos, gerando uma independência na aplicação.
 - Facilmente escalável e testável.
 - A arquitetura facilita que várias equipes/desenvolvedores trabalhem no mesmo projeto sem esbarrar em alterações um dos outros. “no conflict”
 - Fácil de adicionar novas funcionalidades. A dificuldade de adicionar novas funcionalidades para a aplicação é constante e relativamente pequena, principalmente quando o projeto já está grande.
 - É fácil extrair e separar partes da aplicação para micro serviços.
```

> **Desvantagens 😥👺👎😈🌑**
```
 - É uma arquitetura complexa e depende de um bom conhecimento em princípios de desenvolvimento, como SOLID, clean architecture e DDD. Desenvolvedores menos experientes poderão ter dificuldades em trabalhar em um projeto com uma arquitetura hexagonal.
 - Aplicações menores terão mais problemas do que soluções em utilizar esta arquitetura 🤔. Logo, não é recomendado para aplicações com operações simples e poucos adaptadores. O foco maior da arquitetura hexagonal são as aplicações que possuem vários adaptadores externos e múltiplas funcionalidades.
```

## Funcionalidades

| Métodos de requisição HTTP  | Descrição                       |
|-----------------------------|---------------------------------|
| `POST`                      | Inserir cliente                 |
| `GET`                       | Listar todos os clientes salvos |
| `GET`                       | Buscar cliente por Id           |
| `PUT`                       | Atualizar cliente               |
| `DELETE`                    | Deletar cliente                 |

##  Pré -requisitos

- [ `Java 19+` ](https://www.oracle.com/java/technologies/downloads/#java19)
- [ `Maven 3+` ](https://maven.apache.org/download.cgi)
- [ `Docker-Compose` ](https://docs.docker.com/compose/install/)
- [ `Docker` ](https://www.docker.com/)
  - Imagem Apache Kafka
  - Imagem Apache ZooKeeper

## Tecnologias
- Java 19
- Apache Maven
- Apache ZooKeeper
- Apache Kafka
- Spring Boot 2.7.7
  - spring-boot-starter-web
  - spring-boot-starter-data-jpa
  - spring-boot-devtools
- Lombok
- H2
- Tomcat (Embedded no Spring Boot)
- Git

## Portas
| Aplicação                        | Porta |
|----------------------------------|-------|
| poc-kafka-hexagonal-architecture | 8080  |
| kafka                            | 9092  |
| zookeeper                        | 2181  |

## Links

- Aplicação
  - http://localhost:8080
  - https://viacep.com.br/ws/{zipCode}/json/

>## Setup

### Executando a aplicação com maven
- Na raiz do projeto execute o seguinte comando:
  ```
  ./mvnw clean package -DskipTests
  ```

### Gerando imagem docker
- Na raiz do projeto execute o seguinte comando para criar a imagem docker da aplicação:
  ```
  docker build --tag hexagonal-architecture .
  ```  

### Executar docker-compose para subir aplicação com container docker
- Dentro da pasta docker-compose, execute o seguinte comando para subir os containers:
  ```
  docker-compose up -d
  ```
- Execute o seguinte comando para verificar os status do containers docker:
  ```
  docker-compose ps
  ```

### Method: POST
- URL: http://localhost:8080/api/v1/customer/save/{zipCode}
  #### Payload Request:
  ```
  {
  "name": "Teste-01",
  "cpf": "001.002.003-04"
  }
  ```
### Method: GET
- URL: http://localhost:8080/api/v1/customer/findAll
### Method: GET
- URL: http://localhost:8080/api/v1/customer/find/{id}
### Method: PUT
  - URL: http://localhost:8080/api/v1/customer/update/{id}
    #### Payload Request:
    ```
    {
    "name": "Teste-02",
    "cpf": "001.002.003-04"
    }
    ```
### Method: DELETE
- URL: http://localhost:8080/api/v1/customer/delete/{id}
  
#
  
>## Desenvolvedores

**Leandro D'Souza**
- LinkedIn - www.linkedin.com/in/francis-leandro-de-souza
- GitHub - https://github.com/lsouzatj