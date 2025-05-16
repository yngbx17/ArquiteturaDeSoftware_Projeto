package controle;

import java.util.Scanner;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Observadores;
import modelo.Fachada;

public class Controle{

   Fachada fachada = new Fachada();
   Scanner sc = new Scanner (System.in);
   
   public void operacoes (int opc){
       switch (opc){
           case 1: 
               System.out.println("Digite o item");
               fachada.adicionarItem(sc.nextLine());
               break;
           case 2:
               fachada.realizarPedido();
               System.out.println("Pedido realizado com sucesso!");
               break;
               
           case 3:    
               if (fachada.temPedido()){
                   System.out.println("Adicionar observadores de pedido");
                   System.out.println("[1] - Cliente\n[2] - Funcionario");
                   System.out.println("<<");
                   Observadores observador = null;
                   int tipo = sc.nextInt();
                   sc.nextLine();
                   if(tipo == 1){
                       System.out.println("Digite o nome do cliente");
                       observador = new Cliente(sc.nextLine());
                   } else if (tipo == 2){
                       System.out.println("Digite o nome do funcionário");
                       observador = new Funcionario(sc.nextLine());
                   }else {
                       System.out.println("Opção invalida");
                   }
                   fachada.adicionarObservadores(observador);
               }else{
                   System.out.println("Não há pedido!");
               }
               break;
               
           case 4: System.out.println("Alterar estado do pedido");
           fachada.alterarEstadoPedido();
           break;
           
           case 5:
               fachada.exibir();
               break;
        }
    }          
}

