public class Pessoa {
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String email;
    private String telefone;
    private String sexo;

    // Construtor
    public Pessoa(String nome, String endereco, String cidade, String uf, String email, String telefone, String sexo) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Endereço: " + endereco + ", Cidade: " + cidade + ", UF: " + uf + ", Email: " + email;
    }
}
