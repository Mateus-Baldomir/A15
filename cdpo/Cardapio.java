import java.util.Scanner;

public class Cardapio {
    public static void main(String[] args){
    
    Scanner ler = new Scanner(System.in);


    String codigo, produto, opcao;
    float valor;
      
    System.out.printf("Deseja cadastrar um novo produto?");
        opcao = ler.nextLine();

    if (opcao.equals("Sim")){
        System.out.printf("Código: ");
        codigo = ler.nextLine();
    
        System.out.printf("Produto: ");
        produto = ler.nextLine();
    
        System.out.printf("Valor: ");
        valor = ler.nextFloat();
    
        System.out.printf("Código: %s\n", codigo);
        System.out.printf("Produto: %s\n", produto);
        System.out.printf("Produto: %.2f\n", valor);
    }
    else if (opcao.equals("Não")){
     }
    
    }
}
