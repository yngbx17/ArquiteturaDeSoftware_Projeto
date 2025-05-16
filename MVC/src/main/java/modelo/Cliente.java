package modelo;

public class Cliente implements Observadores{
    private String nome;
    
    public Cliente (String nome) {
        this.nome = nome;
    }
    @Override
    public void atualizar(String mensagem){
        System.out.println("Cliente " + nome + ": O seu pedido " + mensagem);
    }
}
