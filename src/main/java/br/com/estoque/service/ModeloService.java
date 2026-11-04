package br.com.estoque.service;

import br.com.estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.exception.RegraDeNegocioException;
import br.com.estoque.model.Marca;
import br.com.estoque.model.Modelo;
import br.com.estoque.repository.ModeloRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/** Regras de negocio dos modelos: todo modelo precisa estar ligado a uma marca existente. */
@Service
public class ModeloService {

    private final ModeloRepository repository;
    private final MarcaService marcaService;

    public ModeloService(ModeloRepository repository, MarcaService marcaService) {
        this.repository = repository;
        this.marcaService = marcaService;
    }

    public List<Modelo> listar() {
        return repository.findAll(Sort.by("nome"));
    }

    public Modelo buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Modelo nao encontrado: id " + id));
    }

    public Modelo criar(Modelo dados) {
        return repository.save(new Modelo(dados.getNome(), buscarMarca(dados)));
    }

    public Modelo atualizar(Long id, Modelo dados) {
        Modelo modelo = buscar(id);
        modelo.setNome(dados.getNome());
        modelo.setMarca(buscarMarca(dados));
        return repository.save(modelo);
    }

    public void remover(Long id) {
        repository.delete(buscar(id));
    }

    /** Converte a marca recebida no JSON ({"id":1}) na marca completa do banco. */
    private Marca buscarMarca(Modelo dados) {
        Long idMarca = dados.getMarca().getId();
        if (idMarca == null) {
            throw new RegraDeNegocioException("Informe o id da marca. Exemplo: \"marca\":{\"id\":1}");
        }
        return marcaService.buscar(idMarca);
    }
}
