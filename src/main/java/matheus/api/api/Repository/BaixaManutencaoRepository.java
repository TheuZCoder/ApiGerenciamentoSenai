package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.BaixaManutencao;

@Repository
public interface BaixaManutencaoRepository extends JpaRepository<BaixaManutencao, Integer>{
    
}
