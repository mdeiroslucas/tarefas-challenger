# Projeto: Desafio de Tarefas

## Descrição
Bem-vindo(a) ao projeto de Manejamento de Tarefas. Um amigo estava realizando este desafio, achei interessante e pedi que me passasse as requisições do projeto para que eu elaborasse a minha solução. Só tive acessi a primeira parte.

## Desenvolvedor
Lucas Medeiros

## Tecnologias Utilizadas
* Linguagem: Java
* Framework: Spring Boot
* Gerenciador de Dependências: Maven
* Persistência de Dados: JPA (Java Persistence API)

## Estrutura do Projeto
O projeto segue a organização de layout by layer, o que significa que os pacotes e classes estão separados das funcionalidades que oferecem. 

## Funcionalidades desejadas:

Parte 1

Precisamos criar uma API de gerenciamento de tarefas para disponibilizar para nossa equipe de front.

Requisitos:

- A API deve ser REST

- Cada pessoa terá um id, nome, departamento e lista de tarefas

- Cada tarefa terá id, título, descrição, prazo, departamento, duração, pessoa alocada e se já foi finalizado.

Funcionalidades desejadas:
Pessoa:

 - Adicionar um pessoa (post/pessoas)

 - Alterar um pessoa (put/pessoas/{id})

 - Remover pessoa (delete/pessoas/{id})

 - Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas.(get/pessoas)

 - Buscar pessoas por nome e período, retorna média de horas gastas por tarefa. (get/pessoas/gastos)


Tarefa:

Concluido - Listar departamento e quantidade de pessoas e tarefas (get/departamentos)
 - Listar 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos. (get/tarefas/pendentes)

 - Adicionar um tarefa (post/tarefas)

 - Finalizar a tarefa (put/tarefas/finalizar/{id})

 - Alocar uma pessoa na tarefa que tenha o mesmo departamento (put/tarefas/alocar/{id})


 OBS: A linguagem para realização do desafio deve ser em Java.

Framework SpringBoot ou Quarkus.

Bancos de dados: MongoDB, PostgreSQL.
