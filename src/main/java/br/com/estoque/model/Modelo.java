package br.com.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/** Modelo comercial (por exemplo, Corolla). Pertence a uma marca e possui varios veiculos. */
@Entity
@Table(name = "modelo")
public class Modelo extends EntidadeBase {

    @NotBlank(message = "O nome do modelo e obrigatorio")
    @Column(nullable = false, length = 60)
    private String nome;

    // Composicao ("tem um"): cada modelo tem uma marca
    @NotNull(message = "A marca e obrigatoria")
    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    public Modelo() {
    }

    public Modelo(String nome, Marca marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Modelo{id=" + getId() + ", nome='" + nome + "', marca=" + marca + "}";
    }
}
