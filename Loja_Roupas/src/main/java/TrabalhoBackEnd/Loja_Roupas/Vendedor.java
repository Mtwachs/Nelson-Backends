package TrabalhoBackEnd.Loja_Roupas;

public class Vendedor extends Pessoa {
    private String matricula;

    public Vendedor() {
        super();
    }

    public Vendedor(Long id, String nome, String email, String telefone, String matricula) {
        super(id, nome, email, telefone);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
