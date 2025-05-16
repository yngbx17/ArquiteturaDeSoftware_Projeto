package modelo;


public interface Observados {
    
    public void registrarObservadores (Observadores observadores);
    public void removerObservadores (Observadores observadores);
    public void notificarObservadores (String mensagem);

    
}
