package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cnpj_fornecedor;
    private String nome_fornecedor;

    // getters and setters

    public Integer getCnpj_fornecedor() {
        return cnpj_fornecedor;
    }

    public void setCnpj_fornecedor(Integer cnpj_fornecedor) {
        this.cnpj_fornecedor = cnpj_fornecedor;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

}
