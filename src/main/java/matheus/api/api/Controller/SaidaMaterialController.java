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
import matheus.api.api.Model.SaidaMaterial;
import matheus.api.api.Service.SaidaMaterialService;

@RestController
@RequestMapping("/saidaMaterial")
public class SaidaMaterialController {
    
    @Autowired
    private SaidaMaterialService saidaMaterialService;

    @GetMapping
    public List<SaidaMaterial> getAllSaidaMaterials(){
        return saidaMaterialService.findAll();
    }
    
    @GetMapping("/{id_saidaMaterial}")
    public ResponseEntity<SaidaMaterial> getSaidaMaterialById(@PathVariable Integer id_saidaMaterial){
        Optional<SaidaMaterial> saidaMaterial = saidaMaterialService.findById(id_saidaMaterial);
        return saidaMaterial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SaidaMaterial createSaidaMaterial(SaidaMaterial saidaMaterial){
        return saidaMaterialService.save(saidaMaterial);
    }

    @PutMapping
    public ResponseEntity<SaidaMaterial> updateSaidaMaterial(
            @PathVariable Integer id_saidaMaterial,
            SaidaMaterial saidaMaterialDetails) {
        
        Optional<SaidaMaterial> saidaMaterialOptional = saidaMaterialService.findById(id_saidaMaterial);

        if (saidaMaterialOptional.isPresent()) {
            SaidaMaterial saidaMaterial = saidaMaterialOptional.get();
            saidaMaterial.setData(saidaMaterialDetails.getData());
            
            final SaidaMaterial updatedSaidaMaterial = saidaMaterialService.save(saidaMaterial);
            return ResponseEntity.ok(updatedSaidaMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_saidaMaterial}")
    public ResponseEntity<Void> deleteSaidaMaterial(@PathVariable Integer id_saidaMaterial){
        saidaMaterialService.deleteById(id_saidaMaterial);
        return ResponseEntity.noContent().build();
    }
}
