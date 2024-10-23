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

        janela.setSize(400, 300);
        janela.setVisible(true);
    }
}
