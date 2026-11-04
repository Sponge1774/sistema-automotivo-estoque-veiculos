package br.com.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/** Fabricante do veiculo (por exemplo, Toyota). Uma marca possui varios modelos. */
@Entity
@Table(name = "marca")
public class Marca extends EntidadeBase {

    @NotBlank(message = "O nome da marca e obrigatorio")
    @Column(nullable = false, unique = true, length = 60)
    private String nome;

    /** Construtor sem argumentos: exigido pelo JPA e pelo Jackson (leitura do JSON). */
    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Marca{id=" + getId() + ", nome='" + nome + "'}";
    }
}
