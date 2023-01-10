# Gerenciador de Pessoas Backend


# Perguntas do desafio

Qualidade de código


    1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?
       Como júnior vou avaliar  os requisitos passados e vou procurar seguir os padrões da comunidade de desenvolvimento e da empresa, já que este foram testados e aprovados.


    2. Em qual etapa da implementação você considera a qualidade de software?
       Em todas as etapas, hoje é inimaginável pensar em desenvolvimento de  software sem processos que visão a qualidade do mesmo.



# Descrição


A api gerenciador de pessoas como  o próprio nome sugere, e uma api para gerenciar o cadastro de pessoas,
nela podemos cadastrar pessoas e seus respectivos endereços, onde uma pessoa pode ter mais de um endereço.


Como desafio me foi proposto este projeto de backend usando as seguintes tecnologias:


- Java
- Spring Boot
- H2





# Instalação e execução
Para este projeto eu criei um script com uma  quantidade de registros para teste, caso o teste seja realizado
localmente o script pode ser excluído para verificar as respostas da api em caso de registros não encontrados (status code 404).

Para excluir o script vá em:


src/main/resources/


excluar o arquivo data.sql


url do banco :


http://localhost:8080/h2-ui/

Obs: Altere  a JDBC URL  para : jdbc:h2:mem:gerenciador



# Instruçoes para uso da api


Para documentar e  testar os endpoints da api, eu usei o Swagger, link para testar os endpoints:

http://localhost:8080/swagger-ui/index.html#/



- criar uma pessoa


verbo http: Post


url : localhost:8080/api/pessoa

```json

{
  "nome": "Maria",
  "nascimento": "2023-01-10",
  "enderecosDto": [
    {
      "logradouro": "Bairro do teste",
      "cep": "12345678",
      "numero": "",
      "cidade": "Rio de Janeiro"
    }
  ]
}
 
   
```




- Editar uma pessoa


verbo http: Put


url : localhost:8080/api/pessoa


``` json
{
  "id": 1,
  "nome": "Souza",
  "nascimento": "2023-01-10",
  "enderecos": [
    {
      "id": 1,
      "logradouro": "Rua alberto",
      "cep": "24264452",
      "numero": "",
      "cidade": "Rio de Janeiro"
    }
  ]
}


```



- Listar pessoas


verbo http: Get


http://localhost:8080/api/pessoa?page=0&sort=id,asc


A api lista os dados paginados, como default  é retornado em cada pagina 5 registros e a ordem é crescente,
onde page=0 (Zero representa o numero da pagina).


``` json

{
"page": 1,
"size": 5,
"sort": [
"asc"
]
}
```


- Criar Endereco


verbo http: Post


http://localhost:8080/api/endereco/1

Onde 1 representa o id da pessoa que tera o endereço vinculado


Formato do json esperado.

``` json
{

"logradouro": "Rua  Irene",
"cep": "96237719",
"numero": "string",
"cidade": "Bauru"
}

```






- Listar endereços da pessoa


verbo http: get


http://localhost:8080/api/endereco/findEnderecoByPessoa/1




- Endpoint para setar endereço principal


verbo http: Get


http://localhost:8080/api/endereco/5
  