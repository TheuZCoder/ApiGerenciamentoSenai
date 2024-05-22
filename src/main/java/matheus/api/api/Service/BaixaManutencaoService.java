package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.BaixaManutencao;
import matheus.api.api.Repository.BaixaManutencaoRepository;

@Service
public class BaixaManutencaoService {
    
    @Autowired
    private BaixaManutencaoRepository baixaManutencaoRepository;

    public List<BaixaManutencao> findAll(){
        return baixaManutencaoRepository.findAll();
    }

    public Optional<BaixaManutencao> findById(Integer id_baixaManutencao){
        return baixaManutencaoRepository.findById(id_baixaManutencao);
    }

    public BaixaManutencao save(BaixaManutencao baixaManutencao){
        return baixaManutencaoRepository.save(baixaManutencao);
    }

    public void deleteById(Integer id_baixaManutencao){
        baixaManutencaoRepository.deleteById(id_baixaManutencao);
    }
}
