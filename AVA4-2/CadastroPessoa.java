import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {
    private List<Pessoa> pessoas;

    public CadastroPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
        } else {
            pessoas.forEach(System.out::println);
        }
    }

    public Pessoa buscarPessoa(String nomePessoa) {
        return pessoas.stream()
                .filter(p -> p.getNome().equals(nomePessoa))
                .findFirst()
                .orElse(null);
    }
}
