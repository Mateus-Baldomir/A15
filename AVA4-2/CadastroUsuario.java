import java.util.ArrayList;
import java.util.List;

public class CadastroUsuario {
    private List<Usuario> usuarios;

    public CadastroUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários cadastrados.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }

    public Usuario buscarUsuario(String usuarioNome) {
        return usuarios.stream()
                .filter(u -> u.getUsuario().equals(usuarioNome))
                .findFirst()
                .orElse(null);
    }
}
