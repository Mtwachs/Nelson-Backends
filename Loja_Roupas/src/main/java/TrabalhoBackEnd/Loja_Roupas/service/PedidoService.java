package TrabalhoBackEnd.Loja_Roupas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TrabalhoBackEnd.Loja_Roupas.model.PedidoVenda;
import TrabalhoBackEnd.Loja_Roupas.model.StatusPedido;
import TrabalhoBackEnd.Loja_Roupas.repository.ClienteRepository;
import TrabalhoBackEnd.Loja_Roupas.repository.PedidoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<PedidoVenda> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoVenda> buscarPorId(UUID id) {
        return pedidoRepository.findById(id);
    }

    public PedidoVenda salvar(PedidoVenda pedido) {
        if (pedido.getCliente() != null && pedido.getCliente().getId() != null) {
            if (!clienteRepository.existsById(pedido.getCliente().getId())) {
                throw new RuntimeException("Cliente não encontrado com id: " + pedido.getCliente().getId());
            }
        }

        if (pedido.getData() == null) {
            pedido.setData(LocalDateTime.now());
        }

        if (pedido.getStatus() == null) {
            pedido.setStatus(StatusPedido.ABERTO);
        }

        pedido.calcularTotal();
        return pedidoRepository.save(pedido);
    }

    public PedidoVenda atualizar(UUID id, PedidoVenda pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    if (pedidoAtualizado.getCliente() != null && pedidoAtualizado.getCliente().getId() != null) {
                        if (!clienteRepository.existsById(pedidoAtualizado.getCliente().getId())) {
                            throw new RuntimeException("Cliente não encontrado com id: " + pedidoAtualizado.getCliente().getId());
                        }
                        pedido.setCliente(pedidoAtualizado.getCliente());
                    }

                    if (pedidoAtualizado.getStatus() != null) {
                        pedido.setStatus(pedidoAtualizado.getStatus());
                    }

                    if (pedidoAtualizado.getItens() != null) {
                        pedido.setItens(pedidoAtualizado.getItens());
                    }

                    pedido.calcularTotal();
                    return pedidoRepository.save(pedido);
                })
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com id: " + id));
    }

    public PedidoVenda atualizarStatus(UUID id, StatusPedido novoStatus) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setStatus(novoStatus);
                    return pedidoRepository.save(pedido);
                })
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com id: " + id));
    }

    public void deletar(UUID id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com id: " + id);
        }
        pedidoRepository.deleteById(id);
    }

    public List<PedidoVenda> buscarPorStatus(StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }

    public List<PedidoVenda> buscarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}
