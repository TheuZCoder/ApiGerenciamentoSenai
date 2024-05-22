package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{
    
}
