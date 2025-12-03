package TrabalhoBackEnd.Loja_Roupas.controller;

import TrabalhoBackEnd.Loja_Roupas.model.Marca;
import TrabalhoBackEnd.Loja_Roupas.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> list() {
        List<Marca> marcas = marcaService.listarTodos();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> show(@PathVariable UUID id) {
        Optional<Marca> marca = marcaService.buscarPorId(id);
        if (marca.isPresent()) {
            return ResponseEntity.ok(marca.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Marca> save(@Valid @RequestBody Marca marca) {
        Marca salvo = marcaService.salvar(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable UUID id, @Valid @RequestBody Marca marca) {
        Marca atualizado = marcaService.atualizar(id, marca);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deletado = marcaService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
