# projetoREST
Unipe (11/11/2016) - José Rafael de Farias Brito - José Carlos Accyole

Projeto Final

1. Implementar dois micro services com entidades que se relacionam. Ambas devem ser persistidas com JPA ou MongoDB. Implementar o CRUD completo das duas.

2. Publicar os dois micro serviços no Eureka e configurar as respectivas rotas no Zuul.

3. Utilizar o Feign para realizar a comunicação entre os micro serviços.

4. Criar uma rota no Zuul que retorne dados mesclados dos dois micro serviços.

5. Publicar o projeto no Github e enviar para rvilar@gmail.com.

----

POST: 
https://localhost:8082/lojas
  {
    "id":1,
    "name":"Dubai"
  }

POST: 
http://localhost:8081/carro
  {
    "id":1,
    "marca":"Volkswagen",
    "modelo":"Gol",
     "lojas": [
          "1"
      ] 
  }

Web: 
http://localhost:8080/#/lojas

Rota no Zuul mesclada: 
http://localhost:8080/#/lojasComCarros
