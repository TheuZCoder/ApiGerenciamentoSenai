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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import matheus.api.api.Model.Transferencia;
import matheus.api.api.Service.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {
    
    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> getAllTransferencia(){
        return transferenciaService.findAll();
    }

    @GetMapping("/{id_transferencia}")
    public ResponseEntity<Transferencia> getTransferenciaById(@PathVariable Integer id_transferencia){
        Optional<Transferencia> transferencia = transferenciaService.findById(id_transferencia);
        return transferencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transferencia createTransferencia(Transferencia transferencia){
        return transferenciaService.save(transferencia);
    }

    @PutMapping("/{id_transferencia}")
    public ResponseEntity<Transferencia> updateTransferencia(
            @PathVariable Integer id_transferencia,
            Transferencia transferenciaDetails) {
        
        Optional<Transferencia> transferenciaOptional = transferenciaService.findById(id_transferencia);

        if (transferenciaOptional.isPresent()) {
            Transferencia transferencia = transferenciaOptional.get();
            transferencia.setData_transferencia(transferenciaDetails.getData_transferencia());
            
            final Transferencia updatedTransferencia = transferenciaService.save(transferencia);
            return ResponseEntity.ok(updatedTransferencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_transferencia}")
    public ResponseEntity<Void> deleteTransferencia(@PathVariable Integer id_transferencia){
        transferenciaService.deleteById(id_transferencia);
        return ResponseEntity.noContent().build();
    }
}
