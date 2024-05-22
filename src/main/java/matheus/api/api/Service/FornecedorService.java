package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Fornecedor;
import matheus.api.api.Repository.FornecedorRepository;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(Integer id_fornecedor){
        return fornecedorRepository.findById(id_fornecedor);
    }

    public Fornecedor save(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteById(Integer id_fornecedor){
        fornecedorRepository.deleteById(id_fornecedor);
    }
}
