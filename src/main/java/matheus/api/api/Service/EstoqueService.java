package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Estoque;
import matheus.api.api.Repository.EstoqueRepository;

@Service
public class EstoqueService {
    
    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> findAll(){
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> findById(Integer id_estoque){
        return estoqueRepository.findById(id_estoque);
    }

    public Estoque save(Estoque estoque){
        return estoqueRepository.save(estoque);
    }

    public void deleteById(Integer id_estoque){
        estoqueRepository.deleteById(id_estoque);
    }
}
