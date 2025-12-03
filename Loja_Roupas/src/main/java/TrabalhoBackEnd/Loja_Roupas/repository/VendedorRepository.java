package TrabalhoBackEnd.Loja_Roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TrabalhoBackEnd.Loja_Roupas.model.Vendedor;

import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    
    Optional<Vendedor> findByEmail(String email);
    
    Optional<Vendedor> findByMatricula(String matricula);
    
    boolean existsByEmail(String email);
    
    boolean existsByMatricula(String matricula);
}

