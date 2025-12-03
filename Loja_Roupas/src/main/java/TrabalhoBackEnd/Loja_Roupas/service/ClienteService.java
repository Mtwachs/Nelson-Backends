package TrabalhoBackEnd.Loja_Roupas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TrabalhoBackEnd.Loja_Roupas.model.Cliente;
import TrabalhoBackEnd.Loja_Roupas.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    
    // Buscar cliente por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
    
    public Cliente salvar(Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Email já cadastrado: " + cliente.getEmail());
        }
        
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new RuntimeException("CPF já cadastrado: " + cliente.getCpf());
        }
        
        return clienteRepository.save(cliente);
    }
    
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
            .map(cliente -> {
                if (!cliente.getEmail().equals(clienteAtualizado.getEmail()) 
                    && clienteRepository.existsByEmail(clienteAtualizado.getEmail())) {
                    throw new RuntimeException("Email já cadastrado: " + clienteAtualizado.getEmail());
                }
                
                if (!cliente.getCpf().equals(clienteAtualizado.getCpf()) 
                    && clienteRepository.existsByCpf(clienteAtualizado.getCpf())) {
                    throw new RuntimeException("CPF já cadastrado: " + clienteAtualizado.getCpf());
                }
                
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setCpf(clienteAtualizado.getCpf());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
                cliente.setPontuacao(clienteAtualizado.getPontuacao());
                return clienteRepository.save(cliente);
            })
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }
    
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        }
        clienteRepository.deleteById(id);
    }
    
    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }
}