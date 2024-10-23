import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaPessoa {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Sistema de Pessoa");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem itemUsuarios = new JMenuItem("Usuários");
        JMenuItem itemPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemUsuarios);
        menuCadastro.add(itemPessoas);

        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem itemListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemListaUsuarios);
        menuVisualizacao.add(itemListaPessoas);

        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(itemSair);

        janela.setJMenuBar(menuBar);

        JLabel rotuloRodape = new JLabel("------------------------------------------------------------------------------------------------");
        janela.add(rotuloRodape, BorderLayout.SOUTH);

        itemUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroUsuarios();
            }
        });

        janela.setSize(400, 300);
        janela.setVisible(true);
    }

    private static void abrirJanelaCadastroUsuarios() {
        JFrame janelaCadastro = new JFrame("Cadastro de Usuários");
        janelaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaCadastro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST; 

        gbc.gridx = 0; 
        gbc.gridy = 0; 
        janelaCadastro.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1; 
        JTextField campoNome = new JTextField(15);
        janelaCadastro.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1; 
        janelaCadastro.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField campoEmail = new JTextField(15);
        janelaCadastro.add(campoEmail, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 2; 
        janelaCadastro.add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1; 
        JPasswordField campoSenha = new JPasswordField(15);
        janelaCadastro.add(campoSenha, gbc);

        gbc.anchor = GridBagConstraints.EAST; 
        gbc.fill = GridBagConstraints.NONE; 
        gbc.gridwidth = 2; 
        gbc.gridy = 3; 

        JPanel painelBotoes = new JPanel(); 
        JButton botaoIncluir = new JButton("Incluir");
        JButton botaoAlterar = new JButton("Alterar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoConsultar = new JButton("Consultar");
        JButton botaoCancelar = new JButton("Cancelar");
        JButton botaoSair = new JButton("Sair");

        botaoIncluir.addActionListener(e -> mostrarMensagem("Incluir"));
        botaoAlterar.addActionListener(e -> mostrarMensagem("Alterar"));
        botaoExcluir.addActionListener(e -> mostrarMensagem("Excluir"));
        botaoConsultar.addActionListener(e -> mostrarMensagem("Consultar"));
        botaoCancelar.addActionListener(e -> mostrarMensagem("Cancelar"));
        botaoSair.addActionListener(e -> janelaCadastro.dispose()); 

        painelBotoes.add(botaoIncluir);
        painelBotoes.add(botaoAlterar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoConsultar);
        painelBotoes.add(botaoCancelar);
        painelBotoes.add(botaoSair);

        janelaCadastro.add(painelBotoes, gbc);

        janelaCadastro.pack();
        janelaCadastro.setLocationRelativeTo(null); 
        janelaCadastro.setVisible(true);
    }

    private static void mostrarMensagem(String acao) {
        JOptionPane.showMessageDialog(null, "Botão " + acao + " clicado!");
    }
}
