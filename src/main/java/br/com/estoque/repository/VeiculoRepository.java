package br.com.estoque.repository;

import br.com.estoque.model.StatusVeiculo;
import br.com.estoque.model.TipoVeiculo;
import br.com.estoque.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    /**
     * Consulta com filtros opcionais: o filtro que vier vazio (null) e ignorado.
     * Assim, uma unica consulta atende marca, modelo, preco, ano, status e tipo.
     */
    @Query("""
            SELECT v FROM Veiculo v
            WHERE (:marca IS NULL OR LOWER(v.modelo.marca.nome) = LOWER(:marca))
              AND (:modelo IS NULL OR LOWER(v.modelo.nome) = LOWER(:modelo))
              AND (:precoMin IS NULL OR v.preco >= :precoMin)
              AND (:precoMax IS NULL OR v.preco <= :precoMax)
              AND (:ano IS NULL OR v.anoFabricacao = :ano)
              AND (:status IS NULL OR v.status = :status)
              AND (:tipo IS NULL OR v.tipo = :tipo)
            ORDER BY v.id
            """)
    List<Veiculo> filtrar(@Param("marca") String marca,
                          @Param("modelo") String modelo,
                          @Param("precoMin") Double precoMin,
                          @Param("precoMax") Double precoMax,
                          @Param("ano") Integer ano,
                          @Param("status") StatusVeiculo status,
                          @Param("tipo") TipoVeiculo tipo);
}
