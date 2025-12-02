package TrabalhoBackEnd.Loja_Roupas;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}