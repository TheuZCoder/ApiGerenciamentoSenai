package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "saidaMaterial")
@Entity
public class SaidaMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_saidaMaterial;
    private Integer data;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque Estoque;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material Material;
}
