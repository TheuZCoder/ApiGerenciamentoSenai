package matheus.api.api.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.PatrimonioManutencao;
import matheus.api.api.Service.PatrimonioManutencaoService;

@RestController
@RequestMapping("/patrimonioManutencao")
public class PatrimonioManutencaoController {
    
    @Autowired
    private PatrimonioManutencaoService patrimonioManutencaoService;

    @GetMapping
    public List<PatrimonioManutencao> getAllPatrimonioManutencao(){
        return patrimonioManutencaoService.findAll();
    }

    @GetMapping("/{id_patrimonioManutencao}")
    public ResponseEntity<PatrimonioManutencao> getPatrimonioManutencaoById(@PathVariable Integer id_patrimonioManutencao){
        Optional<PatrimonioManutencao> patrimonioManutencao = patrimonioManutencaoService.findById(id_patrimonioManutencao);
        return patrimonioManutencao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PatrimonioManutencao createPatrimonioManutencao(PatrimonioManutencao patrimonioManutencao){
        return patrimonioManutencaoService.save(patrimonioManutencao);
    }

    @PutMapping("/{id_patrimonioManutencao}")
    public ResponseEntity<PatrimonioManutencao> updatePatrimonioManutencao(
            @PathVariable Integer id_patrimonioManutencao,
            PatrimonioManutencao patrimonioManutencaoDetails) {
        
        Optional<PatrimonioManutencao> patrimonioManutencaoOptional = patrimonioManutencaoService.findById(id_patrimonioManutencao);

        if (patrimonioManutencaoOptional.isPresent()) {
            PatrimonioManutencao patrimonioManutencao = patrimonioManutencaoOptional.get();
            patrimonioManutencao.setDefeito(patrimonioManutencaoDetails.getDefeito());
            
            final PatrimonioManutencao updatedPatrimonioManutencao = patrimonioManutencaoService.save(patrimonioManutencao);
            return ResponseEntity.ok(updatedPatrimonioManutencao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_patrimonioManutencao}")
    public ResponseEntity<PatrimonioManutencao> deletePatrimonioManutencao(@PathVariable Integer id_patrimonioManutencao){
        patrimonioManutencaoService.deleteById(id_patrimonioManutencao);
        return ResponseEntity.noContent().build();
    }
}
