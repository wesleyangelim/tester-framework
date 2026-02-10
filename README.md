# Tester Framework

Projeto de estudos para testes automatizados em Java com Gradle, JUnit 5 e
REST-assured.

## O que foi feito ate o momento
- Configuracao do Gradle com JUnit 5 e REST-assured.
- Ajuste de logging de testes (passed/skipped/failed).
- Testes de API com REST-assured para:
  - GET de clientes (lista vazia quando nao ha cadastro).
  - POST para cadastrar cliente.
  - PUT para atualizar cliente.
  - DELETE para remover cliente.

## Dependencias principais
- JUnit 5
- REST-assured

## Como executar os testes
```powershell
.\gradlew test
```

## Observação

A API utilizada nos endpoints do testes esta disponivel em:
https://github.com/vinnypessoni/api-clientes-exemplo-microservico. 
Essa é a api que esta em  `http://localhost:8080/`, 
com endpoints como `/cliente` e `/cliente/{id}`



