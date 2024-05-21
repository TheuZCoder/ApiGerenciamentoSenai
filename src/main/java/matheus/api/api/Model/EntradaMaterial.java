package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EntradaMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrada;

    private Integer data;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "cnpj_fornecedor")
    private Integer fornecedor;

    // getters and setters

    public Integer getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(Integer id_entrada) {
        this.id_entrada = id_entrada;
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

    public Integer getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Integer fornecedor) {
        this.fornecedor = fornecedor;
    }
}
