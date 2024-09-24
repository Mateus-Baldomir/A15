import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    private String codigo;
    private String nome;
    private boolean ativo;
    private double preco;

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo.toUpperCase();
        this.nome = nome;
        this.ativo = true;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getPreco() {
        return preco;
    }

    
    public String toString() {
        return String.format("%s\t\t%s\t\tR$%.2f", codigo, nome, preco);
    }
}

public class SistemaCardapio {
    private List<Produto> produtos;

    public SistemaCardapio() {
        produtos = new ArrayList<>();
    }

    public void cadastrarProduto(String codigo, String nome, double preco) {
        if (codigo.length() != 6 || preco <= 0) {
            System.out.println("Erro: Dados inválidos.");
            return;
        }
        produtos.add(new Produto(codigo, nome, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listarProdutos() {
        System.out.println("Código\t\tProduto\t\tValor");
        System.out.println("---------------------------------------");
        for (Produto produto : produtos) {
            if (produto.isAtivo()) {
                System.out.println(produto);
            }
        }
    }

    public void excluirProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produto.setAtivo(false);
                System.out.println("Produto excluído com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public static void main(String[] args) {
        SistemaCardapio sistema = new SistemaCardapio();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Fechar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    sistema.cadastrarProduto(codigo, nome, preco);
                    break;

                case 2:
                    sistema.listarProdutos();
                    break;

                case 3:
                    System.out.print("Código do Produto a ser excluído: ");
                    String codigoExcluir = scanner.nextLine();
                    sistema.excluirProduto(codigoExcluir);
                    break;

                case 4:
                    System.out.println("Fechando.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
