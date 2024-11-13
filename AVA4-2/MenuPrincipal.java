import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private JFrame principal;
    private JTextArea areaTrabalho;
    private CadastroUsuario cadastroUsuario;
    private CadastroPessoa cadastroPessoa;

    public MenuPrincipal() {
        cadastroUsuario = new CadastroUsuario();
        cadastroPessoa = new CadastroPessoa();

        principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent e) { }
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        areaTrabalho = new JTextArea();
        JPanel painelRodape = new JPanel();
        painelRodape.add(new JLabel("Sistema Pessoa"));

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        itemMenuCadastroUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroUsuarios();
            }
        });
        itemMenuCadastroPessoas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroPessoas();
            }
        });
        itemMenuVisualizacaoListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListaUsuarios();
            }
        });
        itemMenuVisualizacaoListaPessoas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListaPessoas();
            }
        });

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }

    private void abrirCadastroUsuarios() {
        String usuario = JOptionPane.showInputDialog("Digite o nome de usuário:");
        String senha = JOptionPane.showInputDialog("Digite a senha:");
        String email = JOptionPane.showInputDialog("Digite o email:");
        boolean ativo = JOptionPane.showConfirmDialog(null, "Ativo?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        Usuario novoUsuario = new Usuario(usuario, senha, email, ativo);
        cadastroUsuario.adicionarUsuario(novoUsuario);
        JOptionPane.showMessageDialog(principal, "Usuário cadastrado com sucesso!");
    }

    private void abrirCadastroPessoas() {
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String endereco = JOptionPane.showInputDialog("Digite o endereço:");
        String cidade = JOptionPane.showInputDialog("Digite a cidade:");
        String uf = JOptionPane.showInputDialog("Digite a UF:");
        String email = JOptionPane.showInputDialog("Digite o email:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone:");
        String sexo = JOptionPane.showInputDialog("Digite o sexo (Masculino/Feminino):");

        Pessoa novaPessoa = new Pessoa(nome, endereco, cidade, uf, email, telefone, sexo);
        cadastroPessoa.adicionarPessoa(novaPessoa);
        JOptionPane.showMessageDialog(principal, "Pessoa cadastrada com sucesso!");
    }

    private void abrirListaUsuarios() {
        areaTrabalho.setText("");
        cadastroUsuario.listarUsuarios();
    }

    private void abrirListaPessoas() {
        areaTrabalho.setText("");
        cadastroPessoa.listarPessoas();
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
