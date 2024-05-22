package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheus.api.api.Model.SaidaManutencao;

@Repository
public interface SaidaManutencaoRepository extends JpaRepository<SaidaManutencao, Integer>{
    
}
