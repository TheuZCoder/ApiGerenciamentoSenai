package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tipoPatrimonio")

@Entity
public class TipoPatrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_patrimonio;
    private String nome_tipo;
}
