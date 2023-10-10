# Ip-Validation 🟢
<br>
Este desafio é proposto para criar um aplicativo de fluxo Kafka autônomo que traduz IPs em localizações geográficas usando a API gratuita do IPStack.
<br>
<br>
<br>

<p align="center">
  <img alt="Topology" src="./src/main/resources/static/cover.png" />
</p>

<br>
<br>

### Etapas 🎮
<br>

1. **Evento**

   <i>Receber uma sequência de eventos de IP em um tópico utilizando Kafka.</i>
<br>

2. **Validar localização em cache**

   <i>Verificar se a localização do endereço IP já encontra-se em cache.</i>
<br>

3. **Buscar localização**

    <i>Não havendo cache para tal, devemos buscar a localização de tal IP utilizando a API da IPStack.</i>
<br>

4. **Registrar localização**

   <i>Havendo obtido a localização de tal IP, devemos interpretar o retorno da API e disponibilizar as informações em um novo tópico Kafka.</i>
<br>
<br>
<br>

### Tecnologias 🔧

As seguintes ferramentas foram utilizadas para construção desta aplicação:

- Java
- Kafka
- Swagger
- Open Feign
- Spring Cache
- API IP Stack ([ipstack.com](https://ipstack.com/))
<br>
<br>
  <br>
### Pré-requisitos 📋

Esta aplicação fora desenvolvida utilizando a linguagem **Java em sua versão 17**, sendo esta necessária para a sequência dos passos.
<br>
<br>
<br>

### Rodando a aplicação 🏈

```bash
# Clonar o repositório
$ git clone https://github.com/leodoima/ip-validation.git

# Ir para a pasta raiz do projeto
$ cd ip-validation

# Criar dependências, gerar executável e rodar aplicação
$ docker compose up --build

# Caso opte por criar manualmente o executável
$ docker compose up --build zookeeper kafka 
$ ./gradlew clean build
$ cd /build/libs
$ java -jar ip-validation.jar

# Aplicação estará executando no endereço
$ http://localhost:8080/

# Acessar documentação
$ http://localhost:8080/swagger-ui/index.html
```
<br>
<br>
