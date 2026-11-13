# Aula 12 - Computação em Nuvem - Deploy na Railway

API REST de Produtos em Spring Boot (Java 21), publicada na Railway.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | `/` | Mensagem da aula |
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca um produto |
| POST | `/produtos` | Cadastra um produto |
| PUT | `/produtos/{id}` | Atualiza nome e preço |
| DELETE | `/produtos/{id}` | Remove um produto |

Os dados ficam em memória: quando a aplicação reinicia, voltam os 3 produtos iniciais.

## Porta

`application.properties` usa `server.port=${PORT:8080}`: na Railway a porta vem da variável `PORT`; localmente usa 8080.

## Rodar localmente

```
./mvnw spring-boot:run
```
