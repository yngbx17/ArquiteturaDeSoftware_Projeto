package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Observados {
    
    private List<String> listaItens;
    private List<Observadores> listaObservadores;
    private Estado estado;
    
    public Pedido (List <String> listaItens){
        this.listaItens = listaItens;
        estado = ListaEstados.PENDENTE;
        listaObservadores = new ArrayList<>();
    }
    public boolean temObservadores(){
        return !listaObservadores.isEmpty();
    }
    public void setEstado (Estado estado){
        if(estado != null) {
            this.estado = estado;
        }else{
            this.estado = ListaEstados.ENTREGUE;
        }
    }
    public void avancarEstado(){
        estado.proximoEstado(this);
    }
    
    @Override
    public void registrarObservadores (Observadores observadores){
        listaObservadores.add(observadores);
    }

    @Override
    public void removerObservadores(Observadores observadores) {
        listaObservadores.remove(observadores);
    }

    @Override
    public void notificarObservadores(String mensagem) {
        for (Observadores observador : listaObservadores){
            observador.atualizar(mensagem);
        }
    }

    @Override
    public String toString() {
        return "Pedido{" + "listaItens=" + listaItens + ", listaObservadores=" + listaObservadores + ", estado="
                + estado + '}';
    }
    
}
