package br.com.estoque.service;

import br.com.estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.exception.RegraDeNegocioException;
import br.com.estoque.model.Marca;
import br.com.estoque.repository.MarcaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/** Regras de negocio das marcas. */
@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public List<Marca> listar() {
        return repository.findAll(Sort.by("nome"));
    }

    public Marca buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Marca nao encontrada: id " + id));
    }

    public Marca criar(Marca dados) {
        if (repository.existsByNomeIgnoreCase(dados.getNome())) {
            throw new RegraDeNegocioException("Ja existe uma marca com o nome " + dados.getNome());
        }
        return repository.save(new Marca(dados.getNome()));
    }

    public Marca atualizar(Long id, Marca dados) {
        Marca marca = buscar(id);
        if (repository.existsByNomeIgnoreCaseAndIdNot(dados.getNome(), id)) {
            throw new RegraDeNegocioException("Ja existe uma marca com o nome " + dados.getNome());
        }
        marca.setNome(dados.getNome());
        return repository.save(marca);
    }

    public void remover(Long id) {
        repository.delete(buscar(id));
    }
}
