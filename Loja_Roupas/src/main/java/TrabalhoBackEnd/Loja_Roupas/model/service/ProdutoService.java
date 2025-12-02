package TrabalhoBackEnd.Loja_Roupas.service;

import TrabalhoBackEnd.Loja_Roupas.Produto;
import TrabalhoBackEnd.Loja_Roupas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(UUID id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(UUID id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPrecoBase(produtoAtualizado.getPrecoBase());
            produto.setAtivo(produtoAtualizado.getAtivo());
            produto.setCategoria(produtoAtualizado.getCategoria());
            produto.setMarca(produtoAtualizado.getMarca());
            return produtoRepository.save(produto);
        }
        
        return null;
    }

    public boolean deletar(UUID id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}