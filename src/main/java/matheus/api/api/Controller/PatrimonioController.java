package matheus.api.api.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.Patrimonio;
import matheus.api.api.Service.PatrimonioService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {
    
    @Autowired
    private PatrimonioService patrimonioService;

    @GetMapping
    public List<Patrimonio> getAllPatrimonio(){
        return patrimonioService.findAll();
    }

    @GetMapping("/{id_patrimonio}")
    public ResponseEntity<Patrimonio> getPatrimonioById(@PathVariable Integer id_patrimonio){
        Optional<Patrimonio> patrimonio = patrimonioService.findById(id_patrimonio);
        return patrimonio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Patrimonio createPatrimonio(@RequestBody Patrimonio patrimonio){
        return patrimonioService.save(patrimonio);
    }

    /*@PutMapping("/{id_patrimonio}")
    public ResponseEntity<Patrimonio> updatePatrimonio(@PathVariable Integer id_patrimonio){
    } */

    @DeleteMapping("/{id_patrimonio}")
    public ResponseEntity<Void> deletePatrimonio(@PathVariable Integer id_patrimonio){
        patrimonioService.deleteById(id_patrimonio);
        return ResponseEntity.noContent().build();
    }
}