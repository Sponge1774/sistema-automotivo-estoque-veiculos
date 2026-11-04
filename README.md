# Sistema Automotivo – Gestão de Estoque de Veículos

Sistema CRUD orientado a objetos para gerenciar o estoque de veículos de uma concessionária: cadastro, consulta com filtros, atualização e remoção de veículos, marcas e modelos, com API REST e interface web.

Trabalho da disciplina **Object Oriented Programming** (Análise e Desenvolvimento de Sistemas – UniFECAF).

**Autor:** Eduardo Souza Mattos – R.A. 35984

---

## Entregas do trabalho

| Entrega | Onde acessar | Conteúdo |
|---|---|---|
| **Trabalho teórico (PDF)** | [`docs/teorico/Relatorio_Teorico_Sistema_Automotivo.pdf`](docs/teorico/Relatorio_Teorico_Sistema_Automotivo.pdf) | Levantamento de requisitos, requisitos, entidades, modelo físico, conceitos de POO, arquitetura, tecnologias e, nos apêndices, todo o código do trabalho |
| **Trabalho prático (PDF)** | [`docs/pratico/Relatorio_Pratico_Sistema_Automotivo.pdf`](docs/pratico/Relatorio_Pratico_Sistema_Automotivo.pdf) | Execução do sistema com prints, código principal e modelo físico (script SQL) |
| **Evidências (prints)** | [`docs/pratico/prints/`](docs/pratico/prints) | Capturas de tela numeradas: VS Code, execução, página web e banco de dados |
| **Modelo físico (SQL)** | [`database/modelo_fisico.sql`](database/modelo_fisico.sql) | Script MySQL com tabelas, chaves, restrições e índices |
| **Código-fonte** | [`src/`](src) | Aplicação Java com Spring Boot (descrita abaixo) |
| **Vídeo pitch (até 4 min)** | YouTube (não listado) | Link: *a ser inserido após a publicação do vídeo* |

## Relatórios em PDF

Os dois relatórios seguem as normas da ABNT (NBR 14724, 10520, 6023, 6024, 6027 e 6028) e trazem capa, folha de rosto, resumo, abstract, listas, sumário, referências e apêndices.

### Relatório teórico — [`docs/teorico/`](docs/teorico)

| Parte | Conteúdo |
|---|---|
| Seções 1 a 3 | Introdução e contextualização do problema; levantamento de requisitos (12 perguntas com respostas simuladas); requisitos funcionais e não funcionais; regras de negócio |
| Seção 4 | Entidades (`Marca`, `Modelo`, `Veiculo`, `TipoVeiculo`, `StatusVeiculo`), diagrama de classes e **modelo físico** (Quadro 6) |
| Seção 5 | Conceitos de POO aplicados: classes, encapsulamento, construtores, herança, composição, polimorfismo, abstração, enumerações e exceções |
| Seções 6 e 7 | Arquitetura em camadas, API REST e justificativa das tecnologias |
| Apêndices A a I | **Todo o código do trabalho:** A `pom.xml`; B configuração e comandos; C classe principal e enumerações; D modelo (entidades); E repositórios; F serviços; G controladores e exceções; H `index.html`; I **modelo físico (script SQL)** |

### Relatório prático — [`docs/pratico/`](docs/pratico/)

| Parte | Conteúdo |
|---|---|
| Seções 2 e 3 | Ambiente, estrutura do projeto e código-fonte principal (`Veiculo`, `VeiculoController`, `VeiculoRepository`, configuração e página web) |
| Seção 4 | Execução: MySQL, criação do banco e inicialização da aplicação |
| Seção 5 | Demonstração pela página web: carga de dados, filtros, cadastro, atualização, remoção, validação, marcas e modelos |
| Seção 6 | Verificação no banco de dados (estrutura da tabela, registros e prova de gravação) |
| Seção 7 | Repositório no GitHub |
| Apêndices A e B | A código-fonte principal; B **modelo físico (script SQL)** |

## Estrutura do repositório

```
sistema-automotivo-estoque-veiculos/
├── docs/
│   ├── teorico/
│   │   └── Relatorio_Teorico_Sistema_Automotivo.pdf
│   └── pratico/
│       ├── Relatorio_Pratico_Sistema_Automotivo.pdf
│       └── prints/                      (capturas de tela 01 a 24)
├── database/
│   └── modelo_fisico.sql                (modelo físico: script de criação das tabelas)
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

## Modelo físico do banco de dados

O script [`database/modelo_fisico.sql`](database/modelo_fisico.sql) cria o banco `estoque_veiculos` e as tabelas `marca`, `modelo` e `veiculo`, com chaves primárias e estrangeiras, restrições de validação (`CHECK`: ano a partir de 1900, preço maior que zero e quilometragem não negativa) e índices de apoio aos filtros. Requer MySQL 8.0.16 ou superior.

| Tabela | Colunas | Chaves e restrições |
|---|---|---|
| `marca` | `id`, `nome` | PK `id`; `nome` único |
| `modelo` | `id`, `nome`, `marca_id` | PK `id`; FK `marca_id` → `marca(id)` |
| `veiculo` | `id`, `modelo_id`, `tipo`, `ano_fabricacao`, `cor`, `preco`, `quilometragem`, `status` | PK `id`; FK `modelo_id` → `modelo(id)`; `CHECK` de ano, preço e quilometragem |

O uso do script é opcional: ao iniciar, a aplicação cria o mesmo esquema automaticamente (`ddl-auto=update`). Para executá-lo manualmente (atenção: apaga as tabelas existentes e seus dados):

```bash
sudo mysql < database/modelo_fisico.sql
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
