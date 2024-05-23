package matheus.api.api.Model;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;
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
@Table(name = "saidaManutencao")
@Entity
public class SaidaManutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_saidaManutencao;

    @Column(length = 10, nullable = false)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date data;

    @Column(length = 100, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_manutencao")
    private Manutencao Manutencao;

    @ManyToOne
    @JoinColumn(name = "id_patrimonio")
    private Patrimonio Patrimonio;
}
