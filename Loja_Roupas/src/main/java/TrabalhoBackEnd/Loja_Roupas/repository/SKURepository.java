package TrabalhoBackEnd.Loja_Roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TrabalhoBackEnd.Loja_Roupas.model.SKU;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SKURepository extends JpaRepository<SKU, UUID> {
    
    Optional<SKU> findByCodigoBarras(String codigoBarras);
    
    boolean existsByCodigoBarras(String codigoBarras);
}

