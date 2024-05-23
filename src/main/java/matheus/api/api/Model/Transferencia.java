package matheus.api.api.Model;

import jakarta.persistence.Column;
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
@Table(name = "transferencia")
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transferencia;

    @ManyToOne
    @JoinColumn(name = "id_patrimonio")
    private Patrimonio Patrimonio;

    @ManyToOne
    @JoinColumn(name = "id_bloco")
    private BlocoPatrimonio BlocoPatrimonio;

    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local Local;

    @Column(length = 45, nullable = false)
    private Integer data_transferencia;
}
