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
@Table(name = "saidaMaterial")
@Entity
public class SaidaMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_saidaMaterial;

    @Column(length = 10, nullable = false)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque Estoque;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material Material;
}
