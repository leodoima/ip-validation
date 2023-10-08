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

**Evento**

Receber uma sequência de eventos de IP em um tópico utilizando Kafka.
<br>
<br>


**Validar localização em cache**

Verificar se a localização do endereço IP já encontra-se em cache.
<br>
<br>

**Buscar localização**

Não havendo cache para tal, devemos buscar a localização de tal IP utilizando a API da IPStack.
<br>
<br>

**Registrar localização**

Havendo obtido a localização de tal IP, devemos interpretar o retorno da API e disponibilizar as informações em um novo tópico Kafka.
<br>
<br>
<br>


### Tecnologias 🔧

As seguintes ferramentas foram utilizadas para construção desta aplicação:

- Java
- Spring Cache
- Open Feign
- API IP Stack ([ipstack.com](https://ipstack.com/))
- Kafka
<br>
<br>

### Pré-requisitos 📋

Esta aplicação fora desenvolvida utilizando a linguagem Java em sua versão 17, sendo esta necessária para a sequência dos passos.
<br>
<br>

### Rodando a aplicação 🏈

```bash
# Clonar o repositório
$ git clone https://github.com/leodoima/ip-validation.git

# Ir para a pasta raiz do projeto
$ cd ip-validation

# Realizar dependências e criar executável
$ ./gradlew clean build

# Acessar a pasta que contém o executável da aplicação
$ cd /build/libs

# Executar a aplicação através do arquivo .jar
$ java -jar ip-validation.jar

# Aplicação estará executando no endereço
$ http://localhost:8080/

# Acessar documentação
$ http://localhost:8080/swagger-ui/index.html
```
<br>
<br>
