# Projeto API Digimon
## Bem vindo a documentação do sistema!

Olá! Esse projeto tem como finalidade consumir uma API externa e guardar, em um banco de dados, os resultados obtidos. Nesse caso, utilizo a API de personagens Digimon. 
O Sistema, embora simples, foi fundamental no meu processo de aprendizagem, uma vez que aqui aplico conceitos importantes e, pela primeira vez, consumo uma API externa.
O projeto inclui operações de inserção e busca no banco de dados relacional H2 - em cache.

## Como rodar e usar?

### 1. Clonar o Repositório
Primeiro, você precisa clonar o repositório para a sua máquina local. Use o comando git para isso:

```bash
git clone https://github.com/Erick-Bonifacio/Consumer-API-Digimon.git
````
### 2. SpringBoot 4

 É recomendado usar SpringBoot 4 para executar o projeto!
 Inicie a JDK no diretório clonado e "build" o código (lembre-se de usar a versão 17 LTS do Java). 

 ### 3. Server On e DataBase

Quando online, o servidor será iniciado na porta localhost:8080, segundo configurações, por isso, uma vez que o servidor esteja no ar, basta acessar no navegador:

```` Navegador
http://localhost:8080/h2-console
````
Para acessar o banco.
As configurações de como acessar estão definidas no arquivo ``application-test.properties``, basta preencher corretamente os dados e você terá acesso ao banco.

### 5. Rotas e como acessá-las

É recomendado utilizar o Postman para envio de requisições ao servidor, por isso, já no app, sinta-se a vontade para explorar os digimons, através das rotas.
Segue exemplos:

```` Rota que retorna todos os Digimons
http://localhost:8080/digimons
````

```` Rota que retorna um Digimon, buscando pelo nome
http://localhost:8080/digimons/name=NOME DO DIGIMON
````

```` Rota que retorna Digimons, buscando pelo level
http://localhost:8080/digimons/name=LEVEL DO DIGIMON
````

### 6. Tratamento de erros

Para qualquer nome ou nível inexistente no banco de dados, a aplicação retorna o erro ``404 - Not Found`` e o nome/nível que você tentou procurar.

## Sobre a estrutura de pastas e camadas

Para a execução dos meus projetos, tomo por base a seguinte estrutura de camadas:

![Modelo Conceitual](https://github.com/Erick-Bonifacio/Assets/blob/main/Captura%20de%20tela%202024-05-28%20182004.png)

Dessa maneira, organizo as pastas de forma que toda a lógica de negócio para buscas no banco de dados fique no Service, os endpoints se localizem no Resource e a interface JPA, no Repository.
Ademais, neste projeto, utilizo a pasta Consumers, que contém a lógica de busca na API externa.
