package TrabalhoBackEnd.Loja_Roupas.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import TrabalhoBackEnd.Loja_Roupas.model.PedidoVenda;
import TrabalhoBackEnd.Loja_Roupas.model.StatusPedido;
import TrabalhoBackEnd.Loja_Roupas.service.PedidoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoVenda>> listar() {
        List<PedidoVenda> pedidos = pedidoService.listarTodos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoVenda> buscar(@PathVariable UUID id) {
        return pedidoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PedidoVenda> criar(@Valid @RequestBody PedidoVenda pedido) {
        try {
            PedidoVenda pedidoSalvo = pedidoService.salvar(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoVenda> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody PedidoVenda pedido) {
        try {
            PedidoVenda pedidoAtualizado = pedidoService.atualizar(id, pedido);
            return ResponseEntity.ok(pedidoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            pedidoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PedidoVenda> atualizarStatus(
            @PathVariable UUID id,
            @RequestParam StatusPedido status) {
        try {
            PedidoVenda pedidoAtualizado = pedidoService.atualizarStatus(id, status);
            return ResponseEntity.ok(pedidoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<PedidoVenda>> buscarPorStatus(@PathVariable StatusPedido status) {
        List<PedidoVenda> pedidos = pedidoService.buscarPorStatus(status);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoVenda>> buscarPorCliente(@PathVariable UUID clienteId) {
        List<PedidoVenda> pedidos = pedidoService.buscarPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }
}