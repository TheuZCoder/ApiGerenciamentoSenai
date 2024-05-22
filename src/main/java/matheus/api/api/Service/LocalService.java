package matheus.api.api.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import matheus.api.api.Model.Local;
import matheus.api.api.Repository.LocalRepository;

@Service
public class LocalService {
    
    @Autowired
    private LocalRepository localRepository;

    public List<Local> findAll(){
        return localRepository.findAll();
    }

    public Optional<Local> findById(Integer id_local){
        return localRepository.findById(id_local);
    }

    public Local save(Local local){
        return localRepository.save(local);
    }

    public void deleteById(Integer id_local){
        localRepository.deleteById(id_local);
    }
}
