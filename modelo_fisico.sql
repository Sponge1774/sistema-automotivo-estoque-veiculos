-- =====================================================================
-- Sistema Automotivo - Gestao de Estoque de Veiculos
-- Modelo fisico do banco de dados (MySQL 8.0.16 ou superior)
--
-- Equivale ao esquema que a aplicacao cria automaticamente
-- (spring.jpa.hibernate.ddl-auto=update), com as restricoes explicitas.
-- ATENCAO: o script apaga as tabelas existentes e seus dados.
-- Uso: sudo mysql < database/modelo_fisico.sql
-- =====================================================================

CREATE DATABASE IF NOT EXISTS estoque_veiculos CHARACTER SET utf8mb4;
USE estoque_veiculos;

DROP TABLE IF EXISTS veiculo;
DROP TABLE IF EXISTS modelo;
DROP TABLE IF EXISTS marca;

-- Marca: fabricante do veiculo (1 marca possui N modelos)
CREATE TABLE marca (
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_marca_nome UNIQUE (nome)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- Modelo: modelo comercial (1 modelo pertence a 1 marca e possui N veiculos)
CREATE TABLE modelo (
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(60) NOT NULL,
    marca_id BIGINT      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_modelo_marca FOREIGN KEY (marca_id) REFERENCES marca (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- Veiculo: unidade em estoque (entidade central)
CREATE TABLE veiculo (
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    modelo_id      BIGINT      NOT NULL,
    tipo           ENUM('CARRO', 'MOTO', 'CAMINHAO')              NOT NULL,
    ano_fabricacao INT         NOT NULL,
    cor            VARCHAR(30) NOT NULL,
    preco          DOUBLE      NOT NULL,
    quilometragem  INT         NOT NULL,
    status         ENUM('DISPONIVEL', 'RESERVADO', 'VENDIDO')     NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelo (id),
    CONSTRAINT ck_veiculo_ano   CHECK (ano_fabricacao >= 1900),
    CONSTRAINT ck_veiculo_preco CHECK (preco > 0),
    CONSTRAINT ck_veiculo_km    CHECK (quilometragem >= 0)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- Indices de apoio aos filtros de consulta
CREATE INDEX idx_veiculo_status ON veiculo (status);
CREATE INDEX idx_veiculo_ano    ON veiculo (ano_fabricacao);
CREATE INDEX idx_veiculo_preco  ON veiculo (preco);
