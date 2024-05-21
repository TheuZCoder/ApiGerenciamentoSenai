package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BlocoPatrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bloco;
    private String nome_bloco;

    // getters and setters

    public Integer getId_bloco() {
        return id_bloco;
    }

    public void setId_bloco(Integer id_bloco) {
        this.id_bloco = id_bloco;
    }

    public String getNome_bloco() {
        return nome_bloco;
    }

    public void setNome_bloco(String nome_bloco) {
        this.nome_bloco = nome_bloco;
    }
}
