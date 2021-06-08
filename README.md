<h2>Desenvolvimento de um sistema de gerenciamento de veículos de usuários em API REST com Spring Boot</h2>

Projeto desenvolvido para desafio proposto pela ZUP no Orange Talents. Para o desafio, foi desenvolvido um pequeno sistema para o cadastramento de usuarios, 
cadastramento de veiculos e consulta de um usuário com todos os veiculos cadastrados através de uma API REST, criada com o Spring Boot.
O projeto foi desenvolvido conforme as etapas:

* Setup inicial de projeto com o Spring Boot Initialzr
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro e leitura de usuários no sistema).
* Desenvolvimento de operação de cadastro de veículos no sistema.
* Spring-Cloud-Feign usado para integração da API da Fipe para consulta dos valores dos veículos cadastrados;
* Desenvolvimento das operações acima com o padrão arquitetural REST.

Endpoint para cadastro de usuários:
```
http://localhost:8080/v1/usuarios
```

Endpoint para cadastro de veículos:
```
http://localhost:8080/v1/veiculos
```

Endpoint para consulta de veiculos cadastrados por usuário:
```
http://localhost:8080/v1/usuarios/{id}/veiculos
```


Pré-requisitos para a execução do projeto:

* Java 11 ou versões superiores.
* Gradle 7.0.2 ou versões superiores.
