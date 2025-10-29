package TrabalhoBackEnd.Loja_Roupas;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal precoUnit;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoVenda pedidoVenda;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id")
    private SKU sku;

    public UUID getId() { return id; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public BigDecimal getPrecoUnit() { return precoUnit; }
    public void setPrecoUnit(BigDecimal precoUnit) { this.precoUnit = precoUnit; }
    public PedidoVenda getPedidoVenda() { return pedidoVenda; }
    public void setPedidoVenda(PedidoVenda pedidoVenda) { this.pedidoVenda = pedidoVenda; }
    public SKU getSku() { return sku; }
    public void setSku(SKU sku) { this.sku = sku; }
}
