package matheus.api.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Repository.TipoPatrimonioRepository;

@Service
public class TipoPatrimonioService {

    @Autowired
    private TipoPatrimonioRepository tipoPatrimonioRepository;
}
