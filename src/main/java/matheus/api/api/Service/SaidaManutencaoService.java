package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.api.api.Model.SaidaManutencao;
import matheus.api.api.Repository.SaidaManutencaoRepository;

@Service
public class SaidaManutencaoService {
    
    @Autowired
    private SaidaManutencaoRepository saidaManutencaoRepository;

    public List<SaidaManutencao> findAll(){
        return saidaManutencaoRepository.findAll();
    }

    public Optional<SaidaManutencao> findById(Integer id_saidaManutencao){
        return saidaManutencaoRepository.findById(id_saidaManutencao);
    }

    public SaidaManutencao save(SaidaManutencao saidaManutencao){
        return saidaManutencaoRepository.save(saidaManutencao);
    }

    public void deleteById(Integer id_saidaManutencao){
        saidaManutencaoRepository.deleteById(id_saidaManutencao);
    }
}
