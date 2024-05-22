package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.BaixaPatrimonio;

@Repository
public interface BaixaPatrimonioRepository extends JpaRepository<BaixaPatrimonio, Integer>{
    
}
