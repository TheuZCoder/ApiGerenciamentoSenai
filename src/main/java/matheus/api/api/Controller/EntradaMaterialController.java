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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.EntradaMaterial;
import matheus.api.api.Service.EntradaMaterialService;

@RestController
@RequestMapping("/entradaMaterial")
public class EntradaMaterialController {
    
    @Autowired
    private EntradaMaterialService entradaMaterialService;
    
    @GetMapping
    public List<EntradaMaterial> getAllEntradaMateriais(){
        return entradaMaterialService.findAll();
    }

    @GetMapping("/{id_entrada}")
    public ResponseEntity<EntradaMaterial> getEntradaMaterialById(@PathVariable Integer id_entrada){
        Optional<EntradaMaterial> entradaMaterial = entradaMaterialService.findById(id_entrada);
        return entradaMaterial.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EntradaMaterial createEntradaMaterial(@RequestBody EntradaMaterial entradaMaterial){
        return entradaMaterialService.save(entradaMaterial);
    }

    @PutMapping("/{id_entrada}")
    public ResponseEntity<EntradaMaterial> updateEntradaMaterial(
            @PathVariable Integer id_entrada,
            @RequestBody EntradaMaterial entradaMaterialDetails) {
        
        Optional<EntradaMaterial> entradaMaterialOptional = entradaMaterialService.findById(id_entrada);

        if (entradaMaterialOptional.isPresent()) {
            EntradaMaterial entradaMaterial = entradaMaterialOptional.get();
            entradaMaterial.setData(entradaMaterialDetails.getData());
            entradaMaterial.setEstoque(entradaMaterialDetails.getEstoque());
            entradaMaterial.setFornecedor(entradaMaterialDetails.getFornecedor());
            
            final EntradaMaterial updatedEntradaMaterial = entradaMaterialService.save(entradaMaterial);
            return ResponseEntity.ok(updatedEntradaMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_entrada}")
    public ResponseEntity<Void> deleteEntradaMaterial(@PathVariable Integer id_entrada){
        entradaMaterialService.deleteById(id_entrada);
        return ResponseEntity.noContent().build();
    }

}
