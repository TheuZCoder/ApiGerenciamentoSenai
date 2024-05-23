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
import matheus.api.api.Model.SaidaManutencao;
import matheus.api.api.Service.SaidaManutencaoService;

@RestController
@RequestMapping("/saidaManutencao")
public class SaidaManutencaoController {
    
    @Autowired
    private SaidaManutencaoService saidaManutencaoService;

    @GetMapping
    public List<SaidaManutencao> getAllSaidaManutencao(){
        return saidaManutencaoService.findAll();
    }

    @GetMapping("/{id_saidaManutencao}")
    public ResponseEntity<SaidaManutencao> getSaidaManutencaoById(@PathVariable Integer id_saidaManutencao){
        Optional<SaidaManutencao> saidaManutencao = saidaManutencaoService.findById(id_saidaManutencao);
        return saidaManutencao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SaidaManutencao createSaidaManutencao(SaidaManutencao saidaManutencao){
        return saidaManutencaoService.save(saidaManutencao);
    }

    @PutMapping("/{id_saidaManutencao}")
    public ResponseEntity<SaidaManutencao> updateSaidaManutencao(
            @PathVariable Integer id_saidaManutencao,
            SaidaManutencao saidaManutencaoDetails) {
        
        Optional<SaidaManutencao> saidaManutencaoOptional = saidaManutencaoService.findById(id_saidaManutencao);

        if (saidaManutencaoOptional.isPresent()) {
            SaidaManutencao saidaManutencao = saidaManutencaoOptional.get();
            saidaManutencao.setData(saidaManutencaoDetails.getData());
            saidaManutencao.setDescricao(saidaManutencaoDetails.getDescricao());
            
            final SaidaManutencao updatedSaidaManutencao = saidaManutencaoService.save(saidaManutencao);
            return ResponseEntity.ok(updatedSaidaManutencao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_saidaManutencao}")
    public ResponseEntity<Void> deleteSaidaManutencao(@PathVariable Integer id_saidaManutencao){
        saidaManutencaoService.deleteById(id_saidaManutencao);
        return ResponseEntity.noContent().build();
    }
}
