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
import matheus.api.api.Model.Usuario;
import matheus.api.api.Service.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id_usuario){
        Optional<Usuario> usuario = usuarioService.findById(id_usuario);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    /*@PutMapping("/{id_usuario}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id_usuario){
    }*/

    @DeleteMapping
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id_usuario){
        usuarioService.deleteById(id_usuario);
        return ResponseEntity.noContent().build();
    }
}