package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Manutencao;
import matheus.api.api.Repository.ManutencaoRepository;

@Service
public class ManutencaoService {
    
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public List<Manutencao> findAll(){
        return manutencaoRepository.findAll();
    }

    public Optional<Manutencao> findById(Integer id_manutencao){
        return manutencaoRepository.findById(id_manutencao);
    }

    public Manutencao save(Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }

    public void deleteById(Integer id_manutencao){
        manutencaoRepository.deleteById(id_manutencao);
    }
}
