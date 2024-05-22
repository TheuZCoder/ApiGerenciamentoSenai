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
@Table(name = "baixaPatrimonio")
@Entity
public class BaixaPatrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id_baixaPatrimonio;
    private Integer data;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_patrimonio")
    private Patrimonio Patrimonio;

}
