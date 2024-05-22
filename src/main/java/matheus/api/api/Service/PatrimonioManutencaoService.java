package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.PatrimonioManutencao;
import matheus.api.api.Repository.PatrimonioManutencaoRepository;

@Service
public class PatrimonioManutencaoService {
    
    @Autowired
    private PatrimonioManutencaoRepository patrimonioManutencaoRepository;

    public List<PatrimonioManutencao> findAll(){
        return patrimonioManutencaoRepository.findAll();
    }

    public Optional<PatrimonioManutencao> findById(Integer id_patrimonioManutencao){
        return patrimonioManutencaoRepository.findById(id_patrimonioManutencao);
    }

    public PatrimonioManutencao save(PatrimonioManutencao patrimonioManutencao){
        return patrimonioManutencaoRepository.save(patrimonioManutencao);
    }

    public void deleteById(Integer id_patrimonioManutencao){
        patrimonioManutencaoRepository.deleteById(id_patrimonioManutencao);
    }
}
