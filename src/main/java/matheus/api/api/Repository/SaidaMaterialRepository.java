package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.SaidaMaterial;

@Repository
public interface SaidaMaterialRepository extends JpaRepository<SaidaMaterial, Integer>{
    
}
