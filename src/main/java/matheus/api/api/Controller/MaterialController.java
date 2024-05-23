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
import matheus.api.api.Model.Material;
import matheus.api.api.Service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.findAll();
    }

    @GetMapping("/{id_material}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer id_material) {
        Optional<Material> material = materialService.findById(id_material);
        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialService.save(material);
    }

    @PutMapping("/{id_material}")
    public ResponseEntity<Material> updateMaterial(
            @PathVariable Integer id_material,
            @RequestBody Material materialDetails) {

        Optional<Material> materialOptional = materialService.findById(id_material);

        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            material.setNome_material(materialDetails.getNome_material());

            final Material updatedMaterial = materialService.save(material);
            return ResponseEntity.ok(updatedMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_material}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable Integer id_material) {
        materialService.deleteById(id_material);
        return ResponseEntity.noContent().build();
    }

}
