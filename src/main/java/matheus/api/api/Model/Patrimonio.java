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
@Table(name = "patrimonio")

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
    private Local Local;

    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private BlocoPatrimonio BlocoPatrimonio;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoPatrimonio TipoPatrimonio;
}
