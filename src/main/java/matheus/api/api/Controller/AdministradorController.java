package matheus.api.api.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.Administrador;
import matheus.api.api.Service.AdministradorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> getAllAdministradores(){
        return administradorService.findAll();
    }

    @GetMapping("/{id_adm}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Integer id_administrador){
        Optional<Administrador> administrador = administradorService.findById(id_administrador);
        return administrador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Administrador createAdministrador(@RequestBody Administrador administrador){
        return administradorService.save(administrador);
    }
    
    @PutMapping("/{id_adm}")
    public ResponseEntity<Administrador> updateAdministrador(
            @PathVariable Integer cpf_adm,
            @RequestBody Administrador administradorDetails) {
        
        Optional<Administrador> administradorOptional = administradorService.findById(cpf_adm);

        if (administradorOptional.isPresent()) {
            Administrador administrador = administradorOptional.get();
            administrador.setCpf_adm(administradorDetails.getCpf_adm());
            administrador.setNome_adm(administradorDetails.getNome_adm());
            administrador.setEmail_adm(administradorDetails.getEmail_adm());
            administrador.setSenha_adm(administradorDetails.getSenha_adm());
            
            final Administrador updatedAdministrador = administradorService.save(administrador);
            return ResponseEntity.ok(updatedAdministrador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id_adm}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Integer id_administrador){
        administradorService.deleteById(id_administrador);
        return ResponseEntity.noContent().build();
    }
}