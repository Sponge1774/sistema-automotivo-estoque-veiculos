package br.com.estoque.exception;

/** Lancada quando uma regra do sistema e violada (por exemplo, marca repetida). Vira resposta 400. */
public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
}
