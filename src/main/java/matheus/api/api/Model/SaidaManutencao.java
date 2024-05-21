package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SaidaManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_saida;
    private Integer data;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_manutencao")
    private Integer manutencao;

    @ManyToOne
    @JoinColumn(name = "id_patrimonio")
    private Integer patrimonio;

    // getters and setters

    public Integer getId_saida() {
        return id_saida;
    }

    public void setId_saida(Integer id_saida) {
        this.id_saida = id_saida;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
