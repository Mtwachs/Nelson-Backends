package TrabalhoBackEnd.Loja_Roupas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TrabalhoBackEnd.Loja_Roupas.Categoria;
import TrabalhoBackEnd.Loja_Roupas.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(UUID id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria) {
        if (categoriaRepository.existsByNome(categoria.getNome())) {
            throw new RuntimeException("Categoria já existe: " + categoria.getNome());
        }
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(UUID id, Categoria categoriaAtualizada) {
        Optional<Categoria> existente = categoriaRepository.findById(id);

        if (existente.isPresent()) {
            Categoria categoria = existente.get();
            categoria.setNome(categoriaAtualizada.getNome());
            return categoriaRepository.save(categoria);
        }

        return null;
    }

    public boolean deletar(UUID id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
