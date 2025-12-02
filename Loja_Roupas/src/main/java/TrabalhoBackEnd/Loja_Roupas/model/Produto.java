package TrabalhoBackEnd.Loja_Roupas;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @NotNull(message = "Preço base é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço base deve ser maior que zero")
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal precoBase;

    @Column(nullable = false)
    private Boolean ativo = true;

    @NotNull(message = "Categoria é obrigatória")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;

    @NotNull(message = "Marca é obrigatória")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Marca marca;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SKU> skus = new LinkedHashSet<>();

    public Produto() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Set<SKU> getSkus() {
        return skus;
    }

    public void addSku(SKU sku) {
        this.skus.add(sku);
        sku.setProduto(this);
    }
}