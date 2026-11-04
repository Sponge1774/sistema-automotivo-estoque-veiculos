package br.com.estoque.repository;

import br.com.estoque.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface: o Spring cria a implementacao em tempo de execucao (polimorfismo).
 * JpaRepository ja traz salvar, buscar, listar e excluir.
 */
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCaseAndIdNot(String nome, Long id);
}
