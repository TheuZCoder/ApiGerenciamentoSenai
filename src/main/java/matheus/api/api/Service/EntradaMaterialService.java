package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.EntradaMaterial;
import matheus.api.api.Repository.EntradaMaterialRepository;

@Service
public class EntradaMaterialService {
    
    @Autowired
    private EntradaMaterialRepository entradaMaterialRepository;

    public List<EntradaMaterial> findAll(){
        return entradaMaterialRepository.findAll();
    }

    public Optional<EntradaMaterial> findById(Integer id_entrada){
        return entradaMaterialRepository.findById(id_entrada);
    }

    public EntradaMaterial save(EntradaMaterial entradaMaterial){
        return entradaMaterialRepository.save(entradaMaterial);
    }

    public void deleteById(Integer id_entrada){
        entradaMaterialRepository.deleteById(id_entrada);
    }
}
