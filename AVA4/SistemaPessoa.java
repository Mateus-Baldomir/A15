import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class SistemaPessoa {
    public static void main(String[] args) {
        new JanelaPrincipal().criarJanela();
    }
}

class JanelaPrincipal {
    private String versaoSistema = "12.1.2024";
    private String nomeUsuario = "denys.silva";
    private String dataAcesso;

    public JanelaPrincipal() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.dataAcesso = dateFormat.format(new Date());
    }

    public void criarJanela() {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        JMenuBar menuPrincipal = criarMenuPrincipal();
        JTextArea areaTrabalho = new JTextArea();
        JPanel painelRodape = criarPainelRodape();

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }

    private JMenuBar criarMenuPrincipal() {
        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}
            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        menuCadastro.add(new JMenuItem("Usuários"));
        menuCadastro.add(new JMenuItem("Pessoas"));
        menuVisualizacao.add(new JMenuItem("Lista de usuários"));
        menuVisualizacao.add(new JMenuItem("Lista de pessoas"));

        return menuPrincipal;
    }

    private JPanel criarPainelRodape() {
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
        return painelRodape;
    }
}

class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}

class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }
}

class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, int idade, String cargo) {
        super(nome, idade);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
