package TrabalhoBackEnd.Loja_Roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TrabalhoBackEnd.Loja_Roupas.model.PedidoVenda;
import TrabalhoBackEnd.Loja_Roupas.model.StatusPedido;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoVenda, UUID> {

    List<PedidoVenda> findByStatus(StatusPedido status);

    List<PedidoVenda> findByClienteId(UUID clienteId);
}