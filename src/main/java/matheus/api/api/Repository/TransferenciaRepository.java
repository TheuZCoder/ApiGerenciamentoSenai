package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer>{
    
}
