[Português](README.md) | **English**

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
├── README.md                            (Portuguese version)
└── README.en.md                         (this file, in English)
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
