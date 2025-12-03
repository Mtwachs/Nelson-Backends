package TrabalhoBackEnd.Loja_Roupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import TrabalhoBackEnd.Loja_Roupas.model.Marca;

import java.util.UUID;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, UUID> {

    boolean existsByNome(String nome);

}
