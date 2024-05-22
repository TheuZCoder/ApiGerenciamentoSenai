package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer>{
    
}
