package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_patrimonio;
    private String img_patrimonio;
    private String descricao_patrimonio;
    private String nome_patrimonio;
    private String status_patrimonio;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private Integer local;

    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private Integer bloco;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Integer tipo;

    // getters and setters

    public Integer getId_patrimonio() {
        return id_patrimonio;
    }

    public void setId_patrimonio(Integer id_patrimonio) {
        this.id_patrimonio = id_patrimonio;
    }

    public String getImg_patrimonio() {
        return img_patrimonio;
    }

    public void setImg_patrimonio(String img_patrimonio) {
        this.img_patrimonio = img_patrimonio;
    }

    public String getDescricao_patrimonio() {
        return descricao_patrimonio;
    }

    public void setDescricao_patrimonio(String descricao_patrimonio) {
        this.descricao_patrimonio = descricao_patrimonio;
    }

    public String getNome_patrimonio() {
        return nome_patrimonio;
    }

    public void setNome_patrimonio(String nome_patrimonio) {
        this.nome_patrimonio = nome_patrimonio;
    }

    public String getStatus_patrimonio() {
        return status_patrimonio;
    }

    public void setStatus_patrimonio(String status_patrimonio) {
        this.status_patrimonio = status_patrimonio;
    }

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }

    public Integer getBloco() {
        return bloco;
    }

    public void setBloco(Integer bloco) {
        this.bloco = bloco;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
