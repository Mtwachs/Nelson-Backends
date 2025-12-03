package TrabalhoBackEnd.Loja_Roupas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TrabalhoBackEnd.Loja_Roupas.model.Marca;
import TrabalhoBackEnd.Loja_Roupas.repository.MarcaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodos() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> buscarPorId(UUID id) {
        return marcaRepository.findById(id);
    }

    public Marca salvar(Marca marca) {
        if (marcaRepository.existsByNome(marca.getNome())) {
            throw new RuntimeException("Marca já existe: " + marca.getNome());
        }
        return marcaRepository.save(marca);
    }

    public Marca atualizar(UUID id, Marca marcaAtualizada) {
        Optional<Marca> existente = marcaRepository.findById(id);

        if (existente.isPresent()) {
            Marca marca = existente.get();
            marca.setNome(marcaAtualizada.getNome());
            return marcaRepository.save(marca);
        }

        return null;
    }

    public boolean deletar(UUID id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
