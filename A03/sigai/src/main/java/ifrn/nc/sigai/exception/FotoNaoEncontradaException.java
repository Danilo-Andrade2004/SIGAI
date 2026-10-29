package ifrn.nc.sigai.exception;

public class FotoNaoEncontradaException extends RuntimeException{
    public FotoNaoEncontradaException(Long id){
        super("Foto não encontrada: "+id);
    }
}