package matheus.api.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Service.TipoPatrimonioService;

@RestController
@RequestMapping("/tipoPatrimonio")
public class TipoPatrimonioController {
    
    @Autowired
    private TipoPatrimonioService tipoPatrimonioService;
}
