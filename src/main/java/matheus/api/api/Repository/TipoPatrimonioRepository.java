package matheus.api.api.Repository;

import matheus.api.api.Model.TipoPatrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPatrimonioRepository extends JpaRepository<TipoPatrimonio, Integer>{
    
}
