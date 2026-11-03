# Sistema Automotivo – Gestão de Estoque de Veículos

Sistema CRUD orientado a objetos para gerenciar o estoque de veículos de uma concessionária: cadastro, consulta com filtros, atualização e remoção de veículos, marcas e modelos, com API REST e interface web.

Trabalho da disciplina **Object Oriented Programming** (Análise e Desenvolvimento de Sistemas – UniFECAF).

**Autor:** Eduardo Souza Mattos

---

## Entregas do trabalho

| Entrega | Onde acessar | Conteúdo |
|---|---|---|
| **Trabalho teórico** | [`docs/teorico/`](docs/teorico) | Relatório teórico em PDF (conceitos de POO, arquitetura e decisões de projeto) |
| **Trabalho prático** | [`docs/pratico/`](docs/pratico) | Relatório prático em PDF (execução do sistema, código principal e evidências) |
| **Evidências (prints)** | [`docs/pratico/prints/`](docs/pratico/prints) | Capturas de tela numeradas: VS Code, execução, página web e banco de dados |
| **Código-fonte** | [`src/`](src) | Aplicação Java com Spring Boot (descrita abaixo) |
| **Vídeo pitch (até 4 min)** | YouTube (não listado) | Link: *a ser inserido após a publicação do vídeo* |

## Estrutura do repositório

```
sistema-automotivo-estoque-veiculos/
├── docs/
│   ├── teorico/
│   │   └── Relatorio_Teorico_Sistema_Automotivo.pdf
│   └── pratico/
│       ├── Relatorio_Pratico_Sistema_Automotivo.pdf
│       └── prints/                      (capturas de tela 01 a 24)
├── src/main/java/br/com/estoque/
│   ├── controller/                      (API REST)
│   ├── exception/                       (tratamento de erros)
│   ├── model/                           (entidades e enumerações)
│   ├── repository/                      (acesso ao banco)
│   ├── service/                         (regras de negócio)
│   └── EstoqueApplication.java
├── src/main/resources/
│   ├── application.properties           (conexão com o MySQL)
│   └── static/index.html                (interface web)
├── pom.xml
├── LICENSE
└── README.md
```

## Tecnologias

- Java 17
- Spring Boot 3 (Spring Web – API REST)
- Spring Data JPA / Hibernate
- Bean Validation
- MySQL 8
- Maven
- HTML, CSS e JavaScript (interface web, servida pelo próprio sistema)

## Arquitetura (MVC / camadas)

| Pacote | Função |
|---|---|
| `model` | Entidades `Marca`, `Modelo` e `Veiculo` (herdam de `EntidadeBase`) e enumerações `TipoVeiculo` e `StatusVeiculo` |
| `repository` | Acesso ao banco de dados (Spring Data JPA), incluindo a consulta com filtros opcionais |
| `service` | Regras de negócio |
| `controller` | Endpoints da API REST |
| `exception` | Tratamento de erros, com resposta em JSON |

## Conceitos de Programação Orientada a Objetos aplicados

| Conceito | Onde aparece |
|---|---|
| **Encapsulamento** | Atributos `private` em `Veiculo`, com getters e setters que validam as regras (preço maior que zero, quilometragem não negativa, ano entre 1900 e o ano seguinte) |
| **Herança** | `Marca`, `Modelo` e `Veiculo` herdam de `EntidadeBase` (identificador comum) |
| **Composição** | `Veiculo` possui um `Modelo`, e `Modelo` possui uma `Marca` |
| **Sobrecarga de construtores** | `Veiculo` com construtor sem argumentos (exigido pelo JPA) e construtor com os dados principais |
| **Enumerações** | `TipoVeiculo` (CARRO, MOTO, CAMINHAO) e `StatusVeiculo` (DISPONIVEL, RESERVADO, VENDIDO) |
| **Abstração e polimorfismo** | Repositórios como interfaces que estendem `JpaRepository`, com implementação gerada pelo Spring |
| **Tratamento de exceções** | Exceções próprias (`RecursoNaoEncontradoException`, `RegraDeNegocioException`) e `TratadorDeErros` |

## Como executar

**Requisitos:** Java 17, Maven 3.8 ou superior e MySQL 8.

1. Crie o banco e o usuário no MySQL (a senha abaixo é apenas de teste, para uso local):

```sql
CREATE DATABASE estoque_veiculos CHARACTER SET utf8mb4;
CREATE USER 'estoque'@'localhost' IDENTIFIED BY 'Estoque@2026';
GRANT ALL PRIVILEGES ON estoque_veiculos.* TO 'estoque'@'localhost';
FLUSH PRIVILEGES;
```

2. Confira usuário e senha em `src/main/resources/application.properties`.
3. Inicie o sistema:

```bash
mvn spring-boot:run
```

4. Acesse `http://localhost:8080` no navegador. As tabelas são criadas automaticamente na primeira execução.

> Se o Maven indicar `release version 17 not supported`, o Java padrão da máquina não é o 17. Ajuste-o antes de executar.

## Interface web

Com o sistema ligado, a página `http://localhost:8080` permite:

- cadastrar, editar e remover veículos, marcas e modelos;
- consultar veículos com filtros por marca, modelo, faixa de preço, ano, situação e tipo;
- carregar dados de exemplo (botão **Carregar dados de exemplo**), para demonstração.

## API REST

| Operação | Método | Caminho |
|---|---|---|
| Listar / filtrar veículos | GET | `/api/veiculos` |
| Buscar veículo | GET | `/api/veiculos/{id}` |
| Cadastrar veículo | POST | `/api/veiculos` |
| Atualizar veículo | PUT | `/api/veiculos/{id}` |
| Remover veículo | DELETE | `/api/veiculos/{id}` |
| Marcas | GET, POST, PUT, DELETE | `/api/marcas` |
| Modelos | GET, POST, PUT, DELETE | `/api/modelos` |

Filtros de `GET /api/veiculos` (todos opcionais): `marca`, `modelo`, `precoMin`, `precoMax`, `ano`, `status` (`DISPONIVEL`, `RESERVADO`, `VENDIDO`) e `tipo` (`CARRO`, `MOTO`, `CAMINHAO`).

Exemplo de consulta com filtros:

```bash
curl "http://localhost:8080/api/veiculos?marca=Honda&status=VENDIDO"
```

Exemplo de cadastro:

```bash
curl -X POST http://localhost:8080/api/veiculos \
  -H "Content-Type: application/json" \
  -d '{"modelo":{"id":1},"tipo":"CARRO","anoFabricacao":2022,"cor":"Prata","preco":120000.00,"quilometragem":15000,"status":"DISPONIVEL"}'
```

Dados inválidos (por exemplo, preço negativo) são recusados com resposta `400` e mensagem em JSON.

## Licença

Distribuído sob a licença MIT. Consulte o arquivo [`LICENSE`](LICENSE).
