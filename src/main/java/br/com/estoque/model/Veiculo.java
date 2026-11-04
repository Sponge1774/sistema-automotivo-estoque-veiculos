package br.com.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Year;

/**
 * Unidade fisica em estoque: entidade central do sistema.
 * Os atributos sao privados (encapsulamento) e os setters validam as regras
 * antes de alterar o estado do objeto.
 */
@Entity
@Table(name = "veiculo")
public class Veiculo extends EntidadeBase {

    @NotNull(message = "O modelo e obrigatorio")
    @ManyToOne(optional = false)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @NotNull(message = "O tipo do veiculo e obrigatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoVeiculo tipo;

    @Min(value = 1900, message = "Informe o ano de fabricacao (a partir de 1900)")
    @Column(nullable = false)
    private int anoFabricacao;

    @NotBlank(message = "A cor e obrigatoria")
    @Column(nullable = false, length = 30)
    private String cor;

    @Positive(message = "O preco deve ser maior que zero")
    @Column(nullable = false)
    private double preco;

    @Min(value = 0, message = "A quilometragem nao pode ser negativa")
    @Column(nullable = false)
    private int quilometragem;

    @NotNull(message = "O status e obrigatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusVeiculo status;

    /** Construtor sem argumentos: exigido pelo JPA e pelo Jackson. */
    public Veiculo() {
    }

    /** Construtor com os dados principais (sobrecarga de construtores). */
    public Veiculo(Modelo modelo, TipoVeiculo tipo, int anoFabricacao, String cor,
                   double preco, int quilometragem, StatusVeiculo status) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.cor = cor;
        this.status = status;
        setAnoFabricacao(anoFabricacao);
        setPreco(preco);
        setQuilometragem(quilometragem);
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        int limite = Year.now().getValue() + 1;
        if (anoFabricacao < 1900 || anoFabricacao > limite) {
            throw new IllegalArgumentException("Ano de fabricacao invalido: use um ano entre 1900 e " + limite);
        }
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preco invalido: o valor deve ser maior que zero");
        }
        this.preco = preco;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        if (quilometragem < 0) {
            throw new IllegalArgumentException("Quilometragem invalida: nao pode ser negativa");
        }
        this.quilometragem = quilometragem;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Veiculo{id=" + getId() + ", modelo=" + modelo + ", tipo=" + tipo
                + ", ano=" + anoFabricacao + ", cor='" + cor + "', preco=" + preco
                + ", km=" + quilometragem + ", status=" + status + "}";
    }
}
