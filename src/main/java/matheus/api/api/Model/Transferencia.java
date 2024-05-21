package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transferencia;

    @ManyToOne
    @JoinColumn(name = "id_patrimonio")
    private Integer patrimonio;

    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Integer bloco;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private Integer local;

    private Integer data_transferencia;

    // getters and setters

    public Integer getId_transferencia() {
        return id_transferencia;
    }

    public void setId_transferencia(Integer id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Integer patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Integer getBloco() {
        return bloco;
    }

    public void setBloco(Integer bloco) {
        this.bloco = bloco;
    }

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }

    public Integer getData_transferencia() {
        return data_transferencia;
    }

    public void setData_transferencia(Integer data_transferencia) {
        this.data_transferencia = data_transferencia;
    }

}
