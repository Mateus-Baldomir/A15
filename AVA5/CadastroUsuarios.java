import javax.swing.*;
import java.awt.*;

public class CadastroUsuarios {
    private final JFrame principal;

    public CadastroUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Method Overloading
    public void cadastrarUsuario(String nome, String email) {
        JOptionPane.showMessageDialog(principal, 
            "Usuário cadastrado com sucesso!\nNome: " + nome + "\nEmail: " + email);
    }

    public void cadastrarUsuario(String nome, String email, boolean ativo) {
        JOptionPane.showMessageDialog(principal, 
            "Usuário cadastrado com sucesso!\nNome: " + nome + "\nEmail: " + email + "\nAtivo: " + (ativo ? "Sim" : "Não"));
    }

    public void exibir() {
        JDialog dialog = new JDialog(principal, "Cadastro de Usuários", true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários", SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField campoNome = new JTextField(25);
        JTextField campoEmail = new JTextField(30);
        JRadioButton checkAtivo = new JRadioButton();

        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(campoNome);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(campoEmail);
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(checkAtivo);

        dialog.add(painelCampos, BorderLayout.CENTER);

        JButton btnCadastrarSimples = new JButton("Cadastrar Simples");
        JButton btnCadastrarCompleto = new JButton("Cadastrar Completo");
        JButton btnFechar = new JButton("Fechar");

        btnCadastrarSimples.addActionListener(e -> {
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            cadastrarUsuario(nome, email); 
        });

        btnCadastrarCompleto.addActionListener(e -> {
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            boolean ativo = checkAtivo.isSelected();
            cadastrarUsuario(nome, email, ativo); 
        });

        btnFechar.addActionListener(e -> dialog.setVisible(false));

        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnCadastrarSimples);
        painelBotoes.add(btnCadastrarCompleto);
        painelBotoes.add(btnFechar);

        dialog.add(painelBotoes, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
