package TrabalhoBackEnd.Loja_Roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TrabalhoBackEnd.Loja_Roupas.model.Pedido;
import TrabalhoBackEnd.Loja_Roupas.model.StatusPedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    // Métodos de busca customizados (opcionais)
    List<Pedido> findByStatus(StatusPedido status);
    
    List<Pedido> findByClienteId(Long clienteId);
}