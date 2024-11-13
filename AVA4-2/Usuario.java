public class Usuario {
    private String usuario;
    private String senha;
    private String email;
    private boolean ativo;

    // Construtor
    public Usuario(String usuario, String senha, String email, boolean ativo) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.ativo = ativo;
    }

    // Getters e setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario + ", Email: " + email + ", Ativo: " + ativo;
    }
}
