package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SaidaMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_saida;
    private Integer data;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Integer material;

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

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

}
