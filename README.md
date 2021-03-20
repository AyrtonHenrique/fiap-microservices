# fiap-microservices

Para iniciar os serviços com base nas images disponibilizadas no dockerhub, execute :

~~~~
..\fiap-microservices> docker compose up
~~~~

## Swagger serviços
* Operadora  -> http://localhost:8085/easyinsurance/swagger-ui/
* Clientes   -> http://localhost:8083/easyinsurance/swagger-ui/
* Planos     -> http://localhost:8084/easyinsurance/swagger-ui/
* Corretores -> http://localhost:8082/easyinsurance/swagger-ui/
* Conversas  -> http://localhost:8080/swagger-ui/

## Banco de dados 
### Usuário padrão banco de dados h2 
~~~~
username: sa
password: ""
~~~~

#### Links
* Operadora  -> http://localhost:8085/easyinsurance/h2/
* Clientes   -> http://localhost:8083/easyinsurance/h2/
* Planos     -> http://localhost:8084/easyinsurance/h2/
* Corretores -> http://localhost:8082/easyinsurance/h2/

#### Mongodb (serviço de conversa)
usuario para acessa mongo-express
~~~~
ME_CONFIG_BASICAUTH_USERNAME: ayrton
ME_CONFIG_BASICAUTH_PASSWORD: MongoExpress2019!
~~~~
* mongo-express  -> http://localhost:8081/