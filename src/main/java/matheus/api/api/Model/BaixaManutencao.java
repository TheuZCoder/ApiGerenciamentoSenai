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
@Table(name = "baixaManutencao")
@Entity
public class BaixaManutencao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_baixaManutencao;
    
    @ManyToOne
    @JoinColumn(name = "id_baixa")
    private BaixaPatrimonio BaixaPatrimonio;
    
    @ManyToOne
    @JoinColumn(name = "id_manutencao")
    private Manutencao Manutencao;
}
