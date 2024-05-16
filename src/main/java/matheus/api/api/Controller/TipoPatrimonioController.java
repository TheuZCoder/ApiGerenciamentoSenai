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
import matheus.api.api.Model.TipoPatrimonio;
import matheus.api.api.Service.TipoPatrimonioService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/tipoPatrimonio")
public class TipoPatrimonioController {
    
    @Autowired
    private TipoPatrimonioService tipoPatrimonioService;

    @GetMapping
    public List<TipoPatrimonio> getAllTipoPatrimonio(){
        return tipoPatrimonioService.findAll();
    }

    @GetMapping("/{id_tipo_patrimonio}")
    public ResponseEntity<TipoPatrimonio> getTipoPatrimonioById(@PathVariable Integer id_tipo_patrimonio){
        Optional<TipoPatrimonio> tipoPatrimonio = tipoPatrimonioService.findById(id_tipo_patrimonio);
        return tipoPatrimonio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoPatrimonio createTipoPatrimonio(@RequestBody TipoPatrimonio tipoPatrimonio){
        return tipoPatrimonioService.save(tipoPatrimonio);
    }

    /*@PutMapping("/{id_tipo_patrimonio}")
    public ResponseEntity<TipoPatrimonio> updateTipoPatrimonio(@PathVariable Integer id_tipo_patrimonio, @RequestBody TipoPatrimonio tipoPatrimonio){   
    }*/

    @DeleteMapping("/{id_tipo_patrimonio}")
    public ResponseEntity<Void> deleteTipoPatrimonio(@PathVariable Integer id_tipo_patrimonio){
        tipoPatrimonioService.deleteById(id_tipo_patrimonio);
        return ResponseEntity.noContent().build();
    }    
}