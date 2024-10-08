import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class Produto {
    private String codigo;
    private String nome;
    private boolean ativo;
    private double preco;

    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo.toUpperCase();
        this.nome = nome.toUpperCase();
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

class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String dataNascimento;

    public Cliente(String nome, String endereco, String telefone, String email, String dataNascimento) {
        this.nome = nome.toUpperCase();
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String toString() {
        return String.format("Nome: %s, Endereço: %s, Telefone: %s, Email: %s, Nascimento: %s",
                nome, endereco, telefone, email, dataNascimento);
    }
}

public class SistemaCardapio extends JFrame {
    private List<Produto> produtos;
    private List<Cliente> clientes;

    
    private JTextArea areaTexto;

    public SistemaCardapio() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        criarJanela();
    }

    private void criarJanela() {
        setTitle("Sistema de Cardápio - PitDog");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 2, 10, 10));

        
        JButton botaoCadastrarProduto = new JButton("1. Cadastrar Produto");
        botaoCadastrarProduto.addActionListener(e -> abrirFormularioCadastrarProduto());
        painelBotoes.add(botaoCadastrarProduto);

        
        JButton botaoListarProdutos = new JButton("2. Listar Produtos");
        botaoListarProdutos.addActionListener(e -> listarProdutos());
        painelBotoes.add(botaoListarProdutos);

        
        JButton botaoExcluirProduto = new JButton("3. Excluir Produto");
        botaoExcluirProduto.addActionListener(e -> abrirFormularioExcluirProduto());
        painelBotoes.add(botaoExcluirProduto);

        
        JButton botaoCadastrarCliente = new JButton("4. Cadastrar Cliente");
        botaoCadastrarCliente.addActionListener(e -> abrirFormularioCadastrarCliente());
        painelBotoes.add(botaoCadastrarCliente);

        
        JButton botaoListarClientes = new JButton("5. Listar Clientes");
        botaoListarClientes.addActionListener(e -> listarClientes());
        painelBotoes.add(botaoListarClientes);

        
        JButton botaoFechar = new JButton("6. Fechar");
        botaoFechar.addActionListener(e -> fecharSistema());
        painelBotoes.add(botaoFechar);

        add(painelBotoes, BorderLayout.SOUTH);
        setVisible(true);
    }

    
    private void abrirFormularioCadastrarProduto() {
        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField campoCodigo = new JTextField();
        JTextField campoNome = new JTextField();
        JTextField campoPreco = new JTextField();

        painel.add(new JLabel("Código:"));
        painel.add(campoCodigo);

        painel.add(new JLabel("Nome do Produto:"));
        painel.add(campoNome);

        painel.add(new JLabel("Preço:"));
        painel.add(campoPreco);

        int result = JOptionPane.showConfirmDialog(null, painel, "Cadastrar Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String codigo = campoCodigo.getText();
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                cadastrarProduto(codigo, nome, preco);
            } catch (NumberFormatException e) {
                areaTexto.append("Erro: Preço inválido.\n");
            }
        }
    }

    
    private void abrirFormularioExcluirProduto() {
        String codigo = JOptionPane.showInputDialog(this, "Digite o código do produto a ser excluído:");
        if (codigo != null) {
            excluirProduto(codigo);
        }
    }

    
    private void abrirFormularioCadastrarCliente() {
        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        JTextField campoNomeCliente = new JTextField();
        JTextField campoEnderecoCliente = new JTextField();
        JTextField campoTelefoneCliente = new JTextField();
        JTextField campoEmailCliente = new JTextField();
        JTextField campoNascimentoCliente = new JTextField();

        painel.add(new JLabel("Nome do Cliente:"));
        painel.add(campoNomeCliente);

        painel.add(new JLabel("Endereço:"));
        painel.add(campoEnderecoCliente);

        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefoneCliente);

        painel.add(new JLabel("Email:"));
        painel.add(campoEmailCliente);

        painel.add(new JLabel("Data de Nascimento (dd/mm/aaaa):"));
        painel.add(campoNascimentoCliente);

        int result = JOptionPane.showConfirmDialog(null, painel, "Cadastrar Cliente",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            cadastrarCliente(campoNomeCliente.getText(), campoEnderecoCliente.getText(),
                    campoTelefoneCliente.getText(), campoEmailCliente.getText(),
                    campoNascimentoCliente.getText());
        }
    }

    
    public void cadastrarProduto(String codigo, String nome, double preco) {
        if (codigo.length() != 6 || nome.length() < 3 || nome.length() > 60 || preco <= 0) {
            areaTexto.append("Erro: Dados inválidos.\n");
            return;
        }
        produtos.add(new Produto(codigo, nome, preco));
        areaTexto.append("Produto cadastrado com sucesso!\n");
    }

    public void listarProdutos() {
        areaTexto.setText("Código\t\tProduto\t\tValor\n");
        areaTexto.append("------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (Produto produto : produtos) {
            if (produto.isAtivo()) {
                areaTexto.append(produto + "\n");
            }
        }
    }

    public void excluirProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produto.setAtivo(false);
                areaTexto.append("Produto excluído com sucesso!\n");
                return;
            }
        }
        areaTexto.append("Produto não encontrado.\n");
    }

    public void cadastrarCliente(String nome, String endereco, String telefone, String email, String dataNascimento) {
        if (nome.length() < 6 || nome.length() > 60 || !isAdult(dataNascimento)) {
            areaTexto.append("Erro: Dados inválidos.\n");
            return;
        }
        clientes.add(new Cliente(nome, endereco, telefone, email, dataNascimento));
        areaTexto.append("Cliente cadastrado com sucesso!\n");
    }

    public void listarClientes() {
        areaTexto.setText("Lista de Clientes:\n");
        for (Cliente cliente : clientes) {
            areaTexto.append(cliente + "\n");
        }
    }

    private boolean isAdult(String dataNascimento) {
        return true;
    }

    private void fecharSistema() {
        JOptionPane.showMessageDialog(this, "Fechando o sistema.");
        System.exit(0);
    }

    public static void main(String[] args) {
        new SistemaCardapio();
    }
}
