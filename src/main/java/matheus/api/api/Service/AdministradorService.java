package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Administrador;
import matheus.api.api.Repository.AdministradorRepository;

@Service
public class AdministradorService {
    
    @Autowired  
    private AdministradorRepository administradorRepository;

    public List<Administrador> findAll(){
        return administradorRepository.findAll();
    }

    public Optional<Administrador> findById(Integer id_adm){
        return administradorRepository.findById(id_adm);
    }

    public Administrador save(Administrador administrador){
        return administradorRepository.save(administrador);
    }

    public void deleteById(Integer id_adm){
        administradorRepository.deleteById(id_adm);
    }
}
