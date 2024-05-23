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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.api.api.Model.BaixaManutencao;
import matheus.api.api.Service.BaixaManutencaoService;

@RestController
@RequestMapping("/baixaManutencao")
public class BaixaManutencaoController {

    @Autowired
    private BaixaManutencaoService baixaManutencaoService;

    @GetMapping
    public List<BaixaManutencao> getAllBaixaManutencoes() {
        return baixaManutencaoService.findAll();
    }

    @GetMapping("/{id_baixaManutencao}")
    public ResponseEntity<BaixaManutencao> getBaixaManutencaoById(@PathVariable Integer id_baixaManutencao) {
        Optional<BaixaManutencao> baixaManutencao = baixaManutencaoService.findById(id_baixaManutencao);
        return baixaManutencao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BaixaManutencao createBaixaManutencao(@RequestBody BaixaManutencao baixaManutencao) {
        return baixaManutencaoService.save(baixaManutencao);
    }

    @PutMapping("/{id_baixaManutencao}")
    public ResponseEntity<BaixaManutencao> updateBaixaManutencao(
            @PathVariable Integer id_baixaManutencao,
            @RequestBody BaixaManutencao baixaManutencaoDetails) {

        Optional<BaixaManutencao> baixaManutencaoOptional = baixaManutencaoService.findById(id_baixaManutencao);

        if (baixaManutencaoOptional.isPresent()) {
            BaixaManutencao baixaManutencao = baixaManutencaoOptional.get();
            baixaManutencao.setBaixaPatrimonio(baixaManutencaoDetails.getBaixaPatrimonio());
            baixaManutencao.setManutencao(baixaManutencaoDetails.getManutencao());

            final BaixaManutencao updatedBaixaManutencao = baixaManutencaoService.save(baixaManutencao);
            return ResponseEntity.ok(updatedBaixaManutencao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_baixaManutencao}")
    public ResponseEntity<BaixaManutencao> deleteBaixaManutencao(@PathVariable Integer id_baixaManutencao) {
        baixaManutencaoService.deleteById(id_baixaManutencao);
        return ResponseEntity.noContent().build();
    }
}
