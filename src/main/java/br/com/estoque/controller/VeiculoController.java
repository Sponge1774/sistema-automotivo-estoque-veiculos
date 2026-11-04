package br.com.estoque.controller;

import br.com.estoque.model.StatusVeiculo;
import br.com.estoque.model.TipoVeiculo;
import br.com.estoque.model.Veiculo;
import br.com.estoque.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Camada Controller: recebe as requisicoes HTTP de veiculos (CRUD e filtros) e devolve JSON. */
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    /** Lista todos os veiculos ou aplica filtros opcionais, por exemplo ?marca=Toyota&ano=2022. */
    @GetMapping
    public List<Veiculo> listar(@RequestParam(required = false) String marca,
                                @RequestParam(required = false) String modelo,
                                @RequestParam(required = false) Double precoMin,
                                @RequestParam(required = false) Double precoMax,
                                @RequestParam(required = false) Integer ano,
                                @RequestParam(required = false) StatusVeiculo status,
                                @RequestParam(required = false) TipoVeiculo tipo) {
        return service.filtrar(marca, modelo, precoMin, precoMax, ano, status, tipo);
    }

    @GetMapping("/{id}")
    public Veiculo buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo criar(@Valid @RequestBody Veiculo veiculo) {
        return service.criar(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
        return service.atualizar(id, veiculo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
