package matheus.api.api.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.BlocoPatrimonio;
import matheus.api.api.Service.BlocoPatrimonioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/blocopatrimonio")
public class BlocoPatrimonioController {
    
    @Autowired
    private BlocoPatrimonioService blocoPatrimonioService;

    @GetMapping
    public List<BlocoPatrimonio> getAllBlocoPatrimonio(){
        return blocoPatrimonioService.findAll();
    }
    
    @GetMapping("/id_bloco_patrimonio")
    public ResponseEntity<BlocoPatrimonio> getBlocoPatrimonioById(@PathVariable Integer id_bloco_patrimonio){
        Optional<BlocoPatrimonio> blocoPatrimonio = blocoPatrimonioService.findById(id_bloco_patrimonio);
        return blocoPatrimonio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BlocoPatrimonio createBlocoPatrimonio(@RequestBody BlocoPatrimonio blocoPatrimonio){
        return blocoPatrimonioService.save(blocoPatrimonio);
    }

    /*
    @PutMapping("/{id_bloco_patrimonio}")
    public ResponseEntity<BlocoPatrimonio> updateBlocoPatrimonio(@PathVariable)
    }  AJUSTAR CODIGO DE ATUALIZAÇÃO QUANDO OBTER O BANCO JA MODELADO*/
    

    @DeleteMapping("/{id_bloco_patrimonio}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Integer id_bloco_patrimonio){
        blocoPatrimonioService.deleteById(id_bloco_patrimonio);
        return ResponseEntity.noContent().build();
    }
}
