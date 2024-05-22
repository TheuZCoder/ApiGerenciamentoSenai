package matheus.api.api.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.api.api.Model.Transferencia;
import matheus.api.api.Repository.TransferenciaRepository;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findAll(){
        return transferenciaRepository.findAll();
    }

    public Optional<Transferencia> findById(Integer id_transferencia){
        return transferenciaRepository.findById(id_transferencia);
    }

    public Transferencia save(Transferencia transferencia){
        return transferenciaRepository.save(transferencia);
    }

    public void deleteById(Integer id_transferencia){
        transferenciaRepository.deleteById(id_transferencia);
    }
    
}
