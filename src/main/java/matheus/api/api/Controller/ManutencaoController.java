package matheus.api.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.api.api.Service.ManutencaoService;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
    
    @Autowired
    private ManutencaoService manutencaoService;
}
