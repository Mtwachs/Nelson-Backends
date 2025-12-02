package TrabalhoBackEnd.Loja_Roupas.controller;

import TrabalhoBackEnd.Loja_Roupas.Produto;
import TrabalhoBackEnd.Loja_Roupas.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

  
    @GetMapping
    public ResponseEntity<List<Produto>> list() {
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Produto> show(@PathVariable UUID id) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    
    @PostMapping
    public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable UUID id, 
                                          @Valid @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizar(id, produto);
        
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deletado = produtoService.deletar(id);
        
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}