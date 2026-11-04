package br.com.estoque.exception;

/** Lancada quando um registro (marca, modelo ou veiculo) nao existe. Vira resposta 404. */
public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
