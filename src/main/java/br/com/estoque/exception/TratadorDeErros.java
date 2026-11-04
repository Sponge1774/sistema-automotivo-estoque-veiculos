package br.com.estoque.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Transforma erros em respostas JSON claras, no formato {"erro": "mensagem"},
 * em vez de mostrar a pilha de erros do Java ao usuario da API.
 */
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> naoEncontrado(RecursoNaoEncontradoException ex) {
        return resposta(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Map<String, Object>> regraDeNegocio(RegraDeNegocioException ex) {
        return resposta(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /** Falha de validacao das anotacoes (@NotBlank, @NotNull, @Min...). */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> validacao(MethodArgumentNotValidException ex) {
        Map<String, String> campos = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(erro -> campos.putIfAbsent(erro.getField(), erro.getDefaultMessage()));
        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("erro", "Dados invalidos");
        corpo.put("campos", campos);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(corpo);
    }

    /** JSON mal formado ou valor recusado pelos setters (por exemplo, preco negativo). */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> corpoInvalido(HttpMessageNotReadableException ex) {
        Throwable causa = ex.getMostSpecificCause();
        String mensagem;
        if (causa instanceof IllegalArgumentException) {
            mensagem = causa.getMessage();
        } else if (causa instanceof InvalidFormatException formato) {
            var caminho = formato.getPath();
            String campo = caminho.isEmpty() ? "?" : caminho.get(caminho.size() - 1).getFieldName();
            mensagem = "Valor invalido para o campo '" + campo + "': " + formato.getValue();
        } else if (causa instanceof JsonMappingException) {
            mensagem = "Dados invalidos no corpo da requisicao";
        } else {
            mensagem = "Corpo da requisicao invalido (confira o JSON enviado)";
        }
        return resposta(HttpStatus.BAD_REQUEST, mensagem);
    }

    /** Valor incorreto em um filtro da URL (por exemplo, status=XYZ). */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> parametroInvalido(MethodArgumentTypeMismatchException ex) {
        return resposta(HttpStatus.BAD_REQUEST,
                "Valor invalido para o parametro '" + ex.getName() + "': " + ex.getValue());
    }

    /** Por exemplo, tentar remover uma marca que ainda possui modelos. */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> integridade(DataIntegrityViolationException ex) {
        return resposta(HttpStatus.CONFLICT,
                "Operacao nao permitida: o registro esta em uso ou viola uma regra do banco de dados");
    }

    private ResponseEntity<Map<String, Object>> resposta(HttpStatus status, String mensagem) {
        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("erro", mensagem);
        return ResponseEntity.status(status).body(corpo);
    }
}
