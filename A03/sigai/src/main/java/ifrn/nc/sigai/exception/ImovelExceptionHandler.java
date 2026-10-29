package ifrn.nc.sigai.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice 
public class ImovelExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ImovelNaoEncontradoException.class)
    public String handle(ImovelNaoEncontradoException ex){
        return ex.getMessage();
    }
}