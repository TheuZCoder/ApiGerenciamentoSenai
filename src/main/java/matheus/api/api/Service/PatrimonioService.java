package matheus.api.api.Service;

import java.util.List;
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
}
