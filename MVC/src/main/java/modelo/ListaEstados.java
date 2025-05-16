package modelo;


public enum ListaEstados implements Estado{
    PENDENTE {
        @Override
        public void proximoEstado(Pedido pedido){
            pedido.setEstado(SEPARACAO);
            pedido.notificarObservadores(" esta em separação!");
        }
    },SEPARACAO{
         @Override 
         public void proximoEstado (Pedido pedido){
             pedido.setEstado(ROTA);
             pedido.notificarObservadores (" está em rota de entrega!");
             
         }
},ROTA {
    @Override
    public void proximoEstado (Pedido pedido){
        pedido.setEstado(ENTREGUE);
        pedido.notificarObservadores(" está entregue!");
    }
            
},ENTREGUE{
    @Override 
    public void proximoEstado (Pedido pedido){
        pedido.setEstado(null);
        pedido.notificarObservadores("foi entregue com sucesso!");
    }
};

}

