package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PatrimonioManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_PatrimonioManutencao;

    @ManyToOne
    @JoinColumn(name = "id_manutencao")
    private Integer manutencao;

    @ManyToOne
    @JoinColumn(name = "id_patrimonio")
    private Integer patrimonio;

    private String defeito;

    // getters and setters

    public Integer getId_PatrimonioManutencao() {
        return id_PatrimonioManutencao;
    }

    public void setId_PatrimonioManutencao(Integer id_PatrimonioManutencao) {
        this.id_PatrimonioManutencao = id_PatrimonioManutencao;
    }

    public Integer getManutencao() {
        return manutencao;
    }

    public void setManutencao(Integer manutencao) {
        this.manutencao = manutencao;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Integer patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

}
