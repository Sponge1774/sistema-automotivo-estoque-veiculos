package br.com.estoque.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Classe base (heranca): reune o que todas as entidades tem em comum, o identificador.
 * Marca, Modelo e Veiculo herdam dela com "extends".
 * O id e gerado pelo banco; por isso nao ha metodo setId (encapsulamento).
 */
@MappedSuperclass
public abstract class EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
}
