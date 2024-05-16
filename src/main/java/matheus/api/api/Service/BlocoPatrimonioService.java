package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.BlocoPatrimonio;
import matheus.api.api.Repository.BlocoPatrimonioRepository;

@Service
public class BlocoPatrimonioService {
    
    @Autowired
    private BlocoPatrimonioRepository blocoPatrimonioRepository;

    public List<BlocoPatrimonio> findAll() {
        return blocoPatrimonioRepository.findAll();
    }

    public Optional<BlocoPatrimonio> findById(Integer id_bloco_patrimonio) {
        return blocoPatrimonioRepository.findById(id_bloco_patrimonio);
    }

    public BlocoPatrimonio save(BlocoPatrimonio blocoPatrimonio) {
        return blocoPatrimonioRepository.save(blocoPatrimonio);
    }

    public void deleteById(Integer id_bloco_patrimonio) {
        blocoPatrimonioRepository.deleteById(id_bloco_patrimonio);
    }
}
