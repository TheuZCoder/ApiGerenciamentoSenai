package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.TipoPatrimonio;
import matheus.api.api.Repository.TipoPatrimonioRepository;

@Service
public class TipoPatrimonioService {

    @Autowired
    private TipoPatrimonioRepository tipoPatrimonioRepository;

    public List<TipoPatrimonio> findAll(){
        return tipoPatrimonioRepository.findAll();
    }
    
    public Optional<TipoPatrimonio> findById(Integer id_tipo_patrimonio){
        return tipoPatrimonioRepository.findById(id_tipo_patrimonio);
    }

    public TipoPatrimonio save(TipoPatrimonio tipoPatrimonio){
        return tipoPatrimonioRepository.save(tipoPatrimonio);
    }

    public void deleteById(Integer id_tipo_patrimonio){
        tipoPatrimonioRepository.deleteById(id_tipo_patrimonio);
    }
}
