package matheus.api.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import matheus.api.api.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    @Query("SELECT u FROM Usuario u WHERE u.cpf_usuario = ?1 AND u.senha_usuario = ?2")
    Usuario findByCpfAndSenha(Long cpf_usuario, String senha_usuario);
}