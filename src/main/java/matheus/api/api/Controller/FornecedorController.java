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
import matheus.api.api.Model.Fornecedor;
import matheus.api.api.Service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> getAllFornecedores(){
        return fornecedorService.findAll();
    }

    @GetMapping("/{id_fornecedor}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Integer id_fornecedor){
        Optional<Fornecedor> fornecedor = fornecedorService.findById(id_fornecedor);
        return fornecedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor){
        return fornecedorService.save(fornecedor);
    }

    @PutMapping("/{id_fornecedor}")
    public ResponseEntity<Fornecedor> updateFornecedor(
            @PathVariable Integer id_fornecedor,
            @RequestBody Fornecedor fornecedorDetails) {
        
        Optional<Fornecedor> fornecedorOptional = fornecedorService.findById(id_fornecedor);

        if (fornecedorOptional.isPresent()) {
            Fornecedor fornecedor = fornecedorOptional.get();
            fornecedor.setCnpj_fornecedor(fornecedorDetails.getCnpj_fornecedor());
            fornecedor.setNome_fornecedor(fornecedorDetails.getNome_fornecedor());
            
            final Fornecedor updatedFornecedor = fornecedorService.save(fornecedor);
            return ResponseEntity.ok(updatedFornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id_fornecedor}")
    public ResponseEntity<Fornecedor> deleteFornecedor(@PathVariable Integer id_fornecedor){
        fornecedorService.deleteById(id_fornecedor);
        return ResponseEntity.noContent().build();
    }
}
