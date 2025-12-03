package TrabalhoBackEnd.Loja_Roupas.repository;

import TrabalhoBackEnd.Loja_Roupas.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}