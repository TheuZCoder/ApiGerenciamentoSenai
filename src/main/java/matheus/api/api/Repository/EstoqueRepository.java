package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
    
}
