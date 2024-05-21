package matheus.api.api.Model;

import jakarta.persistence.Entity;
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
    private Integer cpf_adm;
    private String nome_adm;
    private String email_adm;
    private String senha_adm;

}
