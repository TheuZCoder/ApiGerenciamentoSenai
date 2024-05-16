package matheus.api.api.Repository;

import matheus.api.api.Model.BlocoPatrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoPatrimonioRepository extends JpaRepository<BlocoPatrimonio, Long>{
    
}
