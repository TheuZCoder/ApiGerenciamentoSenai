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

import matheus.api.api.Model.BaixaPatrimonio;
import matheus.api.api.Service.BaixaPatrimonioService;

@RestController
@RequestMapping("/baixaPatrimonio")
public class BaixaPatrimonioController {

    @Autowired
    private BaixaPatrimonioService baixaPatrimonioService;

    @GetMapping
    public List<BaixaPatrimonio> getAllBaixaPatrimonios(){
        return baixaPatrimonioService.findAll();
    }

    @GetMapping("/{id_baixaPatrimonio}")
    public ResponseEntity<BaixaPatrimonio> getBaixaPatrimonioById(@PathVariable Integer id_baixaPatrimonio){
        Optional<BaixaPatrimonio> baixaPatrimonio = baixaPatrimonioService.findById(id_baixaPatrimonio);
        return baixaPatrimonio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BaixaPatrimonio createBaixaPatrimonio(@RequestBody BaixaPatrimonio baixaPatrimonio){
        return baixaPatrimonioService.save(baixaPatrimonio);
    }

    @PutMapping("/{id_baixaPatrimonio}")
    public ResponseEntity<BaixaPatrimonio> updateBaixaPatrimonio(
            @PathVariable Integer id_baixaPatrimonio,
            @RequestBody BaixaPatrimonio baixaPatrimonioDetails) {
        
        Optional<BaixaPatrimonio> baixaPatrimonioOptional = baixaPatrimonioService.findById(id_baixaPatrimonio);

        if (baixaPatrimonioOptional.isPresent()) {
            BaixaPatrimonio baixaPatrimonio = baixaPatrimonioOptional.get();
            baixaPatrimonio.setData(baixaPatrimonioDetails.getData());
            baixaPatrimonio.setMotivo(baixaPatrimonioDetails.getMotivo());
            
            final BaixaPatrimonio updatedBaixaPatrimonio = baixaPatrimonioService.save(baixaPatrimonio);
            return ResponseEntity.ok(updatedBaixaPatrimonio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_baixaPatrimonio}")
    public ResponseEntity<BaixaPatrimonio> deleteBaixaPatrimonio(@PathVariable Integer id_baixaPatrimonio){
        baixaPatrimonioService.deleteById(id_baixaPatrimonio);
        return ResponseEntity.noContent().build();
    }        
    
}
