package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Usuario;
import matheus.api.api.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id_usuario){
        return usuarioRepository.findById(id_usuario);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id_usuario){
        usuarioRepository.deleteById(id_usuario);
    }

    public Usuario buscarPorCpfESenha(Long cpf_usuario, String senha_usuario) {
        return usuarioRepository.findByCpfAndSenha(cpf_usuario, senha_usuario);
    }
}
