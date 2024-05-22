package matheus.api.api.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.Manutencao;
import matheus.api.api.Service.ManutencaoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
    
    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping
    public List<Manutencao> getAllBlocoPatrimonio(){
        return manutencaoService.findAll();
    }
    
    @GetMapping("/{id_manutencao}")
    public ResponseEntity<Manutencao> getManutencaoById(@PathVariable Integer id_manutencao){
        Optional<Manutencao> manutencao = manutencaoService.findById(id_manutencao);
        return manutencao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Manutencao createManutencao(@RequestBody Manutencao manutencao){
        return manutencaoService.save(manutencao);
    }
    
    @PutMapping("/{id_manutencao}")
    public ResponseEntity<Manutencao> updateManutencao(
            @PathVariable Integer id_manutencao,
            @RequestBody Manutencao manutencaoDetails) {
        
        Optional<Manutencao> manutencaoOptional = manutencaoService.findById(id_manutencao);

        if (manutencaoOptional.isPresent()) {
            Manutencao manutencao = manutencaoOptional.get();
            manutencao.setStatus(manutencaoDetails.getStatus());
            manutencao.setDescricao(manutencaoDetails.getDescricao());
            
            final Manutencao updatedManutencao = manutencaoService.save(manutencao);
            return ResponseEntity.ok(updatedManutencao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_manutencao}")
    public ResponseEntity<Void> deleteManutencao(@PathVariable Integer id_manutencao){
        manutencaoService.deleteById(id_manutencao);
        return ResponseEntity.noContent().build();
    }
}