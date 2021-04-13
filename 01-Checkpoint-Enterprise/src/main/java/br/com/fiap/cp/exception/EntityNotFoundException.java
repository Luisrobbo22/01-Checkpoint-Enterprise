package main.java.br.com.fiap.cp.exception;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
        super("Entidade não encontrada");
    }

    public EntityNotFoundException(String msg) {
        super(msg);
    }

}
