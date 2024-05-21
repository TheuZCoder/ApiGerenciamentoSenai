package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BaixaManutencao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_baixaManutencao;
    
    @ManyToOne
    @JoinColumn(name = "id_baixa")
    private Integer baixa;
    
    @ManyToOne
    @JoinColumn(name = "id_manutencao")
    private Integer manutencao;
}
