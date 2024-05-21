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
@Table(name = "EntradaMaterial")
@Entity
public class EntradaMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrada;

    private Integer data;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque Estoque;

    @ManyToOne
    @JoinColumn(name = "cnpj_fornecedor")
    private Fornecedor Fornecedor;
}
