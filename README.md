# <a href="https://imgbb.com/"><img src="https://i.ibb.co/wNCRx9z/image-2025-01-04-T23-13-02-901-Z.png" alt="image-2025-01-04-T23-13-02-901-Z" border="0" width =150 heigth = 100></a> Desenvolva + : API REST

#### Desenvolvido na linguagem Java por:
- [Anderson Alves Santos](https://github.com/santos-anderson)
- [Janaína Cruz](https://github.com/JanaCruzS)
- [Marcos Shirafuchi](https://github.com/marcosfshirafuchi)

## Principais Tecnologias

- <img width="70px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" title = "Java" /> <b>Java 21 :</b> Utilizamos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- <img width="70px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title = "IntelliJIDEA" /> <b>IntelliJIDEA :</b> Utilizamos o IntelliJIDEA como a IDEA para fazer os programas em Java;
- <img width="80px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original-wordmark.svg" title = "Postman"/> <b>Postman :</b> Utilizamos a versão 11.40.4;
- <img width="80px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original-wordmark.svg" title = "Spring boot"/><b>Spring boot :</b> Utilizamos a versão 3.4.4 para testar a API;
- <img width="70px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/azuresqldatabase/azuresqldatabase-original.svg" title = "H2 DataBase" /><b>H2 DataBase :</b> Utilizamos o banco de dados em memória;



## Ada Tech - API REST : IMDB

### Evoluir o projeto do último módulo para uma API REST em Spring Boot com os seguintes itens:
- Persistência em banco de dados (H2 ou Postgres);
- Consumo de uma API externa pública; (opcional);
- Autenticação Básica (opcional);
- Swagger (opcional);
- Frontend (opcional);

### Entregaveis
- O projeto pode ser feito opcionalmente em grupos de 3 até 5 pessoas;
- O projeto deverá ser entregue no github ou zipado no LMS;
- Documentação no REAMDE.md, com os diagramas das classes principais e guia de uso;
- Realizar uma apresentação com os pontos mais desafiadores do projeto, os perrengues passados e um resumo do que foi entregue e o que não pode ser entregue;

### Entrega.
- Entregar o link do repositório do projeto no GitHub.

## Diagrama de classes
<p align = center>
<a href="https://ibb.co/kgBFG7bR"><img src="https://i.ibb.co/4ZtxFqv6/Ada-Tech-IMDB-Final.jpg" alt="Ada-Tech-IMDB-Final" border="0"></a>
</p>

## Tema do projeto
- Desenvolvemos uma aplicação que busca o nome original do filme através da api: OMDb API


## Site da api: OMDB

<p align = center>
<a href="https://ibb.co/FL5M2R4X"><img src="https://i.ibb.co/rRxSYD23/OMDB-API.png" alt="OMDB-API" border="0"></a><br><br>
  
</p>

### Endereco da api do OMDB
https://www.omdbapi.com/

## Testar a API
- Primeiro baixe o projeto: git clone https://github.com/marcosfshirafuchi/Ada-Tech-Programacao-Web-2.git
- Importe o arquivo json que está na pasta: <b>ArquivoJsonParaOPostman</b> no Postman
- Roda o programa no IntelliJ

## Endpoints da aplicação

| Nome do Endpoint         | URL do método                                  | Método no Postman |
| ------------------------ | ---------------------------------------------- | ----------------- |
| Buscar o filme pelo nome | http://localhost:8080/filme?titulo=the forge   | GET               |
| Salvar filme             | http://localhost:8080/filme                    | POST              |
| Buscar lista de filmes   | http://localhost:8080/filme/listarFilmes       | GET               |
| Buscar o filme pelo ID   | http://localhost:8080/filme/1                  | GET               |
| Deletar o filme pelo ID  | http://localhost:8080/filme/1                  | DELETE            |

### Exemplo de cada endpoints

#### Buscar o filme pelo nome

<a href="https://ibb.co/ccgSLZtf"><img src="https://i.ibb.co/vxw6YTmy/GET-01.png" alt="GET-01" border="0"></a>

#### Salvar filme


<a href="https://ibb.co/7xmF6T84"><img src="https://i.ibb.co/JWJPMb0Q/POST.png" alt="POST" border="0"></a>

#### Buscar lista de filmes

<a href="https://ibb.co/5WnrRTQ3"><img src="https://i.ibb.co/wNwSzynq/GET-02.png" alt="GET-02" border="0"></a>


#### Buscar o filme pelo ID


<a href="https://ibb.co/PsNLKvdP"><img src="https://i.ibb.co/SDPjb4zM/GET-03.png" alt="GET-03" border="0"></a>

      
#### Deletar o filme pelo ID


<a href="https://ibb.co/zhP5DyB1"><img src="https://i.ibb.co/8DPBtWfJ/DELETE.png" alt="DELETE" border="0"></a>


## Banco de dados H2 DataBase

### Endereco da url do banco de dados
http://localhost:8080/h2

### Exemplo da consulta no banco de dados

<a href="https://ibb.co/hJD5tdCP"><img src="https://i.ibb.co/ycWTbkVw/H2-Data-Base-01.png" alt="H2-Data-Base-01" border="0"></a>
<br><br>
<a href="https://ibb.co/4ZbfL2tL"><img src="https://i.ibb.co/VWFNGx9G/H2-Data-Base-02.png" alt="H2-Data-Base-02" border="0"></a>  
<br><br>
<a href="https://ibb.co/5hxXSRNN"><img src="https://i.ibb.co/hF1x4mPP/H2-Data-Base-03.png" alt="H2-Data-Base-03" border="0"></a>
<br><br>  
<a href="https://ibb.co/F4ttx7WX"><img src="https://i.ibb.co/chddgTvw/H2-Data-Base-04.png" alt="H2-Data-Base-04" border="0"></a>  
<br><br>
 


## Swagger (OpenAPI) da API OMDB

### Endereco da url do Swagger (OpenAPI) da API OMDB
http://localhost:8080/swagger-ui/index.html

### Exemplo do Swagger (OpenAPI) da API OMDB
<p align = center>
<a href="https://ibb.co/MyWfkPrb"><img src="https://i.ibb.co/5Xtkhsmd/Swagger.png" alt="Swagger" border="0"></a>
</p>
