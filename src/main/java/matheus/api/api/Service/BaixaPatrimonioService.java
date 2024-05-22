package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.BaixaPatrimonio;
import matheus.api.api.Repository.BaixaPatrimonioRepository;

@Service
public class BaixaPatrimonioService {
    
    @Autowired
    private BaixaPatrimonioRepository baixaPatrimonioRepository;

    public List<BaixaPatrimonio> findAll(){
        return baixaPatrimonioRepository.findAll();
    }

    public Optional<BaixaPatrimonio> findById(Integer id_baixa){
        return baixaPatrimonioRepository.findById(id_baixa);
    }

    public BaixaPatrimonio save(BaixaPatrimonio baixaPatrimonio){
        return baixaPatrimonioRepository.save(baixaPatrimonio);
    }

    public void deleteById(Integer id_baixa){
        baixaPatrimonioRepository.deleteById(id_baixa);
    }
}
