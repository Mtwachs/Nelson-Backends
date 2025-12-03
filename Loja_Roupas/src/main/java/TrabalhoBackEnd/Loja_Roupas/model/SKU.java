package TrabalhoBackEnd.Loja_Roupas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class SKU {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String codigoBarras;

    @Column(nullable = false)
    private String tamanho;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal precoVenda;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    public SKU() {
    }

    public UUID getId() {
        return id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}