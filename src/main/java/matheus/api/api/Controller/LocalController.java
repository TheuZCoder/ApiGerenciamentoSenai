package matheus.api.api.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
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

import matheus.api.api.Model.Local;
import matheus.api.api.Service.LocalService;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public List<Local> getAllLocais() {
        return localService.findAll();
    }

    @GetMapping("/{id_local}")
    public ResponseEntity<Local> getLocalById(@PathVariable Integer id_local) {
        Optional<Local> local = localService.findById(id_local);
        return local.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Local createLocal(@RequestBody Local local) {
        return localService.save(local);
    }

    @PutMapping("/{id_local}")
    public ResponseEntity<Local> updateLocal(
            @PathVariable Integer id_local,
            @RequestBody Local localDetails) {

        Optional<Local> localOptional = localService.findById(id_local);

        if (localOptional.isPresent()) {
            Local local = localOptional.get();
            local.setNome_local(localDetails.getNome_local());
            local.setUsuario(localDetails.getUsuario());

            final Local updatedLocal = localService.save(local);
            return ResponseEntity.ok(updatedLocal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_local}")
    public ResponseEntity<Local> deleteLocal(@PathVariable Integer id_local) {
        localService.deleteById(id_local);
        return ResponseEntity.ok().build();
    }
}
