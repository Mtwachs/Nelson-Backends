package TrabalhoBackEnd.Loja_Roupas;

import jakarta.persistence.*;

@Entity
public class Vendedor extends Pessoa {
    @Column(nullable = false, unique = true)
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
