package matheus.api.api.Repository;

import matheus.api.api.Model.Administador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administador, Long>{
    
}
