package br.com.estoque.service;

import br.com.estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.exception.RegraDeNegocioException;
import br.com.estoque.model.Modelo;
import br.com.estoque.model.StatusVeiculo;
import br.com.estoque.model.TipoVeiculo;
import br.com.estoque.model.Veiculo;
import br.com.estoque.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/** Regras de negocio dos veiculos: intermediario entre o controlador e o repositorio. */
@Service
public class VeiculoService {

    private final VeiculoRepository repository;
    private final ModeloService modeloService;

    public VeiculoService(VeiculoRepository repository, ModeloService modeloService) {
        this.repository = repository;
        this.modeloService = modeloService;
    }

    public List<Veiculo> filtrar(String marca, String modelo, Double precoMin, Double precoMax,
                                 Integer ano, StatusVeiculo status, TipoVeiculo tipo) {
        if (precoMin != null && precoMax != null && precoMin > precoMax) {
            throw new RegraDeNegocioException("O preco minimo nao pode ser maior que o preco maximo");
        }
        return repository.filtrar(vazioParaNulo(marca), vazioParaNulo(modelo),
                precoMin, precoMax, ano, status, tipo);
    }

    public Veiculo buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veiculo nao encontrado: id " + id));
    }

    public Veiculo criar(Veiculo dados) {
        Veiculo novo = new Veiculo(buscarModelo(dados), dados.getTipo(), dados.getAnoFabricacao(),
                dados.getCor(), dados.getPreco(), dados.getQuilometragem(), dados.getStatus());
        return repository.save(novo);
    }

    public Veiculo atualizar(Long id, Veiculo dados) {
        Veiculo veiculo = buscar(id);
        veiculo.setModelo(buscarModelo(dados));
        veiculo.setTipo(dados.getTipo());
        veiculo.setAnoFabricacao(dados.getAnoFabricacao());
        veiculo.setCor(dados.getCor());
        veiculo.setPreco(dados.getPreco());
        veiculo.setQuilometragem(dados.getQuilometragem());
        veiculo.setStatus(dados.getStatus());
        return repository.save(veiculo);
    }

    public void remover(Long id) {
        repository.delete(buscar(id));
    }

    /** Converte o modelo recebido no JSON ({"id":1}) no modelo completo do banco. */
    private Modelo buscarModelo(Veiculo dados) {
        Long idModelo = dados.getModelo().getId();
        if (idModelo == null) {
            throw new RegraDeNegocioException("Informe o id do modelo. Exemplo: \"modelo\":{\"id\":1}");
        }
        return modeloService.buscar(idModelo);
    }

    private String vazioParaNulo(String texto) {
        return (texto == null || texto.isBlank()) ? null : texto.trim();
    }
}
