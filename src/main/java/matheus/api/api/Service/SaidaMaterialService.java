package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.api.api.Model.SaidaMaterial;
import matheus.api.api.Repository.SaidaMaterialRepository;

@Service
public class SaidaMaterialService {
    
    @Autowired
    private SaidaMaterialRepository saidaMaterialRepository;

    public List<SaidaMaterial> findAll(){
        return saidaMaterialRepository.findAll();
    }

    public Optional<SaidaMaterial> findById(Integer id_saidaMaterial){
        return saidaMaterialRepository.findById(id_saidaMaterial);
    }

    public SaidaMaterial save(SaidaMaterial saidaMaterial){
        return saidaMaterialRepository.save(saidaMaterial);
    }

    public void deleteById(Integer id_saidaMaterial){
        saidaMaterialRepository.deleteById(id_saidaMaterial);
    }
}
