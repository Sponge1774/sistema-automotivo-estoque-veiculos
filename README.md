# Sistema Automotivo – Gestão de Estoque de Veículos

Sistema CRUD orientado a objetos para gerenciar o estoque de veículos de uma concessionária: cadastro, consulta com filtros, atualização e remoção de veículos, marcas e modelos, com API REST e interface web.

Trabalho da disciplina **Object Oriented Programming** (Análise e Desenvolvimento de Sistemas – UniFECAF).

**Autor:** Eduardo Souza Mattos – R.A. 35984

---

## Entregas do trabalho

| Entrega | Onde acessar | Conteúdo |
|---|---|---|
| **Trabalho teórico (PDF)** | [`Relatorio_Teorico_Sistema_Automotivo.pdf`](Relatorio_Teorico_Sistema_Automotivo.pdf) | Levantamento de requisitos, requisitos, entidades, modelo físico, conceitos de POO, arquitetura, tecnologias e, nos apêndices, todo o código do trabalho |
| **Trabalho prático (PDF)** | [`Relatorio_Pratico_Sistema_Automotivo.pdf`](Relatorio_Pratico_Sistema_Automotivo.pdf) | Execução do sistema com prints, código principal e modelo físico (script SQL) |
| **Evidências (prints)** | [`Fotos e Prints`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints) | Capturas de tela numeradas: VS Code, execução, página web e banco de dados |
| **Modelo físico (SQL)** | [`modelo_fisico.sql`](modelo_fisico.sql) | Script MySQL com tabelas, chaves, restrições e índices |
| **Código-fonte** | [`src/`](src) | Aplicação Java com Spring Boot (descrita abaixo) |
| **Configuração do projeto (Maven)** | [`pom.xml`](pom.xml) | Dependências (Spring Web, Spring Data JPA, Validation, driver do MySQL) e versão do Java (17) |
| **Vídeo pitch (até 4 min)** | [YouTube (não listado)](https://youtu.be/6x1J-7Rtt4I) | Link: <https://youtu.be/6x1J-7Rtt4I> |

## Relatórios em PDF

Os dois relatórios seguem as normas da ABNT (NBR 14724, 10520, 6023, 6024, 6027 e 6028) e trazem capa, folha de rosto, resumo, abstract, listas, sumário, referências e apêndices.

### Relatório teórico — [`Relatorio_Teorico_Sistema_Automotivo.pdf`](Relatorio_Teorico_Sistema_Automotivo.pdf)

| Parte | Conteúdo |
|---|---|
| Seções 1 a 3 | Introdução e contextualização do problema; levantamento de requisitos (12 perguntas com respostas simuladas); requisitos funcionais e não funcionais; regras de negócio |
| Seção 4 | Entidades (`Marca`, `Modelo`, `Veiculo`, `TipoVeiculo`, `StatusVeiculo`), diagrama de classes e **modelo físico** (Quadro 6) |
| Seção 5 | Conceitos de POO aplicados: classes, encapsulamento, construtores, herança, composição, polimorfismo, abstração, enumerações, exceções, estruturas de dados e algoritmos |
| Seções 6 e 7 | Arquitetura em camadas, API REST e justificativa das tecnologias |
| Apêndices A a I | **Todo o código do trabalho:** A `pom.xml`; B configuração e comandos; C classe principal e enumerações; D modelo (entidades); E repositórios; F serviços; G controladores e exceções; H `index.html`; I **modelo físico (script SQL)** |

### Relatório prático — [`Relatorio_Pratico_Sistema_Automotivo.pdf`](Relatorio_Pratico_Sistema_Automotivo.pdf)

| Parte | Conteúdo |
|---|---|
| Seções 2 e 3 | Ambiente, estrutura do projeto e código-fonte principal (`Veiculo`, `VeiculoController`, `VeiculoRepository`, configuração e página web) |
| Seção 4 | Execução: MySQL, criação do banco e inicialização da aplicação |
| Seção 5 | Demonstração pela página web: carga de dados, filtros, cadastro, atualização, remoção, validação, marcas e modelos |
| Seção 6 | Verificação no banco de dados (estrutura da tabela, registros e prova de gravação) |
| Seção 7 | Repositório no GitHub |
| Apêndices A e B | A código-fonte principal; B **modelo físico (script SQL)** |

## Evidências: pasta de prints

Capturas de tela da execução real do sistema, organizadas em três partes, na pasta [`Fotos e Prints`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints):

- [**Parte A**](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A): ambiente, estrutura do projeto e código-fonte no VS Code (prints 1 a 7B);
- [**Parte B**](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B): MySQL, criação do banco e inicialização da aplicação (prints 8 a 11);
- [**Parte C**](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C): uso da página web e verificação no banco de dados (prints 12 a 24).

Cada figura do relatório prático foi gerada a partir de um destes prints.

| Parte | Arquivo | O que mostra |
|---|---|---|
| Parte A | [`print1.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print1.png) | Terminal do VS Code com as versões do Java 17 e do Maven |
| Parte A | [`print2.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print2.png) | Explorador do VS Code com a estrutura do projeto |
| Parte A | [`print3A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print3A.png) | Veiculo.java (início): herança, atributos privados e anotações |
| Parte A | [`print3B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print3B.png) | Veiculo.java (meio): construtores e validação do ano |
| Parte A | [`print4A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print4A.png) | VeiculoController.java (início): listagem com filtros e cadastro |
| Parte A | [`print4B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print4B.png) | VeiculoController.java (final): busca, atualização e remoção |
| Parte A | [`print5.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print5.png) | VeiculoRepository.java: consulta JPQL com filtros opcionais |
| Parte A | [`print6.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print6.png) | application.properties: conexão com o MySQL |
| Parte A | [`print7A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print7A.png) | index.html: estrutura da página |
| Parte A | [`print7B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print7B.png) | index.html: JavaScript que consome a API |
| Parte B | [`print8.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print8.png) | Serviço do MySQL ativo |
| Parte B | [`print9.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print9.png) | Criação do banco estoque_veiculos |
| Parte B | [`print10.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print10.png) | Inicialização do Spring Boot (Tomcat na porta 8080) |
| Parte B | [`print11.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print11.png) | Tabelas marca, modelo e veiculo criadas automaticamente |
| Parte C | [`print12.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print12.png) | Página inicial com 6 veículos (dados de exemplo) |
| Parte C | [`print13.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print13.png) | Filtro por marca (Honda) |
| Parte C | [`print14.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print14.png) | Filtro por faixa de preço |
| Parte C | [`print15A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print15A.png) | Filtro por ano (2022) |
| Parte C | [`print15B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print15B.png) | Filtro por situação (VENDIDO) |
| Parte C | [`print16.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print16.png) | Cadastro de veículo (Create) |
| Parte C | [`print17.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print17.png) | Atualização de veículo (Update) |
| Parte C | [`print18.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print18.png) | Remoção de veículo (Delete) |
| Parte C | [`print19.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print19.png) | Validação: preço negativo recusado |
| Parte C | [`print20A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print20A.png) | Aba Marcas |
| Parte C | [`print20B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print20B.png) | Aba Modelos |
| Parte C | [`print21.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print21.png) | DESCRIBE veiculo no MySQL |
| Parte C | [`print22.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print22.png) | Consulta com JOIN: os 6 veículos gravados |
| Parte C | [`print23A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print23A.png) | Página após editar o preço do Corolla |
| Parte C | [`print23B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print23B.png) | Consulta no banco confirmando o novo preço |
| Parte C | [`print24.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print24.png) | Página pública do repositório no GitHub |

## Estrutura do repositório

```
sistema-automotivo-estoque-veiculos/
├── Fotos e Prints-20261104T012307Z-1-001/
│   └── Fotos e Prints/
│       ├── Parte A/                     (prints 1 a 7B: ambiente e código no VS Code)
│       ├── Parte B/                     (prints 8 a 11: MySQL e inicialização)
│       └── Parte C/                     (prints 12 a 24: página web, banco de dados e repositório)
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
├── Relatorio_Teorico_Sistema_Automotivo.pdf
├── Relatorio_Pratico_Sistema_Automotivo.pdf
├── modelo_fisico.sql                    (modelo físico: script de criação das tabelas)
├── pom.xml
├── LICENSE
└── README.md                            (português e inglês)
```

## Modelo físico do banco de dados

O script [`modelo_fisico.sql`](modelo_fisico.sql) cria o banco `estoque_veiculos` e as tabelas `marca`, `modelo` e `veiculo`, com chaves primárias e estrangeiras, restrições de validação (`CHECK`: ano a partir de 1900, preço maior que zero e quilometragem não negativa) e índices de apoio aos filtros. Requer MySQL 8.0.16 ou superior.

| Tabela | Colunas | Chaves e restrições |
|---|---|---|
| `marca` | `id`, `nome` | PK `id`; `nome` único |
| `modelo` | `id`, `nome`, `marca_id` | PK `id`; FK `marca_id` → `marca(id)` |
| `veiculo` | `id`, `modelo_id`, `tipo`, `ano_fabricacao`, `cor`, `preco`, `quilometragem`, `status` | PK `id`; FK `modelo_id` → `modelo(id)`; `CHECK` de ano, preço e quilometragem |

O uso do script é opcional: ao iniciar, a aplicação cria o mesmo esquema automaticamente (`ddl-auto=update`). Para executá-lo manualmente (atenção: apaga as tabelas existentes e seus dados):

```bash
sudo mysql < modelo_fisico.sql
```

## Tecnologias

- Java 17
- Spring Boot 3 (Spring Web – API REST)
- Spring Data JPA / Hibernate
- Bean Validation
- MySQL 8
- Maven
- HTML, CSS e JavaScript (interface web, servida pelo próprio sistema)

## Ambiente de desenvolvimento

O sistema foi desenvolvido e testado em um notebook Samsung Expert (2018), com o sistema operacional Pop!_OS (Linux) e o editor Visual Studio Code (extensões Java e Spring Boot). Versões utilizadas: OpenJDK 17.0.20.1, Apache Maven 3.8.7 e Spring Boot 3.4.5.

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

**Requisitos:** Java 17, Maven 3.8 ou superior e MySQL 8, com o serviço do MySQL ativo (`sudo systemctl status mysql`).

1. Crie o banco e o usuário no MySQL, com usuário administrador (`sudo mysql`). A senha abaixo é apenas de teste, para uso local:

```sql
CREATE DATABASE estoque_veiculos CHARACTER SET utf8mb4;
CREATE USER 'estoque'@'localhost' IDENTIFIED BY 'Estoque@2026';
GRANT ALL PRIVILEGES ON estoque_veiculos.* TO 'estoque'@'localhost';
FLUSH PRIVILEGES;
```

   Para recomeçar com o banco vazio (o usuário `estoque` é mantido):

```bash
sudo mysql -e "DROP DATABASE IF EXISTS estoque_veiculos; CREATE DATABASE estoque_veiculos CHARACTER SET utf8mb4;"
```

> **Atenção:** o comando `DROP DATABASE` remove todos os dados do banco. Use-o apenas em ambiente de desenvolvimento e teste.

2. Confira usuário e senha em `src/main/resources/application.properties`.
3. Entre na **pasta raiz do projeto**, onde se encontra o arquivo [`pom.xml`](pom.xml), e inicie o sistema (o Maven lê as dependências do `pom.xml` e as baixa automaticamente):

```bash
cd sistema-automotivo-estoque-veiculos
ls pom.xml
mvn spring-boot:run
```

4. Acesse `http://localhost:8080` no navegador. As tabelas são criadas automaticamente na primeira execução.
5. Para encerrar, pressione `Ctrl + C` no terminal em que a aplicação foi iniciada.

> Se o Maven indicar `release version 17 not supported`, o Java padrão da máquina não é o 17. Ajuste-o antes de executar.

### Problemas comuns

| Mensagem | Causa | Solução |
|---|---|---|
| `No plugin found for prefix 'spring-boot'` | O comando `mvn spring-boot:run` foi executado fora da pasta do projeto | Entrar na pasta que contém o `pom.xml` (`cd`) e executar novamente |
| `Port 8080 was already in use` | Já existe uma instância da aplicação em execução | Encerrar a instância anterior: `Ctrl + C` no terminal dela ou, se não souber onde está, `lsof -i :8080` e `kill <PID>`. Também é possível usar outra porta: `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081` |
| Falha de conexão com o banco | MySQL parado, ou banco e usuário inexistentes | Verificar `sudo systemctl status mysql` e refazer o passo 1 |

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

---

# Automotive System – Vehicle Inventory Management

Object-oriented CRUD system to manage the vehicle inventory of a car dealership: registration, filtered search, update and removal of vehicles, brands and models, with a REST API and a web interface.

Project for the course **Object Oriented Programming** (Systems Analysis and Development – UniFECAF).

**Author:** Eduardo Souza Mattos – Student ID (R.A.) 35984

> The reports, source code identifiers and the web interface are in Brazilian Portuguese. File and class names (for example `Veiculo`, `Marca`, `Modelo`) are kept as in the repository.

---

## Deliverables

| Deliverable | Where to find it | Content |
|---|---|---|
| **Theoretical report (PDF)** | [`Relatorio_Teorico_Sistema_Automotivo.pdf`](Relatorio_Teorico_Sistema_Automotivo.pdf) | Requirements elicitation, requirements, entities, physical model, OOP concepts, architecture, technologies and, in the appendices, all the code of the project |
| **Practical report (PDF)** | [`Relatorio_Pratico_Sistema_Automotivo.pdf`](Relatorio_Pratico_Sistema_Automotivo.pdf) | System execution with screenshots, main code and physical model (SQL script) |
| **Evidence (screenshots)** | [`Fotos e Prints`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints) | Numbered screenshots: VS Code, execution, web page and database |
| **Physical model (SQL)** | [`modelo_fisico.sql`](modelo_fisico.sql) | MySQL script with tables, keys, constraints and indexes |
| **Source code** | [`src/`](src) | Java application with Spring Boot (described below) |
| **Project configuration (Maven)** | [`pom.xml`](pom.xml) | Dependencies (Spring Web, Spring Data JPA, Validation, MySQL driver) and Java version (17) |
| **Pitch video (up to 4 min)** | [YouTube (unlisted)](https://youtu.be/6x1J-7Rtt4I) | Link: <https://youtu.be/6x1J-7Rtt4I> |

## PDF reports

Both reports follow the Brazilian ABNT standards (NBR 14724, 10520, 6023, 6024, 6027 and 6028) and include cover, title page, abstract (in Portuguese and English), lists, table of contents, references and appendices.

### Theoretical report — [`Relatorio_Teorico_Sistema_Automotivo.pdf`](Relatorio_Teorico_Sistema_Automotivo.pdf)

| Part | Content |
|---|---|
| Sections 1 to 3 | Introduction and problem context; requirements elicitation (12 questions with simulated answers); functional and non-functional requirements; business rules |
| Section 4 | Entities (`Marca`, `Modelo`, `Veiculo`, `TipoVeiculo`, `StatusVeiculo`), class diagram and **physical model** (Table 6) |
| Section 5 | OOP concepts applied: classes, encapsulation, constructors, inheritance, composition, polymorphism, abstraction, enumerations, exceptions, data structures and algorithms |
| Sections 6 and 7 | Layered architecture, REST API and justification of the technologies |
| Appendices A to I | **All the code of the project:** A `pom.xml`; B configuration and commands; C main class and enumerations; D model (entities); E repositories; F services; G controllers and exceptions; H `index.html`; I **physical model (SQL script)** |

### Practical report — [`Relatorio_Pratico_Sistema_Automotivo.pdf`](Relatorio_Pratico_Sistema_Automotivo.pdf)

| Part | Content |
|---|---|
| Sections 2 and 3 | Environment, project structure and main source code (`Veiculo`, `VeiculoController`, `VeiculoRepository`, configuration and web page) |
| Section 4 | Execution: MySQL, database creation and application startup |
| Section 5 | Web page demonstration: sample data, filters, registration, update, removal, validation, brands and models |
| Section 6 | Database verification (table structure, records and proof of persistence) |
| Section 7 | GitHub repository |
| Appendices A and B | A main source code; B **physical model (SQL script)** |

## Evidence: screenshots folder

Screenshots of the real execution of the system, organized in three parts, in the folder [`Fotos e Prints`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints):

- [**Part A**](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A): environment, project structure and source code in VS Code (screenshots 1 to 7B);
- [**Part B**](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B): MySQL, database creation and application startup (screenshots 8 to 11);
- [**Part C**](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C): web page usage and database verification (screenshots 12 to 24).

Each figure of the practical report was generated from one of these screenshots.

| Part | File | What it shows |
|---|---|---|
| Part A | [`print1.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print1.png) | Terminal in VS Code showing the Java 17 and Maven versions |
| Part A | [`print2.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print2.png) | VS Code explorer showing the project structure |
| Part A | [`print3A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print3A.png) | Veiculo.java (top): inheritance, private attributes and annotations |
| Part A | [`print3B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print3B.png) | Veiculo.java (middle): constructors and year validation |
| Part A | [`print4A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print4A.png) | VeiculoController.java (top): filtered listing and creation |
| Part A | [`print4B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print4B.png) | VeiculoController.java (bottom): lookup, update and removal |
| Part A | [`print5.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print5.png) | VeiculoRepository.java: JPQL query with optional filters |
| Part A | [`print6.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print6.png) | application.properties: MySQL connection |
| Part A | [`print7A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print7A.png) | index.html: page structure |
| Part A | [`print7B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20A/print7B.png) | index.html: JavaScript that consumes the API |
| Part B | [`print8.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print8.png) | MySQL service running |
| Part B | [`print9.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print9.png) | Creation of the estoque_veiculos database |
| Part B | [`print10.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print10.png) | Spring Boot startup (Tomcat on port 8080) |
| Part B | [`print11.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20B/print11.png) | Tables marca, modelo and veiculo created automatically |
| Part C | [`print12.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print12.png) | Home page with 6 vehicles (sample data) |
| Part C | [`print13.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print13.png) | Filter by brand (Honda) |
| Part C | [`print14.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print14.png) | Filter by price range |
| Part C | [`print15A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print15A.png) | Filter by year (2022) |
| Part C | [`print15B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print15B.png) | Filter by status (VENDIDO) |
| Part C | [`print16.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print16.png) | Vehicle registration (Create) |
| Part C | [`print17.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print17.png) | Vehicle update (Update) |
| Part C | [`print18.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print18.png) | Vehicle removal (Delete) |
| Part C | [`print19.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print19.png) | Validation: negative price rejected |
| Part C | [`print20A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print20A.png) | Brands tab |
| Part C | [`print20B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print20B.png) | Models tab |
| Part C | [`print21.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print21.png) | DESCRIBE veiculo in MySQL |
| Part C | [`print22.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print22.png) | JOIN query: the 6 stored vehicles |
| Part C | [`print23A.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print23A.png) | Page after editing the Corolla price |
| Part C | [`print23B.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print23B.png) | Database query confirming the new price |
| Part C | [`print24.png`](Fotos%20e%20Prints-20261104T012307Z-1-001/Fotos%20e%20Prints/Parte%20C/print24.png) | Public GitHub repository page |

## Repository structure

```
sistema-automotivo-estoque-veiculos/
├── Fotos e Prints-20261104T012307Z-1-001/
│   └── Fotos e Prints/
│       ├── Parte A/                     (screenshots 1 to 7B: environment and code in VS Code)
│       ├── Parte B/                     (screenshots 8 to 11: MySQL and startup)
│       └── Parte C/                     (screenshots 12 to 24: web page, database and repository)
├── src/main/java/br/com/estoque/
│   ├── controller/                      (REST API)
│   ├── exception/                       (error handling)
│   ├── model/                           (entities and enumerations)
│   ├── repository/                      (database access)
│   ├── service/                         (business rules)
│   └── EstoqueApplication.java
├── src/main/resources/
│   ├── application.properties           (MySQL connection)
│   └── static/index.html                (web interface)
├── Relatorio_Teorico_Sistema_Automotivo.pdf
├── Relatorio_Pratico_Sistema_Automotivo.pdf
├── modelo_fisico.sql                    (physical model: table creation script)
├── pom.xml
├── LICENSE
└── README.md                            (Portuguese and English)
```

## Database physical model

The script [`modelo_fisico.sql`](modelo_fisico.sql) creates the `estoque_veiculos` database and the `marca`, `modelo` and `veiculo` tables, with primary and foreign keys, validation constraints (`CHECK`: year from 1900 on, price greater than zero and non-negative mileage) and indexes that support the search filters. It requires MySQL 8.0.16 or later.

| Table | Columns | Keys and constraints |
|---|---|---|
| `marca` (brand) | `id`, `nome` | PK `id`; unique `nome` |
| `modelo` (model) | `id`, `nome`, `marca_id` | PK `id`; FK `marca_id` → `marca(id)` |
| `veiculo` (vehicle) | `id`, `modelo_id`, `tipo`, `ano_fabricacao`, `cor`, `preco`, `quilometragem`, `status` | PK `id`; FK `modelo_id` → `modelo(id)`; `CHECK` on year, price and mileage |

Using the script is optional: on startup, the application creates the same schema automatically (`ddl-auto=update`). To run it manually (warning: it drops the existing tables and their data):

```bash
sudo mysql < modelo_fisico.sql
```

## Technologies

- Java 17
- Spring Boot 3 (Spring Web – REST API)
- Spring Data JPA / Hibernate
- Bean Validation
- MySQL 8
- Maven
- HTML, CSS and JavaScript (web interface, served by the system itself)

## Development environment

The system was developed and tested on a Samsung Expert laptop (2018), running Pop!_OS (Linux) and Visual Studio Code (Java and Spring Boot extensions). Versions used: OpenJDK 17.0.20.1, Apache Maven 3.8.7 and Spring Boot 3.4.5.

## Architecture (MVC / layers)

| Package | Role |
|---|---|
| `model` | Entities `Marca`, `Modelo` and `Veiculo` (which inherit from `EntidadeBase`) and enumerations `TipoVeiculo` and `StatusVeiculo` |
| `repository` | Database access (Spring Data JPA), including the query with optional filters |
| `service` | Business rules |
| `controller` | REST API endpoints |
| `exception` | Error handling, with JSON responses |

## Object-oriented programming concepts applied

| Concept | Where it appears |
|---|---|
| **Encapsulation** | `private` attributes in `Veiculo`, with getters and setters that validate the rules (price greater than zero, non-negative mileage, year between 1900 and next year) |
| **Inheritance** | `Marca`, `Modelo` and `Veiculo` inherit from `EntidadeBase` (common identifier) |
| **Composition** | `Veiculo` has a `Modelo`, and `Modelo` has a `Marca` |
| **Constructor overloading** | `Veiculo` with a no-argument constructor (required by JPA) and a constructor with the main data |
| **Enumerations** | `TipoVeiculo` (CARRO, MOTO, CAMINHAO) and `StatusVeiculo` (DISPONIVEL, RESERVADO, VENDIDO) |
| **Abstraction and polymorphism** | Repositories as interfaces that extend `JpaRepository`, with the implementation generated by Spring |
| **Exception handling** | Custom exceptions (`RecursoNaoEncontradoException`, `RegraDeNegocioException`) and `TratadorDeErros` |

## How to run

**Requirements:** Java 17, Maven 3.8 or later and MySQL 8, with the MySQL service running (`sudo systemctl status mysql`).

1. Create the database and the user in MySQL, as an administrator (`sudo mysql`). The password below is for testing only, for local use:

```sql
CREATE DATABASE estoque_veiculos CHARACTER SET utf8mb4;
CREATE USER 'estoque'@'localhost' IDENTIFIED BY 'Estoque@2026';
GRANT ALL PRIVILEGES ON estoque_veiculos.* TO 'estoque'@'localhost';
FLUSH PRIVILEGES;
```

   To start over with an empty database (the `estoque` user is kept):

```bash
sudo mysql -e "DROP DATABASE IF EXISTS estoque_veiculos; CREATE DATABASE estoque_veiculos CHARACTER SET utf8mb4;"
```

> **Warning:** the `DROP DATABASE` command removes all data from the database. Use it only in development and test environments.

2. Check the user and password in `src/main/resources/application.properties`.
3. Go to the **project root folder**, where the [`pom.xml`](pom.xml) file is, and start the system (Maven reads the dependencies from `pom.xml` and downloads them automatically):

```bash
cd sistema-automotivo-estoque-veiculos
ls pom.xml
mvn spring-boot:run
```

4. Open `http://localhost:8080` in the browser. The tables are created automatically on the first run.
5. To stop, press `Ctrl + C` in the terminal where the application was started.

> If Maven reports `release version 17 not supported`, the machine's default Java is not 17. Adjust it before running.

### Common problems

| Message | Cause | Solution |
|---|---|---|
| `No plugin found for prefix 'spring-boot'` | The `mvn spring-boot:run` command was run outside the project folder | Go to the folder that contains `pom.xml` (`cd`) and run it again |
| `Port 8080 was already in use` | An instance of the application is already running | Stop the previous instance: `Ctrl + C` in its terminal or, if you do not know where it is, `lsof -i :8080` and `kill <PID>`. You can also use another port: `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081` |
| Database connection failure | MySQL stopped, or database and user do not exist | Check `sudo systemctl status mysql` and redo step 1 |

## Web interface

With the system running, the page `http://localhost:8080` allows you to:

- register, edit and remove vehicles, brands and models;
- search vehicles with filters by brand, model, price range, year, status and type;
- load sample data (**Carregar dados de exemplo** button), for demonstration.

## REST API

| Operation | Method | Path |
|---|---|---|
| List / filter vehicles | GET | `/api/veiculos` |
| Get vehicle | GET | `/api/veiculos/{id}` |
| Create vehicle | POST | `/api/veiculos` |
| Update vehicle | PUT | `/api/veiculos/{id}` |
| Delete vehicle | DELETE | `/api/veiculos/{id}` |
| Brands | GET, POST, PUT, DELETE | `/api/marcas` |
| Models | GET, POST, PUT, DELETE | `/api/modelos` |

Filters of `GET /api/veiculos` (all optional): `marca`, `modelo`, `precoMin`, `precoMax`, `ano`, `status` (`DISPONIVEL`, `RESERVADO`, `VENDIDO`) and `tipo` (`CARRO`, `MOTO`, `CAMINHAO`).

Example of a query with filters:

```bash
curl "http://localhost:8080/api/veiculos?marca=Honda&status=VENDIDO"
```

Example of a registration:

```bash
curl -X POST http://localhost:8080/api/veiculos \
  -H "Content-Type: application/json" \
  -d '{"modelo":{"id":1},"tipo":"CARRO","anoFabricacao":2022,"cor":"Prata","preco":120000.00,"quilometragem":15000,"status":"DISPONIVEL"}'
```

Invalid data (for example, a negative price) is rejected with a `400` response and a JSON message.

## License

Distributed under the MIT license. See the [`LICENSE`](LICENSE) file.
