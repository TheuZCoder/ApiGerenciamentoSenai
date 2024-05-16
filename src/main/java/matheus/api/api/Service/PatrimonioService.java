package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Patrimonio;
import matheus.api.api.Repository.PatrimonioRepository;

@Service
public class PatrimonioService {
    
    @Autowired
    private PatrimonioRepository patrimonioRepository;

    public List<Patrimonio> findAll(){
        return patrimonioRepository.findAll();
    }

    public Optional<Patrimonio> findById(Integer id_patrimonio){
        return patrimonioRepository.findById(id_patrimonio);
    }

    public Patrimonio save(Patrimonio patrimonio){
        return patrimonioRepository.save(patrimonio);
    }

    public void deleteById(Integer id_patrimonio){
        patrimonioRepository.deleteById(id_patrimonio);
    }
}
