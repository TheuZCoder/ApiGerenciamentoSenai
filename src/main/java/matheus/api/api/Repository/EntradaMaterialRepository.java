package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.EntradaMaterial;

@Repository
public interface EntradaMaterialRepository extends JpaRepository<EntradaMaterial, Integer>{
    
}
