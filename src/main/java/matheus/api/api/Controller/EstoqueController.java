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
import matheus.api.api.Model.Estoque;
import matheus.api.api.Service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> getAllEstoques(){
        return estoqueService.findAll();
    }

    @GetMapping("/{id_estoque}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Integer id_estoque){
        Optional<Estoque> estoque = estoqueService.findById(id_estoque);
        return estoque.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque){
        return estoqueService.save(estoque);
    }

    @PutMapping("/{id_estoque}")
    public ResponseEntity<Estoque> updateEstoque(
            @PathVariable Integer id_estoque,
            @RequestBody Estoque estoqueDetails) {
        
        Optional<Estoque> estoqueOptional = estoqueService.findById(id_estoque);

        if (estoqueOptional.isPresent()) {
            Estoque estoque = estoqueOptional.get();
            estoque.setMaterial(estoqueDetails.getMaterial());
            estoque.setQuantidade(estoqueDetails.getQuantidade());
            
            final Estoque updatedEstoque = estoqueService.save(estoque);
            return ResponseEntity.ok(updatedEstoque);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_estoque}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Integer id_estoque){
        estoqueService.deleteById(id_estoque);
        return ResponseEntity.noContent().build();  
    }
}
