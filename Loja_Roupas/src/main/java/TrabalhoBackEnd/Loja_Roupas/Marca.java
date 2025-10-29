package TrabalhoBackEnd.Loja_Roupas;


import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Marca {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;


    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
    private Set<Produto> produtos = new LinkedHashSet<>();


    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Produto> getProdutos() { return produtos; }
}
