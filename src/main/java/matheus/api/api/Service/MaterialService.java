package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.api.api.Model.Material;
import matheus.api.api.Repository.MaterialRepository;

@Service
public class MaterialService {
    
    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll(){
        return materialRepository.findAll();
    }

    public Optional<Material> findById(Integer id_material){
        return materialRepository.findById(id_material);
    }

    public Material save(Material material){
        return materialRepository.save(material);
    }

    public void deleteById(Integer id_material){
        materialRepository.deleteById(id_material);
    }
}
