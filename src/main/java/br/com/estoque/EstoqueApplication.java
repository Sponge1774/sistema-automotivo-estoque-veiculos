package br.com.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ponto de entrada da aplicacao. O Spring Boot inicia o servidor embutido
 * e descobre automaticamente as classes dos pacotes abaixo de br.com.estoque.
 */
@SpringBootApplication
public class EstoqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
    }
}
