package TrabalhoBackEnd.Loja_Roupas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TrabalhoBackEnd.Loja_Roupas.model.Pedido;
import TrabalhoBackEnd.Loja_Roupas.model.StatusPedido;
import TrabalhoBackEnd.Loja_Roupas.repository.ClienteRepository;
import TrabalhoBackEnd.Loja_Roupas.repository.PedidoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
    
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    
    public Pedido salvar(Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new RuntimeException("Cliente não informado");
        }
        
        if (!clienteRepository.existsById(pedido.getCliente().getId())) {
            throw new RuntimeException("Cliente não encontrado com id: " + pedido.getCliente().getId());
        }
        
        if (pedido.getDataPedido() == null) {
            pedido.setDataPedido(LocalDateTime.now());
        }
        
        if (pedido.getStatus() == null) {
            pedido.setStatus(StatusPedido.ABERTO);
        }
        
        return pedidoRepository.save(pedido);
    }
    
    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
            .map(pedido -> {
                if (pedidoAtualizado.getCliente() != null 
                    && pedidoAtualizado.getCliente().getId() != null) {
                    if (!clienteRepository.existsById(pedidoAtualizado.getCliente().getId())) {
                        throw new RuntimeException("Cliente não encontrado com id: " 
                            + pedidoAtualizado.getCliente().getId());
                    }
                    pedido.setCliente(pedidoAtualizado.getCliente());
                }
                
                pedido.setStatus(pedidoAtualizado.getStatus());
                pedido.setValorTotal(pedidoAtualizado.getValorTotal());
                pedido.setObservacoes(pedidoAtualizado.getObservacoes());
                
                
                return pedidoRepository.save(pedido);
            })
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado com id: " + id));
    }
    
    public Pedido atualizarStatus(Long id, StatusPedido novoStatus) {
        return pedidoRepository.findById(id)
            .map(pedido -> {
                pedido.setStatus(novoStatus);
                return pedidoRepository.save(pedido);
            })
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado com id: " + id));
    }
    
    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com id: " + id);
        }
        pedidoRepository.deleteById(id);
    }
    
    public List<Pedido> buscarPorStatus(StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }
    
    public List<Pedido> buscarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}