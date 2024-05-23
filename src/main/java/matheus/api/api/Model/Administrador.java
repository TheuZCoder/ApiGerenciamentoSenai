package matheus.api.api.Model;

import jakarta.persistence.Column;
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
@Table(name = "administrador")
@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_adm;

    @Column(length = 11, nullable = false, unique = true)
    private Long cpf_adm;

    @Column(length = 35, nullable = false)
    private String nome_adm;

    @Column(length = 35, nullable = false)
    private String email_adm;

    @Column(length = 22, nullable = false)
    private String senha_adm;

}
